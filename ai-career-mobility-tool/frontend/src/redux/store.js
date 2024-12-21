import { configureStore } from '@reduxjs/toolkit';
import employeeReducer from './slices/employeeSlice';
import roleReducer from './slices/roleSlice';
import recommendationReducer from './slices/recommendationSlice';

export const store = configureStore({
    reducer: {
        employees: employeeReducer,
        roles: roleReducer,
        recommendations: recommendationReducer,
    },
});
