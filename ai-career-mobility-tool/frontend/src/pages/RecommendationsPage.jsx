import React, { useState, useEffect } from 'react';
import axios from 'axios';
import RecommendationTable from '../components/Recommendations/RecommendationTable';
import RecommendationForm from '../components/Recommendations/RecommendationForm';

const RecommendationsPage = () => {
    const [recommendations, setRecommendations] = useState([]);

    useEffect(() => {
        const fetchRecommendations = async () => {
            try {
                const response = await axios.get('/api/recommendations');
                setRecommendations(response.data);
            } catch (error) {
                console.error('Error fetching recommendations:', error);
            }
        };
        fetchRecommendations();
    }, []);

    const addRecommendation = async (newRecommendation) => {
        try {
            const response = await axios.post('/api/recommendations', newRecommendation);
            setRecommendations([...recommendations, response.data]);
        } catch (error) {
            console.error('Error adding recommendation:', error);
        }
    };

    return (
        <div>
            <h1>Recommendations</h1>
            <RecommendationForm onSubmit={addRecommendation} />
            <RecommendationTable recommendations={recommendations} />
        </div>
    );
};

export default RecommendationsPage;
