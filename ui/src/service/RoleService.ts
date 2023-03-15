import axios, {AxiosResponse} from "axios";
import {Role} from "../model/RoleState";

class RoleService {
    async getAllRoles(): Promise<Role[]> {
        return await axios.get<Role[]>(
            `http://localhost:8080/api/v1/roles`,
            { withCredentials: true }
        ).then(response => response.data);
    }

    async getRoleById(roleId: number): Promise<Role> {
        return await axios.get<Role>(
            `http://localhost:8080/api/v1/role/${roleId}`,
            { withCredentials: true }
        ).then(response => response.data);
    }
}

export default new RoleService();
