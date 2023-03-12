import * as React from 'react';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import {SelectChangeEvent, FormControl, InputLabel, MenuItem, Select} from "@mui/material";
import {useSessionStore} from "../../store";
import SubjectService from "../../service/SubjectService";
import {GroupHasSubject, Subject} from "../../model/SubjectState";
import {useEffect} from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

import './Journal.css';
import TeacherService from "../../service/TeacherService";
import {Group} from "../../model/GroupState";
import GroupService from "../../service/GroupService";

const theme = createTheme();

const TeacherJournalPage = () => {
    const [teacherId, setTeacherId] = React.useState(0);
    const [selectedGroupId, setSelectedGroupId] = React.useState(0);
    const [groupHasSubjectList, setGroupHasSubjectList] = React.useState<GroupHasSubject[]>([]);
    const [groupIdSet, setGroupIdSet] = React.useState(() => new Set());
    const [groupList, setGroupList] = React.useState<Group[]>([]);
    const [subjectList, setSubjectList] = React.useState<Subject[]>([]);
    let user = useSessionStore(state => state.user);

    useEffect(() => {
        TeacherService.getTeacherByUserId(user?.id).then(teacher => setTeacherId(teacher.id));
    }, [user]);

    useEffect(() => {
        SubjectService.getTeacherSubjects(teacherId).then(subjects => setGroupHasSubjectList(subjects));

    }, [teacherId]);

    useEffect(() => {
        setGroupIdSet(new Set<number>(groupHasSubjectList.map(groupHasSubject => groupHasSubject.groupId)));
    }, [groupHasSubjectList]);

    useEffect(() => {
        const iterator = groupIdSet.values();
        let groupId: number;
        setGroupList([]);

        for (let i = 0; i < groupIdSet.size; i++) {
            groupId = iterator.next().value;

            GroupService.getGroupById(groupId).then(group => {
                setGroupList((oldArray) => [...oldArray, group]);
            })
        }

    }, [groupIdSet]);

    useEffect(() => {

    }, [subjectList]);

    const handleGroupChange = (event: SelectChangeEvent) => {
        const groupId = parseInt(event.target.value);

        setSelectedGroupId(groupId);
    };

    function printSubjectSelect() {
        if (subjectList.length === 0) return;

    }

    return (
        <ThemeProvider theme={theme}>
            <Container component="main" maxWidth="xs">
                <div>
                    <FormControl sx={{m: 1, minWidth: 80}}>
                        <InputLabel id="Groups">Groups</InputLabel>
                        <Select
                            labelId="Groups"
                            id="Groups"
                            value={selectedGroupId.toString()}
                            onChange={handleGroupChange}
                            label="Groups"
                            sx={{width: 300}}
                        >
                            {
                                groupList.map((group) => (
                                    <MenuItem key={group.id} value={group.id}>{group.name}</MenuItem>
                                ))
                            }
                        </Select>
                    </FormControl>
                </div>
            </Container>
            {/*{ getGrid() }*/}
        </ThemeProvider>
    );
};

export default TeacherJournalPage;
