
import { useState } from 'react';
import axios from 'axios';
import './AddDepartment.css';
import "../Api/axiosConfig";
import api from '../Api/axiosConfig';

function AddDepartment() {

  const [departmentName, setDepartmentName] = useState('');
  const [employeeName, setEmployeeName] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    const requestData = {
      departmentName: departmentName,
      empList: [
        {
          employeeName: employeeName
        }
      ]
    };

    try {
      const response = await api.post(
        'http://localhost:8080/Employee/api/add',
        requestData
      );

      setMessage(response.data);

      setDepartmentName('');
      setEmployeeName('');

    } catch (error) {
      console.error('Error:', error);

      if (error.response?.data) {
        setMessage(JSON.stringify(error.response.data));
      } else {
        setMessage('Failed to add department and employee');
      }
    }
  };

  return (
    <div className="add-department-page">

      <h1>Add Department & Employees</h1>
      <p>Create a department and add an employee.</p>

      <form onSubmit={handleSubmit}>

        <label>Department Name</label>
        <input
          type="text"
          placeholder="Enter department name"
          value={departmentName}
          onChange={(e) => setDepartmentName(e.target.value)}
          required
        />

        <label>Employee Name</label>
        <input
          type="text"
          placeholder="Enter employee name"
          value={employeeName}
          onChange={(e) => setEmployeeName(e.target.value)}
          required
        />

        <button type="submit">
          Add Department
        </button>

      </form>

      {message && <p>{message}</p>}

    </div>
  );
}

export default AddDepartment;
