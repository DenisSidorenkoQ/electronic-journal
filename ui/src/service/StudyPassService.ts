import axios from "axios";
import {StudyPass} from "../model/StudyPassState";

class PassService {
    async getStudyPassBySubjectIdAndGroupId(subjectId: number, groupId: number): Promise<StudyPass[]> {
        return await axios.get<StudyPass[]>(
            `http://localhost:8080/api/v1/group/${groupId}/subject/${subjectId}/pass`,
            { withCredentials: true }
        ).then(response => response.data);
    }
}

export default new PassService();
