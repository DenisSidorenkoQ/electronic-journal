import axios from "axios";
import {Teacher} from "../model/TeacherState";

class TeacherService {
    getTeacherByUserId = (id: number | undefined): Promise<Teacher> => {
        return axios.get<Teacher>(
            `http://localhost:8080/api/v1/user/${id}/teachers`,
            {withCredentials: true}
        ).then(response => response.data);
    }

    saveTeacher = (userId: number, departmentId: number, fio: string): Promise<Teacher> => {
        return axios.post<Teacher>(
            `http://localhost:8080/api/v1/teachers`,
            {userId: userId, departmentId: departmentId, fio: fio},
            {withCredentials: true}
        ).then(response => response.data);
    }
}

export default new TeacherService();
