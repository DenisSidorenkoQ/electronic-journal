import {Group} from "../model/GroupState";
import axios from "axios";
import {Department} from "../model/DepartmentState";

class DepartmentService {
    async getDepartmentList(): Promise<Department[]> {
        return await axios.get<Department[]>(
            `http://localhost:8080/api/v1/departments`,
            { withCredentials: true }
        ).then(response => {
            return response.data;
        });
    }
}

export default new DepartmentService();
