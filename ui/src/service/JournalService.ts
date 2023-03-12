import axios from 'axios';
import {Journal} from "../model/JournalState";

class JournalService {
    async getJournalByGroupId(groupId: number): Promise<Journal> {
        return await axios.get<Journal>(
            `http://localhost:8080/api/v1/group/${groupId}/journal`,
            { withCredentials: true }
        ).then(response => {
            return response.data;
        });
    }
}

export default new JournalService();
