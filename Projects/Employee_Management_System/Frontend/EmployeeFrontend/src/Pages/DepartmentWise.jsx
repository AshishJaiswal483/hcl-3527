
import { useState } from 'react';
import api from '../Api/axiosConfig';
import './DepartmentWise.css';

function DepartmentWise() {

  const [departmentName, setDepartmentName] = useState('');
  const [employees, setEmployees] = useState([]);
  const [error, setError] = useState('');

  const handleSearch = async (e) => {
    e.preventDefault();

    setEmployees([]);
    setError('');

    try {
      const response = await api.get(
        '/Employee/api/getByDeptName',
        {
          params: {
            name: departmentName
          }
        }
      );

      setEmployees(response.data);

      if (response.data.length === 0) {
        setError('No employees found in this department.');
      }

    } catch (error) {
      console.error(error);

      if (error.response) {
        const data = error.response.data;

        setError(
          typeof data === 'string'
            ? data
            : data.message || JSON.stringify(data)
        );
      } else {
        setError('Server is not reachable.');
      }
    }
  };

  return (
    <div className="department-wise-page">

      <h1>Department-wise Employees</h1>
      <p>Search employees by department name.</p>

      <form onSubmit={handleSearch}>
        <input
          type="text"
          placeholder="Enter department name"
          value={departmentName}
          onChange={(e) => setDepartmentName(e.target.value)}
          required
        />

        <button type="submit">Search</button>
      </form>

      {error && <p className="error-message">{error}</p>}

      {employees.length > 0 && (
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
                <td>{employee.employeeName}</td>
                <td>{employee.deptName}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}

    </div>
  );
}

export default DepartmentWise;
