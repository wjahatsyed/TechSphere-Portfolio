import React, { useState, useEffect } from 'react';
import axios from 'axios';
import RoleTable from '../components/Roles/RoleTable';
import RoleForm from '../components/Roles/RoleForm';

const RolesPage = () => {
    const [roles, setRoles] = useState([]);

    useEffect(() => {
        const fetchRoles = async () => {
            try {
                const response = await axios.get('/api/roles');
                setRoles(response.data);
            } catch (error) {
                console.error('Error fetching roles:', error);
            }
        };
        fetchRoles();
    }, []);

    const addRole = async (newRole) => {
        try {
            const response = await axios.post('/api/roles', newRole);
            setRoles([...roles, response.data]);
        } catch (error) {
            console.error('Error adding role:', error);
        }
    };

    return (
        <div>
            <h1>Roles</h1>
            <RoleForm onSubmit={addRole} />
            <RoleTable roles={roles} />
        </div>
    );
};

export default RolesPage;
