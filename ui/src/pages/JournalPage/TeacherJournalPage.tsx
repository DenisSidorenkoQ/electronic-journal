import * as React from 'react';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import {
    SelectChangeEvent,
    FormControl,
    InputLabel,
    MenuItem,
    Select,
    IconButton,
    useMediaQuery, Dialog, DialogTitle, DialogContent, DialogActions
} from "@mui/material";
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import {useSessionStore} from "../../store";
import SubjectService from "../../service/SubjectService";
import {GroupHasSubject, Subject} from "../../model/SubjectState";
import {useEffect} from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

import './Journal.css';
import TeacherService from "../../service/TeacherService";
import {Group} from "../../model/GroupState";
import GroupService from "../../service/GroupService";
import subjectService from "../../service/SubjectService";
import Table from "react-bootstrap/Table";
import {Mark} from "../../model/MarkState";
import {StudyPass} from "../../model/StudyPassState";
import lessonService from "../../service/LessonService";
import {Lesson} from "../../model/LessonState";
import studentService from "../../service/StudentService";
import markService from "../../service/MarkService";
import studyPassService from "../../service/StudyPassService";
import {Student} from "../../model/StudentState";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import journalService from "../../service/JournalService";
import {Journal} from "../../model/JournalState";

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

const TeacherJournalPage = () => {
    const [teacherId, setTeacherId] = React.useState(0);
    const [selectedGroupId, setSelectedGroupId] = React.useState(0);
    const [selectedSubjectId, setSelectedSubjectId] = React.useState(0);
    const [groupHasSubjectList, setGroupHasSubjectList] = React.useState<GroupHasSubject[]>([]);
    const [groupIdSet, setGroupIdSet] = React.useState(() => new Set());
    const [groupList, setGroupList] = React.useState<Group[]>([]);
    const [subjectList, setSubjectList] = React.useState<Subject[]>([]);
    const [lessonList, setLessonList] = React.useState<Lesson[]>([]);
    const [studentList, setStudentList] = React.useState<Student[]>([]);
    const [markList, setMarkList] = React.useState<Mark[]>([]);
    const [passList, setPassList] = React.useState<StudyPass[]>([]);
    const [journal, setJournal] = React.useState<Journal>();
    const [lessonTitle, setLessonTitle] = React.useState("");

    const [open, setOpen] = React.useState(false);
    const fullScreen = useMediaQuery(theme.breakpoints.down('md'));

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
        subjectService.getSubjectsByTeacherIdAndGroupId(teacherId, selectedGroupId).then(subjects => setSubjectList(subjects));
    }, [selectedGroupId]);

    useEffect(() => {
        lessonService.getAllLessonsByGroupIdAndSubjectId(selectedGroupId, selectedSubjectId).then(lessons => setLessonList(lessons));
    }, [selectedSubjectId, journal]);

    useEffect(() => {
        studentService.getStudentsByGroupId(selectedGroupId).then(students => setStudentList(students));

        markService.getMarkBySubjectIdAndGroupId(selectedSubjectId, selectedGroupId).then(marks => {
            setMarkList(marks);
        });

        studyPassService.getStudyPassBySubjectIdAndGroupId(selectedSubjectId, selectedGroupId).then(pass => {
            setPassList(pass);
        })
    }, [lessonList]);

    const handleGroupChange = (event: SelectChangeEvent) => {
        const groupId = parseInt(event.target.value);

        setSelectedGroupId(groupId);
    };

    const handleSubjectChange = (event: SelectChangeEvent) => {
        const subjectId = parseInt(event.target.value);

        setSelectedSubjectId(subjectId);
    };

    const handleOpenAddLessonDialogButton = () => {
        setOpen(true);
    };

    const handleCloseAddLessonDialog = () => {
        setOpen(false);
    };

    const handleSaveLessonButton = async () => {
        if (lessonTitle === "") return;

        const currentTimestamp = Math.floor(Date.now() / 1000);
        setJournal(await journalService.getJournalByGroupId(selectedGroupId));
        await lessonService.saveLesson(journal?.id, selectedSubjectId, lessonTitle, currentTimestamp);
        setOpen(false);
    };

    const handleLessonTitleChange = (event: { target: { value: React.SetStateAction<string>; }; }) => {
        setLessonTitle(event.target.value);
    }

    function subjectSelect() {
        if (subjectList.length === 0) return;
        return (
            <div>
                <FormControl sx={{m: 1, minWidth: 80}}>
                    <InputLabel id="Subjects">Subjects</InputLabel>
                    <Select
                        labelId="Subjects"
                        id="Subjects"
                        value={selectedSubjectId.toString()}
                        onChange={handleSubjectChange}
                        label="Subjects"
                        sx={{width: 300}}
                    >
                        {
                            subjectList.map((subject) => (
                                <MenuItem key={subject.id} value={subject.id}>{subject.name}</MenuItem>
                            ))
                        }
                    </Select>
                </FormControl>
            </div>
        )
    }

    function addLessonDialog() {
        return (
            <>
                <IconButton aria-label="add new lesson" size="large" onClick={handleOpenAddLessonDialogButton}>
                    <AddCircleOutlineIcon fontSize="inherit"/>
                </IconButton>
                <div>
                    <Dialog
                        fullScreen={fullScreen}
                        open={open}
                        onClose={handleCloseAddLessonDialog}
                        aria-labelledby="dialog-title"
                    >
                        <DialogTitle id="dialog-title">
                            {"Creating a new lesson"}
                        </DialogTitle>
                        <DialogContent>
                            <TextField
                                margin="normal"
                                required
                                fullWidth
                                id="lessonTitle"
                                label="lesson title"
                                name="lessonTitle"
                                value={lessonTitle}
                                onChange={handleLessonTitleChange}/>
                        </DialogContent>
                        <DialogActions>
                            <Button onClick={handleSaveLessonButton}>
                                Save
                            </Button>
                            <Button onClick={handleCloseAddLessonDialog} autoFocus>
                                Cancel
                            </Button>
                        </DialogActions>
                    </Dialog>
                </div>
            </>
        )
    }

    function grid() {
        if (lessonList.length === 0) return;
        return (
            <>
                {addLessonDialog()}
                <Table className="table w-auto text-xsmall" bordered size="sm">
                    <thead>
                    <tr>
                        <th rowSpan={2} colSpan={1}>
                            Students
                        </th>
                        {lessonList.map(lesson => {
                            return (
                                <th rowSpan={1} colSpan={2}>
                                    {lesson.themeName + "\t" + getDateFromTimestamp(lesson.dateTimestamp)}
                                </th>
                            );
                        })}
                    </tr>
                    <tr>
                        {lessonList.map(lesson => {
                            return (
                                <>
                                    <th>Mark</th>
                                    <th>Pass</th>
                                </>
                            );
                        })}
                    </tr>
                    </thead>
                    <tbody>
                    {studentList.map(student => {
                        return (
                            <tr>
                                <td>{student.fio}</td>
                                {lessonList.map(lesson => {
                                    let lessonMark: Mark | undefined;
                                    let lessonPass: StudyPass | undefined;

                                    lessonMark = markList.find(mark => {
                                        return mark.studentId === student.id && mark.lessonId === lesson.id;
                                    });

                                    lessonPass = passList.find(pass => {
                                        return pass.studentId === student.id && pass.lessonId === lesson.id;
                                    });

                                    if (lessonMark !== undefined && lessonPass !== undefined) {
                                        return (
                                            <React.Fragment>
                                                <td contentEditable={true}>{lessonMark.number}</td>
                                                <td contentEditable={true}>{studyPassConverter(lessonPass.pass)}</td>
                                            </React.Fragment>
                                        );
                                    }
                                    if (lessonMark !== undefined && lessonPass === undefined) {
                                        return (
                                            <React.Fragment>
                                                <td contentEditable={true}>{lessonMark.number}</td>
                                                <td contentEditable={true}></td>
                                            </React.Fragment>
                                        );
                                    }
                                    if (lessonPass !== undefined && lessonMark === undefined) {
                                        return (
                                            <React.Fragment>
                                                <td contentEditable={true}></td>
                                                <td contentEditable={true}>
                                                    {studyPassConverter(lessonPass.pass)}
                                                </td>
                                            </React.Fragment>
                                        );
                                    }
                                    if (lessonPass === undefined && lessonMark === undefined) {
                                        return (
                                            <React.Fragment>
                                                <td contentEditable={true}></td>
                                                <td contentEditable={true}></td>
                                            </React.Fragment>
                                        );
                                    }
                                })}
                            </tr>
                        );
                    })}
                    </tbody>
                </Table></>
        )
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
                {subjectSelect()}
            </Container>
            {grid()}
        </ThemeProvider>
    );
};

export default TeacherJournalPage;
