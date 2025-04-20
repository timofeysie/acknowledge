import { useState } from 'react';
import { useFallacies } from '../hooks/useFallacies';
import './FallaciesList.css';

const FallaciesList = () => {
  const { fallacies, loading, error } = useFallacies();
  const [selectedFallacy, setSelectedFallacy] = useState(null);
  const [viewMode, setViewMode] = useState('table'); // 'table' or 'detail'

  const handleFallacyClick = (fallacy) => {
    setSelectedFallacy(fallacy);
    setViewMode('detail');
  };

  const handleBackToList = () => {
    setSelectedFallacy(null);
    setViewMode('table');
  };

  if (loading) return <div>Loading fallacies...</div>;
  if (error) return <div>Error loading fallacies: {error.message}</div>;

  return (
    <div className="fallacies-container">
      <div className="view-toggle">
        <button 
          className={viewMode === 'table' ? 'active' : ''} 
          onClick={() => setViewMode('table')}
        >
          Table View
        </button>
        <button 
          className={viewMode === 'detail' ? 'active' : ''} 
          onClick={() => setViewMode('detail')}
        >
          Detail View
        </button>
        <div className="fallacies-title">
            { fallacies.length } Fallacies
        </div>
      </div>

      {viewMode === 'table' ? (
        <div className="table-container">
          <table className="fallacies-table">
            <thead>
              <tr>
                <th>Name</th>
                <th>Description</th>
              </tr>
            </thead>
            <tbody>
              {fallacies.map((fallacy) => (
                <tr key={fallacy.id}>
                  <td>{fallacy.name}</td>
                  <td>{fallacy.description}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      ) : selectedFallacy ? (
        <div className="fallacy-detail">
          <div className="detail-header">
            <button className="back-button" onClick={handleBackToList}>
              ← Back to List
            </button>
            <h2>{selectedFallacy.name}</h2>
          </div>
          <div className="fallacy-card">
            <p>{selectedFallacy.description}</p>
            <div className="examples">
              <h4>Examples:</h4>
              <ul>
                {selectedFallacy.examples.map((example, index) => (
                  <li key={index}>{example}</li>
                ))}
              </ul>
            </div>
          </div>
        </div>
      ) : (
        <div className="fallacies-list">
          {fallacies.map((fallacy) => (
            <div 
              key={fallacy.id} 
              className="fallacy-card"
              onClick={() => handleFallacyClick(fallacy)}
            >
              <h3>{fallacy.name}</h3>
              <p>{fallacy.description}</p>
              <div className="examples">
                <h4>Examples:</h4>
                <ul>
                  {fallacy.examples.map((example, index) => (
                    <li key={index}>{example}</li>
                  ))}
                </ul>
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default FallaciesList; 