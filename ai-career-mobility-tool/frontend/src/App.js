import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import DashboardPage from './pages/DashboardPage';
import EmployeesPage from './pages/EmployeesPage';
import RolesPage from './pages/RolesPage';
import RecommendationsPage from './pages/RecommendationsPage';
import { CssBaseline, AppBar, Toolbar, Typography } from '@mui/material';

const App = () => {
    return (
        <Router>
            <CssBaseline />
            <AppBar position="static">
                <Toolbar>
                    <Typography variant="h6" component="div">
                        AI Career Mobility Tool
                    </Typography>
                </Toolbar>
            </AppBar>
            <Routes>
                <Route path="/" element={<DashboardPage />} />
                <Route path="/employees" element={<EmployeesPage />} />
                <Route path="/roles" element={<RolesPage />} />
                <Route path="/recommendations" element={<RecommendationsPage />} />
            </Routes>
        </Router>
    );
};

export default App;
