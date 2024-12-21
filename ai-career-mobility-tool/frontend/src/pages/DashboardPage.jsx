import React, { useState, useEffect } from 'react';
import axios from 'axios';
import StatsCard from '../components/Dashboard/StatsCard';

const DashboardPage = () => {
    const [stats, setStats] = useState({
        employees: 0,
        roles: 0,
        recommendations: 0,
    });

    useEffect(() => {
        const fetchStats = async () => {
            try {
                const response = await axios.get('/api/dashboard/stats');
                setStats(response.data);
            } catch (error) {
                console.error('Error fetching stats:', error);
            }
        };
        fetchStats();
    }, []);

    return (
        <div>
            <h1>Dashboard</h1>
            <StatsCard title="Employees" value={stats.employees} />
            <StatsCard title="Roles" value={stats.roles} />
            <StatsCard title="Recommendations" value={stats.recommendations} />
        </div>
    );
};

export default DashboardPage;
