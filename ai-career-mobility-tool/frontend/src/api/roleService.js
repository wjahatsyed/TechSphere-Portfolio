import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/v1/career-mobility';

export const fetchRoles = async () => {
    return axios.get(`${BASE_URL}/roles`);
};

export const addRole = async (role) => {
    return axios.post(`${BASE_URL}/roles`, role);
};

export const updateRole = async (id, role) => {
    return axios.put(`${BASE_URL}/roles/${id}`, role);
};

export const deleteRole = async (id) => {
    return axios.delete(`${BASE_URL}/roles/${id}`);
};
