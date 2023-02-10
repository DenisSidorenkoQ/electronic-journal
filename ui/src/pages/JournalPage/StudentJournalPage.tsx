import * as React from 'react';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import {Tabs, Tab, SelectChangeEvent, FormControl, InputLabel, MenuItem, Select} from "@mui/material";
import {useEffect} from "react";
import {useSessionStore} from "../../store";

const theme = createTheme();

const StudentJournalPage = () => {
    const [subject, setSubject] = React.useState('');
    const user = useSessionStore(state => state.user);

    const handleSubjectChange = (event: SelectChangeEvent) => {
        setSubject(event.target.value);
    };

    useEffect(() => {
    });

    return (
        <ThemeProvider theme={theme}>
            <Container component="main" maxWidth="xs">
                <div>
                    <FormControl sx={{ m: 1, minWidth: 80 }}>
                        <InputLabel id="demo-simple-select-autowidth-label">Subject</InputLabel>
                        <Select
                            labelId="demo-simple-select-autowidth-label"
                            id="demo-simple-select-autowidth"
                            value={subject}
                            onChange={handleSubjectChange}
                            label="Subject"
                            sx={{width: 300}}
                        >
                            <MenuItem>Twenty</MenuItem>
                            <MenuItem>Twenty one</MenuItem>
                            <MenuItem>Twenty one and a half</MenuItem>
                        </Select>
                    </FormControl>
                </div>
            </Container>
        </ThemeProvider>
    );
};

export default StudentJournalPage;
