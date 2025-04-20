import { useState, useEffect } from 'react';
import fallaciesData from '../assets/fallacies.json';

/**
 * Custom hook to load and manage fallacies data
 * @returns {Object} Object containing fallacies data, loading state, and error state
 */
export function useFallacies() {
  const [fallacies, setFallacies] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    try {
      // In a real app, this might be an API call
      // For local JSON, we can directly use the imported data
      setFallacies(fallaciesData);
      setIsLoading(false);
    } catch (err) {
      setError(err.message);
      setIsLoading(false);
    }
  }, []);

  return { fallacies, isLoading, error };
} 