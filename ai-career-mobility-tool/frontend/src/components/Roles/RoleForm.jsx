import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { addRole } from '../../redux/slices/roleSlice';
import { TextField, Button } from '@mui/material';

const RoleForm = () => {
    const [name, setName] = useState('');
    const dispatch = useDispatch();

    const handleSubmit = (e) => {
        e.preventDefault();
        dispatch(addRole({ name }));
        setName('');
    };

    return (
        <form onSubmit={handleSubmit}>
            <TextField label="Role Name" value={name} onChange={(e) => setName(e.target.value)} required />
            <Button type="submit">Add Role</Button>
        </form>
    );
};

export default RoleForm;
