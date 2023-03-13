import axios from 'axios';
import {Lesson} from "../model/LessonState";

class LessonService {
    async getAllLessonsByGroupIdAndSubjectId(groupId: number, subjectId: number): Promise<Lesson[]> {
        return await axios.get<Lesson[]>(
            'http://localhost:8080/api/v1/lessons',
            { withCredentials: true,  params: { groupId: groupId, subjectId: subjectId } }
        ).then(response => response.data);
    }

    async saveLesson(journalId: number | undefined, subjectId: number, themeName: string, dateTimestamp: number): Promise<Lesson> {
        return await axios.post<Lesson>(
            `http://localhost:8080/api/v1/lesson`,
            {journalId: journalId, subjectId: subjectId, themeName: themeName, dateTimestamp: dateTimestamp},
            {withCredentials: true}).then(request => request.data);
    }
}

export default new LessonService();
