
import { useState, useEffect } from 'react';

import Sidebar from './Components/Sidebar';
import Navbar from './Components/Navbar';

import Dashboard from './Pages/Dashboard';
import AllEmployees from './Pages/AllEmployees';
import AddDepartment from './Pages/AddDepartment';
import SearchEmployee from './Pages/SearchEmployee';
import DepartmentWise from './Pages/DepartmentWise';
import DeleteEmployee from './Pages/DeleteEmployee';

import Login from './Pages/Login';
import Register from './Pages/Register';

import './App.css';

function App() {

    const [isLoggedIn, setIsLoggedIn] = useState(
        !!localStorage.getItem('token')
    );

    const [authPage, setAuthPage] = useState('Login');

    const [activePage, setActivePage] = useState('Dashboard');

    // Listen for automatic logout
    useEffect(() => {

        const handleLogout = () => {
            setIsLoggedIn(false);
            setAuthPage('Login');
            setActivePage('Dashboard');
        };

        window.addEventListener('auth-logout', handleLogout);

        return () => {
            window.removeEventListener('auth-logout', handleLogout);
        };

    }, []);

    if (!isLoggedIn) {

        if (authPage === 'Register') {
            return (
                <Register onLogin={() => setAuthPage('Login')} />
            );
        }

        return (
            <Login
                onRegister={() => setAuthPage('Register')}
                onLogin={() => setIsLoggedIn(true)}
            />
        );
    }

    return (
        <div className="app-layout">

            <Sidebar
                activePage={activePage}
                setActivePage={setActivePage}
            />

            <div className="main-content">

                <Navbar />

                {activePage === 'Dashboard' && <Dashboard />}
                {activePage === 'All Employees' && <AllEmployees />}
                {activePage === 'Add Employee' && <AddDepartment />}
                {activePage === 'Search Employee' && <SearchEmployee />}
                {activePage === 'Department-wise' && <DepartmentWise />}
                {activePage === 'Delete Employee' && <DeleteEmployee />}

            </div>
        </div>
    );
}

export default App;



