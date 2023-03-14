import {createTheme, ThemeProvider} from "@mui/material/styles";
import * as React from "react";
import './Profile.css'

const theme = createTheme();

const StudentProfilePage = () => {
    return (
        <ThemeProvider theme={theme}>
            <h1 className='ProfileHeader'>Student profile</h1>

        </ThemeProvider>
    );
}

export default StudentProfilePage;
