import axios from 'axios';
import {Journal} from "../model/JournalState";

class JournalService {
    async getJournalByGroupId(groupId: number): Promise<Journal> {
        return await axios.get<Journal>(
            `http://localhost:8080/api/v1/group/${groupId}/journals`,
            { withCredentials: true }
        ).then(response => {
            return response.data;
        });
    }

    saveJournal(savedGroupId: number) {
        return axios.post<Journal>(
            `http://localhost:8080/api/v1/journals`,
            {groupId: savedGroupId},
            { withCredentials: true }
        ).then(response => {
            return response.data;
        });
    }
}

export default new JournalService();
