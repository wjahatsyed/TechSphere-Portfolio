import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { fetchEmployees, addEmployee, updateEmployee, deleteEmployee } from '../../api/employeeService';

export const getEmployees = createAsyncThunk('employees/getEmployees', async () => {
    const response = await fetchEmployees();
    return response.data;
});

const employeeSlice = createSlice({
    name: 'employees',
    initialState: { list: [], status: null },
    reducers: {},
    extraReducers: {
        [getEmployees.pending]: (state) => { state.status = 'loading'; },
        [getEmployees.fulfilled]: (state, action) => {
            state.status = 'success';
            state.list = action.payload;
        },
        [getEmployees.rejected]: (state) => { state.status = 'failed'; },
    },
});

export default employeeSlice.reducer;
