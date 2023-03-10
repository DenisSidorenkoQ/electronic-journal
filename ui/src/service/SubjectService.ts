import axios from "axios";
import {Subject} from "../model/SubjectState";

class SubjectService {
    getGroupSubjects = (id: number): Promise<Subject[]> => {
        return axios.get<Subject[]>(
            `http://localhost:8080/api/v1/group/${id}/subjects`,
            {withCredentials: true}
        ).then(subjects => {
            if (subjects.data.length != null) {
                return subjects.data;
            } else {
                return [];
            }
        });

    }
}

export default new SubjectService();
