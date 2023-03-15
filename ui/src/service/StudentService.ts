import axios from 'axios';
import {Student} from "../model/StudentState";

class StudentService {
     getStudentByUserId = async (id: number | undefined) => {
         const resp = await axios.get<Student>(
             `http://localhost:8080/api/v1/user/${id}/students`,
             {withCredentials: true}
         );
         return resp.data;
     }

    getStudentsByGroupId = async (id: number | undefined) => {
        const resp = await axios.get<Student[]>(
            `http://localhost:8080/api/v1/group/${id}/students`,
            {withCredentials: true}
        );
        return resp.data;
    }
}

export default new StudentService();
