
import { useState } from 'react';
import axios from 'axios';
import './Login.css';

function Login({ onRegister, onLogin }) {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [showPassword, setShowPassword] = useState(false);
    const [loading, setLoading] = useState(false);

    const handleLogin = async (e) => {
        e.preventDefault();

        try {
            setLoading(true);

            const response = await axios.post(
                'http://localhost:8080/users/api/login',
                {
                    username: username,
                    password: password
                }
            );

            localStorage.setItem('token', response.data);

            console.log('Login Successful');

            onLogin();

        } catch (error) {

            console.log('Login Failed');

            if (error.response) {
                alert(error.response.data.message || 'Invalid username or password');
            } else {
                alert(error.message);
            }

        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="login-container">

            <div className="login-card">

                <div className="login-logo">EMS</div>

                <h2>Welcome Back!</h2>

                <p className="login-subtitle">
                    Employee Management System
                </p>

                <form onSubmit={handleLogin}>

                    <div className="login-input-group">
                        <label>Username</label>
                        <input
                            type="text"
                            placeholder="Enter your username"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            required
                        />
                    </div>

                    <div className="login-input-group">
                        <label>Password</label>

                        <div className="password-box">
                            <input
                                type={showPassword ? 'text' : 'password'}
                                placeholder="Enter your password"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                required
                            />

                            <button
                                type="button"
                                className="show-password"
                                onClick={() => setShowPassword(!showPassword)}
                            >
                                {showPassword ? 'Hide' : 'Show'}
                            </button>
                        </div>
                    </div>

                    <button
                        type="submit"
                        className="login-button"
                        disabled={loading}
                    >
                        {loading ? 'Logging in...' : 'Login'}
                    </button>

                </form>

                <p className="register-text">
                    Don't have an account?
                    <span onClick={onRegister}> Register</span>
                </p>

            </div>

        </div>
    );
}

export default Login;


