import axios from 'axios';
import {Student} from "../model/StudentState";

class StudentService {
     getStudentByUserId = async (id: number | undefined) => {
         const resp = await axios.get<Student>(
             `http://localhost:8080/api/v1/user/${id}/student`,
             {withCredentials: true}
         );
         return resp.data;
     }
}

export default new StudentService();
