import { useEffect, useState } from 'react';
import axios from 'axios';
import api from '../Api/axiosConfig'
import './AllEmployees.css';

function AllEmployees() {
  const [employees, setEmployees] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    api.get('http://localhost:8080/Employee/api/GetAll')
      .then((response) => {
        setEmployees(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.error(error);
        setError('Unable to fetch employees');
        setLoading(false);
      });
  }, []);

  if (loading) return <h2>Loading employees...</h2>;

  if (error) return <h2>{error}</h2>;

  return (
    <div className="employees-page">
      <h1>All Employees</h1>
      <p>Total Employees: {employees.length}</p>

      <table>
        <thead>
          <tr>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Department</th>
          </tr>
        </thead>

        <tbody>
          {employees.map((employee) => (
            <tr key={employee.employeeId}>
              <td>{employee.employeeId}</td>
              <td>{employee.employeeName || 'N/A'}</td>
              <td>{employee.deptName}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default AllEmployees;