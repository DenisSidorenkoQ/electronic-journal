import * as React from 'react';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import {Tabs, Tab, SelectChangeEvent, FormControl, InputLabel, MenuItem, Select} from "@mui/material";
import {useSessionStore} from "../../store";
import StudentService from "../../service/StudentService";
import SubjectService from "../../service/SubjectService";
import {Subject} from "../../model/SubjectState";
import {useEffect} from "react";
import LessonService from "../../service/LessonService";
import {Lesson} from "../../model/LessonState";
import DataGrid, { Column, ColumnChooser } from 'devextreme-react/data-grid';

const theme = createTheme();

const StudentJournalPage = () => {

    const [selectedSubjectId, setSelectedSubjectId] = React.useState(0);
    const [groupId, setGroupId] = React.useState(0);
    const [subjectList, setSubjectList] = React.useState<Subject[]>([]);
    const [lessonList, setLessonList] = React.useState<Lesson[]>([]);
    let user = useSessionStore(state => state.user);

    useEffect(() => {
        StudentService.getStudentByUserId(user?.id).then(student => setGroupId(student.groupId));
    }, [user]);

    useEffect(() => {
        SubjectService.getGroupSubjects(groupId).then(subjects => setSubjectList(subjects));
    }, [groupId]);

    useEffect(() => {
        LessonService.getAllLessonsByGroupIdAndSubjectId(groupId, selectedSubjectId).then(lessons => setLessonList(lessons));
    }, [selectedSubjectId]);

    useEffect(() => {
        // columns.push({ field: `studentName`, headerName: `student`, width: 70 })
        // lessonList.forEach(lesson => {
        //     columns.push({ field: `${lesson.id}`, headerName: `${lesson.themeName}`, width: 70 });
        // })
        //
        // rows.push({ studentName: 1, lastName: 'Snow', firstName: 'Jon', age: 35 })

    }, [lessonList]);

    const handleSubjectChange = (event: SelectChangeEvent) => {
        const subjectId = parseInt(event.target.value);

        console.log(subjectId);

        setSelectedSubjectId(subjectId);
    };

    return (
        <ThemeProvider theme={theme}>
            <Container component="main" maxWidth="xs">
                <div>
                    <FormControl sx={{m: 1, minWidth: 80}}>
                        <InputLabel id="lessonsLabel">Subject</InputLabel>
                        <Select
                            labelId="lessons"
                            id="lessons"
                            value={selectedSubjectId.toString()}
                            onChange={handleSubjectChange}
                            label="Subject"
                            sx={{width: 300}}
                        >
                            {
                                subjectList.map((subject) => (
                                    <MenuItem value={subject.id}>{subject.name}</MenuItem>
                                ))
                            }
                        </Select>
                    </FormControl>
                </div>
            </Container>
            <DataGrid
                id="grid"
                // dataSource={countries}
                keyExpr="ID"
                columnAutoWidth={true}
                allowColumnReordering={true}
                showBorders={true}
            >
                <ColumnChooser enabled={true} />
                <Column dataField="Country" />
                <Column dataField="Area" />
                <Column caption="Population">
                    <Column
                        dataField="Population_Total"
                        caption="Total"
                        format="fixedPoint"
                    />
                    <Column
                        dataField="Population_Urban"
                        caption="Urban"
                        format="percent"
                    />
                </Column>
                <Column caption="Nominal GDP">
                    <Column
                        dataField="GDP_Total"
                        caption="Total, mln $"
                        format="fixedPoint"
                        sortOrder="desc"
                    />
                    <Column caption="By Sector">
                        <Column
                            dataField="GDP_Agriculture"
                            caption="Agriculture"
                            // format={gdpFormat}
                            width={95}
                        />
                        <Column
                            dataField="GDP_Industry"
                            caption="Industry"
                            // format={gdpFormat}
                            width={80}
                        />
                        <Column
                            dataField="GDP_Services"
                            caption="Services"
                            // format={gdpFormat}
                            width={85}
                        />
                    </Column>
                </Column>
            </DataGrid>
        </ThemeProvider>
    );
};

export default StudentJournalPage;
