import React, { useEffect, useState } from 'react';

const DataDisplay = () => {
  const [medicines, setMedicines] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Fetch medicines data from backend
  useEffect(() => {
    const fetchMedicines = async () => {
      try {
        const response = await fetch("http://localhost:8090/api/medicines");
        if (!response.ok) throw new Error("Failed to fetch medicines");
        const data = await response.json();
        setMedicines(data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchMedicines();
  }, []);

  if (loading) {
    return <p>Loading data...</p>;
  }

  if (error) {
    return <p>Error: {error}</p>;
  }

  return (
    <div>
      <h2>Medicines List</h2>
      {medicines.length === 0 ? (
        <p>No medicines available.</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Quantity</th>
              <th>Content Volume (mg)</th>
              <th>Time of Day</th>
            </tr>
          </thead>
          <tbody>
            {medicines.map((medicine, index) => (
              <tr key={index}>
                <td>{medicine.name}</td>
                <td>{medicine.quantity}</td>
                <td>{medicine.contentVolume}</td>
                <td>{medicine.timeOfDay}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default DataDisplay;
