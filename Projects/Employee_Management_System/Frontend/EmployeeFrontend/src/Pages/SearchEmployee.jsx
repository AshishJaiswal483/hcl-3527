
import { useState } from 'react';
import api from '../Api/axiosConfig';
import './SearchEmployee.css';

function SearchEmployee() {

  const [employeeId, setEmployeeId] = useState('');
  const [employee, setEmployee] = useState(null);
  const [error, setError] = useState('');

  const handleSearch = async (e) => {
    e.preventDefault();

    setEmployee(null);
    setError('');

    try {
     const response = await api.get(
    `/Employee/api/getById/${employeeId}`
);

      setEmployee(response.data);

    }catch (error) {
  console.error(error);

  if (error.response) {
    setError(
      typeof error.response.data === 'string'
        ? error.response.data
        : error.response.data.message || JSON.stringify(error.response.data)
    );
  } else {
    setError('Server is not reachable');
  }
}
  };

  return (
    <div className="search-employee-page">

      <h1>Search Employee</h1>
      <p>Search employee details using Employee ID.</p>

      <form onSubmit={handleSearch}>
        <input
          type="number"
          placeholder="Enter Employee ID"
          value={employeeId}
          onChange={(e) => setEmployeeId(e.target.value)}
          min="1"
          required
        />

        <button type="submit">Search</button>
      </form>

      {employee && (
        <div className="employee-result">
          <h2>Employee Details</h2>
          <p><strong>Employee ID:</strong> {employee.employeeId}</p>
          <p><strong>Employee Name:</strong> {employee.employeeName}</p>
          <p><strong>Department:</strong> {employee.deptName}</p>
        </div>
      )}

      {error && <p className="error-message">{error}</p>}

    </div>
  );
}

export default SearchEmployee;
