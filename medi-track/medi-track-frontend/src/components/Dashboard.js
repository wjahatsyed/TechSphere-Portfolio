import React, { useEffect, useState } from "react";
import { Bar, Line, Doughnut } from "react-chartjs-2";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
  PointElement,
  LineElement,
  ArcElement,
} from "chart.js";

// Register required components
ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
  PointElement,
  LineElement,
  ArcElement
);

const Dashboard = () => {
  const [stats, setStats] = useState({});
  const [chartsData, setChartsData] = useState({});

  useEffect(() => {
    const fetchStats = async () => {
      try {
        const res = await fetch("http://localhost:8090/api/medicines/stats");
        if (!res.ok) throw new Error("Failed to fetch stats");
        const data = await res.json();
        console.log("Stats Data:", data);
        setStats(data);
      } catch (err) {
        console.error("Stats Fetch Error:", err);
      }
    };

    const fetchChartsData = async () => {
      try {
        const res = await fetch("http://localhost:8090/api/medicines/charts");
        if (!res.ok) throw new Error("Failed to fetch charts data");
        const data = await res.json();
        console.log("Charts Data:", data);
        setChartsData(data);
      } catch (err) {
        console.error("Charts Fetch Error:", err);
      }
    };

    fetchStats();
    fetchChartsData();
  }, []);

  // Prepare chart data
  const barChartData = {
    labels: Object.keys(stats),
    datasets: [
      {
        label: "Number of Medicines",
        data: Object.values(stats),
        backgroundColor: ["#FF6384", "#36A2EB", "#FFCE56"],
      },
    ],
  };

  const lineChartData = {
    labels: Object.keys(chartsData),
    datasets: [
      {
        label: "Total Quantity",
        data: Object.values(chartsData).map((data) => data.totalQuantity || 0),
        borderColor: "#36A2EB",
        fill: false,
      },
      {
        label: "Total Content Volume",
        data: Object.values(chartsData).map((data) => data.totalContentVolume || 0),
        borderColor: "#FF6384",
        fill: false,
      },
    ],
  };

  const doughnutData = {
    labels: Object.keys(chartsData),
    datasets: [
      {
        data: Object.values(chartsData).map((data) => data.totalContentVolume || 0),
        backgroundColor: ["#FF6384", "#36A2EB", "#FFCE56"],
      },
    ],
  };

  return (
    <div>
      <h2>Dashboard</h2>
      {Object.keys(stats).length > 0 ? (
        <div>
          <h3>Number of Medicines by Time of Day</h3>
          <Bar data={barChartData} />
        </div>
      ) : (
        <p>Loading stats...</p>
      )}
      {Object.keys(chartsData).length > 0 ? (
        <>
          <div>
            <h3>Quantity and Content Volume Trend</h3>
            <Line data={lineChartData} />
          </div>
          <div>
            <h3>Content Breakdown</h3>
            <Doughnut data={doughnutData} />
          </div>
        </>
      ) : (
        <p>Loading charts...</p>
      )}
    </div>
  );
};

export default Dashboard;
