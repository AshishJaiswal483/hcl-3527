
import { useState } from 'react';
import axios from 'axios';
import './Register.css';

function Register({ onLogin }) {

    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');
    const [showPassword, setShowPassword] = useState(false);
    const [loading, setLoading] = useState(false);

    const handleRegister = async (e) => {
        e.preventDefault();

        try {
            setLoading(true);

            const response = await axios.post(
                'http://localhost:8080/users/api/registerUsers',
                {
                    userName: userName,
                    password: password,
                    role: 'USER'
                }
            );

            alert(response.data);

            setUserName('');
            setPassword('');

            onLogin();

        } catch (error) {

    console.log('Registration Failed:', error.response?.data);

    if (error.response) {
        const message =
            error.response.data?.message ||
            error.response.data?.detail ||
            'Registration failed';

        alert(message);
    } else {
        alert(error.message);
    }

} finally {
            setLoading(false);
        }
    };

    return (
        <div className="register-container">

            <div className="register-card">

                <div className="register-logo">EMS</div>

                <h2>Create Account</h2>

                <p className="register-subtitle">
                    Register for Employee Management System
                </p>

                <form onSubmit={handleRegister}>

                    <div className="register-input-group">
                        <label>Username</label>

                        <input
                            type="text"
                            placeholder="Enter your username"
                            value={userName}
                            onChange={(e) => setUserName(e.target.value)}
                            required
                        />
                    </div>

                    <div className="register-input-group">
                        <label>Password</label>

                        <div className="register-password-box">
                            <input
                                type={showPassword ? 'text' : 'password'}
                                placeholder="Create your password"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                required
                            />

                            <button
                                type="button"
                                className="register-show-password"
                                onClick={() => setShowPassword(!showPassword)}
                            >
                                {showPassword ? 'Hide' : 'Show'}
                            </button>
                        </div>
                    </div>

                    <button
                        type="submit"
                        className="register-button"
                        disabled={loading}
                    >
                        {loading ? 'Registering...' : 'Register'}
                    </button>

                </form>

                <p className="login-text">
                    Already have an account?
                    <span onClick={onLogin}> Login</span>
                </p>

            </div>

        </div>
    );
}

export default Register;

