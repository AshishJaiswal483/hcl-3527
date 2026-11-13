
import { useState } from 'react';
import './DeleteEmployee.css';
import api from '../Api/axiosConfig';

function DeleteEmployee() {

  const [employeeId, setEmployeeId] = useState('');
  const [message, setMessage] = useState('');

  const handleDelete = async (e) => {
    e.preventDefault();

    setMessage('');

    try {
      const response = await api.delete(
        `/Employee/api/deleteByEmpId/${employeeId}`
      );

      setMessage(response.data);
      setEmployeeId('');

    } catch (error) {
      console.error(error);

      if (error.response) {
        const data = error.response.data;

        setMessage(
          typeof data === 'string'
            ? data
            : data.message || JSON.stringify(data)
        );
      } else {
        setMessage('Unable to connect to the server.');
      }
    }
  };

  return (
    <div className="delete-employee-page">

      <h1>Delete Employee</h1>
      <p>Delete an employee using Employee ID.</p>

      <form onSubmit={handleDelete}>

        <label>Employee ID</label>

        <input
          type="number"
          placeholder="Enter Employee ID"
          value={employeeId}
          onChange={(e) => setEmployeeId(e.target.value)}
          min="1"
          required
        />

        <button type="submit">Delete Employee</button>

      </form>

      {message && <p className="delete-message">{message}</p>}

    </div>
  );
}

export default DeleteEmployee;
