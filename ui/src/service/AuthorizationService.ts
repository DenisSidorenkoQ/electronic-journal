import axios from 'axios';

class AuthorizationService {
    async login(login: string, password: string): Promise<number> {
        const response = await axios.post(
            'http://localhost:8080/authorization/login',
            { login: login, password: password },
            { withCredentials: true }
        ).catch(function (error) {
            return error.response.status;
        })
    return response.status;
    }
}

export default new AuthorizationService();
