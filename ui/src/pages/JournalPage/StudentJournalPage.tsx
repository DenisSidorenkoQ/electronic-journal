import * as React from 'react';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import {SelectChangeEvent, FormControl, InputLabel, MenuItem, Select} from "@mui/material";
import {useSessionStore} from "../../store";
import StudentService from "../../service/StudentService";
import SubjectService from "../../service/SubjectService";
import {Subject} from "../../model/SubjectState";
import {useEffect} from "react";
import LessonService from "../../service/LessonService";
import {Lesson} from "../../model/LessonState";
import studentService from "../../service/StudentService";
import {Student} from "../../model/StudentState";
import markService from "../../service/MarkService";
import {Mark} from "../../model/MarkState";
import 'bootstrap/dist/css/bootstrap.min.css';
import Table from 'react-bootstrap/Table';
import {StudyPass} from "../../model/StudyPassState";
import studyPassService from "../../service/StudyPassService";

import './Journal.css';

const theme = createTheme();

function getDateFromTimestamp (timestamp: number ) {
    return new Date(timestamp * 1000).toLocaleDateString('ru-RU',
        { year: '2-digit', month: '2-digit', day: '2-digit'});
}

function studyPassConverter ( pass: boolean ) {
    if (pass) {
        return "н";
    } else {
        return "";
    }
}

const StudentJournalPage = () => {
    const [selectedSubjectId, setSelectedSubjectId] = React.useState(0);
    const [groupId, setGroupId] = React.useState(0);
    const [subjectList, setSubjectList] = React.useState<Subject[]>([]);
    const [lessonList, setLessonList] = React.useState<Lesson[]>([]);
    const [studentList, setStudentList] = React.useState<Student[]>([]);
    const [markList, setMarkList] = React.useState<Mark[]>([]);
    const [passList, setPassList] = React.useState<StudyPass[]>([]);
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
        studentService.getStudentsByGroupId(groupId).then(students => setStudentList(students));

        markService.getMarkBySubjectIdAndGroupId(selectedSubjectId, groupId).then(marks => {
            setMarkList(marks);
        });

        studyPassService.getStudyPassBySubjectIdAndGroupId(selectedSubjectId, groupId).then(pass => {
            setPassList(pass);
        })
    }, [lessonList]);


    function getGrid() {
        if (lessonList.length === 0) return;
        return (
            <Table className="table w-auto text-xsmall" bordered size="sm">
                <thead>
                    <tr>
                        <th rowSpan={2} colSpan={1}>
                            Students
                        </th>
                            {
                                lessonList.map(lesson => {
                                return (
                                    <th rowSpan={1} colSpan={2}>
                                        {
                                            lesson.themeName + "\t" + getDateFromTimestamp(lesson.dateTimestamp)
                                        }
                                    </th>
                                )
                            })
                            }
                    </tr>
                    <tr>
                        {
                            lessonList.map(lesson => {
                                return (
                                    <>
                                        <th>Mark</th>
                                        <th>Pass</th>
                                    </>
                                )
                            })
                        }
                    </tr>
                </thead>
                <tbody>
                {
                    studentList.map(student => {
                        return (
                            <tr>
                                <td>{student.fio}</td>
                                {
                                    lessonList.map(lesson => {
                                        let lessonMark: Mark | undefined;
                                        let lessonPass: StudyPass | undefined;

                                        lessonMark = markList.find(mark => {
                                            return mark.studentId === student.id && mark.lessonId === lesson.id;
                                        })

                                        lessonPass = passList.find(pass => {
                                            return pass.studentId === student.id && pass.lessonId === lesson.id;
                                        })

                                        if (lessonMark !== undefined && lessonPass !== undefined) {
                                            return (
                                                <React.Fragment>
                                                    <td>{lessonMark.number}</td>
                                                    <td>{studyPassConverter(lessonPass.pass)}</td>
                                                </React.Fragment>
                                            )
                                        } if (lessonMark !== undefined && lessonPass === undefined) {
                                            return (
                                                <React.Fragment>
                                                    <td>{lessonMark.number}</td>
                                                    <td></td>
                                                </React.Fragment>
                                            )
                                        } if (lessonPass !== undefined && lessonMark === undefined) {
                                            return (
                                                <React.Fragment>
                                                    <td></td>
                                                    <td>
                                                        {studyPassConverter(lessonPass.pass)}
                                                    </td>
                                                </React.Fragment>
                                            )
                                        } if (lessonPass === undefined && lessonMark === undefined) {
                                            return (
                                                <React.Fragment>
                                                    <td></td>
                                                    <td></td>
                                                </React.Fragment>
                                            )
                                        }
                                    })
                                }
                            </tr>
                        )
                    })

                }
                </tbody>
            </Table>
        )
    }

    const handleSubjectChange = (event: SelectChangeEvent) => {
        const subjectId = parseInt(event.target.value);

        setSelectedSubjectId(subjectId);
    };

    return (
        <ThemeProvider theme={theme}>
            <Container component="main" maxWidth="xs">
                <div>
                    <FormControl sx={{m: 1, minWidth: 80}}>
                        <InputLabel id="subjectsLabel">Subject</InputLabel>
                        <Select
                            labelId="subjects"
                            id="subjects"
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
                { getGrid() }
        </ThemeProvider>
    );
};

export default StudentJournalPage;
