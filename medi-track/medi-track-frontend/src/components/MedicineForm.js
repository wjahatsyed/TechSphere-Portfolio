import React, { useState } from "react";

const MedicineForm = ({ onAddMedicine }) => {
  const [medicine, setMedicine] = useState({
    name: "",
    quantity: 0,
    contentVolume: 0.0,
    timeOfDay: "MORNING",
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    onAddMedicine(medicine);
    setMedicine({ name: "", quantity: 0, contentVolume: 0.0, timeOfDay: "MORNING" });
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Add Medicine</h2>
      <label>
        Name:
        <input
          type="text"
          value={medicine.name}
          onChange={(e) => setMedicine({ ...medicine, name: e.target.value })}
          required
        />
      </label>
      <label>
        Quantity:
        <input
          type="number"
          value={medicine.quantity}
          onChange={(e) => setMedicine({ ...medicine, quantity: e.target.value })}
          required
        />
      </label>
      <label>
        Content Volume (mg):
        <input
          type="number"
          step="0.1"
          value={medicine.contentVolume}
          onChange={(e) => setMedicine({ ...medicine, contentVolume: e.target.value })}
          required
        />
      </label>
      <label>
        Time of Day:
        <select
          value={medicine.timeOfDay}
          onChange={(e) => setMedicine({ ...medicine, timeOfDay: e.target.value })}
        >
          <option value="MORNING">Morning</option>
          <option value="AFTERNOON">Afternoon</option>
          <option value="EVENING">Evening</option>
        </select>
      </label>
      <button type="submit">Add Medicine</button>
    </form>
  );
};

export default MedicineForm;
