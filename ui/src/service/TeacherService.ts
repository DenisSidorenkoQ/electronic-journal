import axios from "axios";
import {Teacher} from "../model/TeacherState";

class TeacherService {
    getTeacherByUserId = (id: number | undefined): Promise<Teacher> => {
        return axios.get<Teacher>(
            `http://localhost:8080/api/v1/user/${id}/teacher`,
            {withCredentials: true}
        ).then(response => response.data);
    }
}

export default new TeacherService();
