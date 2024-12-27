import React from "react";
import MedicineForm from "./components/MedicineForm";
import Dashboard from "./components/Dashboard";
import DataDisplay from "./components/DataDisplay"; // Import DataDisplay component

const App = () => {
  const handleAddMedicine = (medicine) => {
    fetch("/api/medicines", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(medicine),
    })
      .then((res) => res.json())
      .then(() => alert("Medicine added successfully!"));
  };

  return (
    <div>
      <h1>Medi-Track</h1>
      <MedicineForm onAddMedicine={handleAddMedicine} />
      <Dashboard />
      <DataDisplay /> {/* Add the DataDisplay component */}
    </div>
  );
};

export default App;
