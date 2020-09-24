import axios from 'axios';
import App from './App';

const api = axios.create({
    baseURL: 'http://localhost:8987/consult-return?startDate=2020-09-20&endDate=2020-12-25&ourNumber=1&ocurrency=T'
});

export default api;