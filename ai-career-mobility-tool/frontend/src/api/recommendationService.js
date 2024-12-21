import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/v1/career-mobility';

export const fetchRecommendations = async () => {
    return axios.get(`${BASE_URL}/recommendations`);
};

export const addRecommendation = async (recommendation) => {
    return axios.post(`${BASE_URL}/recommendations`, recommendation);
};

export const updateRecommendation = async (id, recommendation) => {
    return axios.put(`${BASE_URL}/recommendations/${id}`, recommendation);
};

export const deleteRecommendation = async (id) => {
    return axios.delete(`${BASE_URL}/recommendations/${id}`);
};
