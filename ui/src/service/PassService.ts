import axios from "axios";
import {Pass} from "../model/PassState";

class PassService {
    async upsertPass(lessonId: number, studentId: number, pass: boolean): Promise<Pass> {
        return await axios.post<Pass>(
            `http://localhost:8080/api/v1/study-pass`,
            { lessonId: lessonId, pass: pass, studentId: studentId },
            { withCredentials: true }
        ).then(response => response.data);
    }
}

export default new PassService();
