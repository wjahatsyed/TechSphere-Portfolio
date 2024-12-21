import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { addEmployee } from '../../redux/slices/employeeSlice';
import { TextField, Button } from '@mui/material';

const EmployeeForm = () => {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const dispatch = useDispatch();

    const handleSubmit = (e) => {
        e.preventDefault();
        dispatch(addEmployee({ name, email }));
        setName('');
        setEmail('');
    };

    return (
        <form onSubmit={handleSubmit}>
            <TextField label="Name" value={name} onChange={(e) => setName(e.target.value)} required />
            <TextField label="Email" value={email} onChange={(e) => setEmail(e.target.value)} required />
            <Button type="submit">Add Employee</Button>
        </form>
    );
};

export default EmployeeForm;
