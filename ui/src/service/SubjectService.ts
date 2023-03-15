import axios from "axios";
import {GroupHasSubject, Subject} from "../model/SubjectState";

class SubjectService {
    getGroupSubjects = (id: number | undefined): Promise<Subject[]> => {
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

    getTeacherSubjects = (id: number): Promise<GroupHasSubject[]> => {
        return axios.get<GroupHasSubject[]>(
            `http://localhost:8080/api/v1/teacher/${id}/subjects`,
            {withCredentials: true}
        ).then(request => request.data);
    }

    getSubjectsByTeacherIdAndGroupId = (teacherId: number, groupId: number): Promise<Subject[]> => {
        return axios.get<Subject[]>(
            `http://localhost:8080/api/v1/teacher/${teacherId}/group/${groupId}/subjects`,
            {withCredentials: true}
        ).then(request => request.data);
    }
}

export default new SubjectService();
