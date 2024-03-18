// axios-config.js
import axios from 'axios';

const axiosInstance = axios.create();

axiosInstance.interceptors.request.use(
    (config) => {
        // Obtener el token del sessionStorage
        let token = localStorage.getItem('sesion');
        // Si el token está presente, agregarlo al encabezado de autorización
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    (error) => {
        console.log('Error en la solicitud:', error);
        
        return Promise.reject(error);
    }
);

export default axiosInstance;
