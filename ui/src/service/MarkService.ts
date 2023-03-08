import axios from "axios";
import {Mark} from "../model/MarkState";

class MarkService {
    async getMarkBySubjectIdAndGroupId(subjectId: number, groupId: number): Promise<Mark[]> {
        return await axios.get<Mark[]>(
            `http://localhost:8080/api/v1/group/${groupId}/subject/${subjectId}/marks`,
            { withCredentials: true }
        ).then(response => response.data);
    }
}

export default new MarkService();
