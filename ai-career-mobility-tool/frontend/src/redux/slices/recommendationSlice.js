import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { fetchRecommendations, addRecommendation as addRecommendationAPI } from '../../api/recommendationService'; // Correct import path

// Async thunk to fetch recommendations
export const getRecommendations = createAsyncThunk(
    'recommendations/getRecommendations',
    async () => {
        const response = await fetchRecommendations();
        return response.data;
    }
);

// Async thunk to add a recommendation
export const addRecommendationThunk = createAsyncThunk(
    'recommendations/addRecommendation',
    async (recommendation) => {
        const response = await addRecommendationAPI(recommendation);
        return response.data;
    }
);

const recommendationSlice = createSlice({
    name: 'recommendations',
    initialState: { list: [], status: null },
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(getRecommendations.pending, (state) => {
                state.status = 'loading';
            })
            .addCase(getRecommendations.fulfilled, (state, action) => {
                state.status = 'success';
                state.list = action.payload;
            })
            .addCase(getRecommendations.rejected, (state) => {
                state.status = 'failed';
            })
            .addCase(addRecommendationThunk.fulfilled, (state, action) => {
                state.list.push(action.payload); // Add new recommendation to the list
            });
    },
});

export default recommendationSlice.reducer;
