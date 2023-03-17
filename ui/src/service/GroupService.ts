import axios from 'axios';
import {Group} from "../model/GroupState";

class GroupService {
    async saveGroup(name: string): Promise<Group> {
        return await axios.post<Group>(
            `http://localhost:8080/api/v1/groups`,
            {name: name},
            { withCredentials: true }
        ).then(response => {
            return response.data;
        });
    }

    async getGroupById(groupId: number | undefined): Promise<Group> {
        return await axios.get<Group>(
            `http://localhost:8080/api/v1/group/${groupId}`,
            { withCredentials: true }
        ).then(response => {
            return response.data;
        });
    }

    async getGroupList(): Promise<Group[]> {
        return await axios.get<Group[]>(
            `http://localhost:8080/api/v1/groups`,
            { withCredentials: true }
        ).then(response => {
            return response.data;
        });
    }
}

export default new GroupService();
