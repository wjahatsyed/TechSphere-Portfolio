import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { addRecommendationThunk } from '../../redux/slices/recommendationSlice';
import { TextField, Button } from '@mui/material';

const RecommendationForm = () => {
    const [title, setTitle] = useState('');
    const [details, setDetails] = useState('');
    const dispatch = useDispatch();

    const handleSubmit = (e) => {
        e.preventDefault();
        dispatch(addRecommendationThunk({ title, details }));
        setTitle('');
        setDetails('');
    };

    return (
        <form onSubmit={handleSubmit}>
            <TextField label="Title" value={title} onChange={(e) => setTitle(e.target.value)} required />
            <TextField label="Details" value={details} onChange={(e) => setDetails(e.target.value)} required />
            <Button type="submit">Add Recommendation</Button>
        </form>
    );
};

export default RecommendationForm;
