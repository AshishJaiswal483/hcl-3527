
import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080'
});

// 1. Automatically attach JWT to every request
api.interceptors.request.use((config) => {
    const token = localStorage.getItem('token');

    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
});

// 2. Handle expired or invalid JWT
api.interceptors.response.use(
    (response) => {
        return response;
    },

    (error) => {

        if (error.response?.status === 401) {

            // Remove expired token
            localStorage.removeItem('token');

            // Notify App.jsx to display Login page
            window.dispatchEvent(new Event('auth-logout'));
        }

        return Promise.reject(error);
    }
);

export default api;

