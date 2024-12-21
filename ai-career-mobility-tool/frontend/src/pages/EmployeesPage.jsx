import React, { useState, useEffect } from 'react';
import axios from 'axios';
import EmployeeTable from '../components/Employees/EmployeeTable';
import EmployeeForm from '../components/Employees/EmployeeForm';

const EmployeesPage = () => {
    const [employees, setEmployees] = useState([]);

    useEffect(() => {
        const fetchEmployees = async () => {
            try {
                const response = await axios.get('/api/employees');
                setEmployees(response.data);
            } catch (error) {
                console.error('Error fetching employees:', error);  
            }
        };
        fetchEmployees();
    }, []);

    const addEmployee = async (newEmployee) => {
        try {
            const response = await axios.post('/api/employees', newEmployee);
            setEmployees([...employees, response.data]);
        } catch (error) {
            console.error('Error adding employee:', error);
        }
    };

    return (
        <div>
            <h1>Employees</h1>
            <EmployeeForm onSubmit={addEmployee} />
            <EmployeeTable employees={employees} />
        </div>
    );
};

export default EmployeesPage;
