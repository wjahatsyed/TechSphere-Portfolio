import React from "react";
import MedicineForm from "./components/MedicineForm";
import Dashboard from "./components/Dashboard";

const App = () => {
  const handleAddMedicine = async (medicine) => {
    try {
      const response = await fetch("http://localhost:8090/api/medicines", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(medicine),
      });
      if (!response.ok) {
        throw new Error("Failed to add medicine");
      }
      alert("Medicine added successfully!");
    } catch (err) {
      console.error(err);
      alert("Error adding medicine.");
    }
  };

  return (
    <div>
      <h1>Medi-Track</h1>
      <MedicineForm onAddMedicine={handleAddMedicine} />
      <Dashboard />
    </div>
  );
};

export default App;
