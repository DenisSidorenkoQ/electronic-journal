import axios from 'axios';
import {Lesson} from "../model/LessonState";

class LessonService {
    async getAllLessonsByGroupIdAndSubjectId(groupId: number, subjectId: number): Promise<Lesson[]> {
        return await axios.get<Lesson[]>(
            'http://localhost:8080/api/v1/lessons',
            { withCredentials: true,  params: { groupId: groupId, subjectId: subjectId } }
        ).then(response => response.data);
    }
}

export default new LessonService();
