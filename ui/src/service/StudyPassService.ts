import axios, {AxiosResponse} from "axios";
import {StudyPass} from "../model/StudyPassState";
import {Pass} from "../model/PassState";

class PassService {
    async getStudyPassBySubjectIdAndGroupId(subjectId: number, groupId: number): Promise<StudyPass[]> {
        return await axios.get<StudyPass[]>(
            `http://localhost:8080/api/v1/group/${groupId}/subject/${subjectId}/pass`,
            { withCredentials: true }
        ).then(response => response.data);
    }

    async upsertPass(lessonId: number, studentId: number, pass: boolean): Promise<AxiosResponse<Pass>> {
        return await axios.post<Pass>(
            `http://localhost:8080/api/v1/study-pass`,
            { lessonId: lessonId, pass: pass, studentId: studentId },
            { withCredentials: true }
        ).then(response => response);
    }
}

export default new PassService();
