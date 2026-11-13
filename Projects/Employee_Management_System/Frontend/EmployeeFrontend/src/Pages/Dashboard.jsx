
import { useEffect, useState } from 'react';
import axios from 'axios';
import './Dashboard.css';
import api from '../Api/axiosConfig';

function Dashboard() {

  const [totalEmployees, setTotalEmployees] = useState(0);
  const [totalDepartments, setTotalDepartments] = useState(0);
  const [loading, setLoading] = useState(true);

  useEffect(() => {

    const fetchDashboardData = async () => {
      try {

        const employeeResponse = await api.get(
          'http://localhost:8080/Employee/api/totalCountEmp'
        );

        const departmentResponse = await api.get(
          'http://localhost:8080/Employee/api/totalCountDept'
        );

        setTotalEmployees(employeeResponse.data);
        setTotalDepartments(departmentResponse.data);

      } catch (error) {
        console.error('Dashboard API Error:', error);
      } finally {
        setLoading(false);
      }
    };

    fetchDashboardData();

  }, []);

  return (
    <div className="dashboard">

      <h1>Dashboard</h1>
      <p>Welcome to Employee Management System</p>

      <div className="dashboard-cards">

        <div className="card">
          <h3>Total Employees</h3>
          <h2>
            {loading ? 'Loading...' : totalEmployees}
          </h2>
        </div>

        <div className="card">
          <h3>Total Departments</h3>
          <h2>
            {loading ? 'Loading...' : totalDepartments}
          </h2>
        </div>

      </div>

    </div>
  );
}

export default Dashboard;
