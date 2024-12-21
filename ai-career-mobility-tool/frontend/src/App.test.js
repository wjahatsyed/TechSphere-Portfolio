import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import DashboardPage from './pages/DashboardPage';
import EmployeesPage from './pages/EmployeesPage';
import RolesPage from './pages/RolesPage';
import RecommendationsPage from './pages/RecommendationsPage';

const App = () => (
    <Router>
        <Routes>
            <Route path="/" element={<DashboardPage />} />
            <Route path="/employees" element={<EmployeesPage />} />
            <Route path="/roles" element={<RolesPage />} />
            <Route path="/recommendations" element={<RecommendationsPage />} />
        </Routes>
    </Router>
);

export default App;
