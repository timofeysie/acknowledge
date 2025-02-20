import { useState, useMemo } from 'react';
import useDataFetching from "../hooks/useDataFetching";
import styles from './SearchComponent.module.css';

/**
 * SearchComponent - A component for displaying and filtering todo items
 * 
 * Features:
 * - Displays a list of todos with their completion status
 * - Allows filtering by todo ID through search input
 * - Allows filtering by user ID through dropdown
 * - Implements efficient memoization for derived data
 * - Uses CSS modules for style isolation
 * 
 * @component
 * @returns {JSX.Element} Rendered component
 */
const SearchComponent = () => {
  // Custom hook handles data fetching, loading states, and search functionality
  const { data, loading, error, query, setQuery } = useDataFetching();
  
  // Local state for user filtering
  const [selectedUserId, setSelectedUserId] = useState('');

  /**
   * Memoized computation of unique user IDs from the data
   * Prevents unnecessary recalculation on every render
   */
  const uniqueUserIds = useMemo(() => {
    return [...new Set(data.map(item => item.userId))].sort((a, b) => a - b);
  }, [data]); // Only recompute when data changes

  /**
   * Memoized filtering of data based on selected user ID
   * Ensures filtering only happens when data or selectedUserId changes
   */
  const filteredData = useMemo(() => {
    if (!selectedUserId) return data;
    return data.filter(item => item.userId === parseInt(selectedUserId));
  }, [data, selectedUserId]); // Dependencies for memoization

  return (
    <div className={styles['search-container']}>
      {/* Search controls group */}
      <div className={styles['search-controls']}>
        {/* Todo ID search input */}
        <input
          type="text"
          value={query}
          onChange={(e) => setQuery(e.target.value)}
          placeholder="Search by ID..."
          className={styles['search-input']}
        />
        
        {/* User ID filter dropdown */}
        <select
          value={selectedUserId}
          onChange={(e) => setSelectedUserId(e.target.value)}
          className={styles['user-select']}
        >
          <option value="">All Users</option>
          {uniqueUserIds.map((id) => (
            <option key={id} value={id}>
              User {id}
            </option>
          ))}
        </select>
      </div>

      {/* Conditional rendering for loading state */}
      {loading && (
        <div className={styles['loading-spinner']}>Loading...</div>
      )}

      {/* Conditional rendering for error state */}
      {error && (
        <div className={styles['error-message']}>
          Error: {error}
        </div>
      )}

      {/* Results list - only shown when not loading and no errors */}
      {!loading && !error && (
        <ul className={styles['results-list']}>
          {filteredData.map((item) => (
            <li key={item.id} className={styles['result-item']}>
              {/* Todo ID display */}
              <span className={styles['todo-id']}>{item.id}.</span>
              
              {/* Todo title with user label */}
              <span className={styles['todo-title']}>
                <span className={styles['user-label']}>User {item.userId}:</span>
                {' '}{item.title}
              </span>
              
              {/* Dynamic status badge */}
              <span 
                className={`${styles['todo-status']} ${
                  styles[item.completed ? 'completed' : 'pending']
                }`}
              >
                {item.completed ? 'Completed' : 'Pending'}
              </span>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

/**
 * Best Practices Implemented:
 * 
 * 1. Component Organization:
 *    - Single responsibility principle
 *    - Clear separation of concerns between data fetching and presentation
 * 
 * 2. Performance Optimization:
 *    - Use of useMemo for expensive computations
 *    - Efficient conditional rendering
 *    - Proper key usage in lists
 * 
 * 3. Style Management:
 *    - CSS Modules for style isolation
 *    - Consistent class naming convention
 *    - Separation of styles from component logic
 * 
 * 4. State Management:
 *    - Custom hook for data fetching logic
 *    - Local state for UI-specific features
 *    - Controlled components for form elements
 * 
 * 5. Accessibility:
 *    - Semantic HTML structure
 *    - Clear loading and error states
 *    - Meaningful labels and placeholders
 */

export default SearchComponent;
