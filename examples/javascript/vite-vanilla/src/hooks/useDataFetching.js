import { useState, useEffect, useCallback, useRef } from 'react';

/**
 * Custom hook for fetching and managing data with search functionality
 * Implements debouncing, request cancellation, and proper cleanup
 * 
 * @param {string} initialQuery - Initial search query value (defaults to empty string)
 * @returns {Object} An object containing:
 *   @property {Array} data - The fetched data
 *   @property {boolean} loading - Loading state indicator
 *   @property {string|null} error - Error message or null if no error
 *   @property {string} query - Current search query
 *   @property {Function} setQuery - Function to update search query
 */
const useDataFetching = (initialQuery = '') => {
  // State management for data, loading, error, and search query
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [query, setQuery] = useState(initialQuery);

  // Refs for managing side effects and cleanup
  // AbortController ref persists across renders and allows cancelling in-flight requests
  const abortControllerRef = useRef(null);
  // Timer ref for managing debounce timeout
  const debounceTimerRef = useRef(null);

  /**
   * Core data fetching function
   * Handles both initial data load and search queries
   * Implements request cancellation for race condition prevention
   * 
   * @param {string} searchQuery - Query string for filtering data
   */
  const fetchData = useCallback(async (searchQuery) => {
    // Cancel any in-flight request before making a new one
    if (abortControllerRef.current) {
      abortControllerRef.current.abort();
    }
    
    // Create new AbortController for this request
    abortControllerRef.current = new AbortController();

    try {
      setLoading(true);
      setError(null);

      // Construct URL based on whether we're searching or fetching all
      const url = searchQuery 
        ? `https://jsonplaceholder.typicode.com/todos/${searchQuery}`
        : 'https://jsonplaceholder.typicode.com/todos';

      const response = await fetch(url, {
        signal: abortControllerRef.current.signal,
        headers: {
          'Content-Type': 'application/json',
        },
      });

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      const result = await response.json();
      // Normalize response to always be an array
      setData(Array.isArray(result) ? result : [result]);
    } catch (err) {
      // Ignore abort errors as they're expected during cancellation
      if (err.name === 'AbortError') {
        return;
      }
      setError(err.message);
    } finally {
      setLoading(false);
    }
  }, []);

  // Effect for initial data load
  // Runs once on mount and implements cleanup
  useEffect(() => {
    fetchData(''); // Initial fetch of all data
    
    // Cleanup function to prevent memory leaks and cancel pending operations
    return () => {
      if (abortControllerRef.current) {
        abortControllerRef.current.abort();
      }
      if (debounceTimerRef.current) {
        clearTimeout(debounceTimerRef.current);
      }
    };
  }, []); // Empty dependency array ensures single execution

  return {
    data,
    loading,
    error,
    query,
    /**
     * Updates search query and manages debounced API calls
     * Implements debouncing to prevent excessive API calls
     * Handles empty queries by reverting to full data set
     * 
     * @param {string} newQuery - New search query value
     */
    setQuery: (newQuery) => {
      setQuery(newQuery);
      
      // Clear any pending debounce timer
      if (debounceTimerRef.current) {
        clearTimeout(debounceTimerRef.current);
      }

      // Handle search query with debouncing
      if (newQuery.trim()) {
        debounceTimerRef.current = setTimeout(() => {
          fetchData(newQuery);
        }, 300); // 300ms debounce delay
      } else {
        // Immediate fetch for empty query
        fetchData('');
      }
    },
  };
};

export default useDataFetching;