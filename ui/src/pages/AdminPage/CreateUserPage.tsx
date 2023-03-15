import { createTheme, ThemeProvider } from '@mui/material/styles';
import {useSessionStore} from "../../store";
import 'bootstrap/dist/css/bootstrap.min.css';
import CreateNewUserButton from "../../components/Menu/button/CreateNewUserButton";
import * as React from "react";
import './Admin.css'
import TextField from "@mui/material/TextField";
import JournalButton from "../../components/Menu/button/JournalButton";
import ProfileButton from "../../components/Menu/button/ProfileButton";
import Box from "@mui/material/Box";

const theme = createTheme();

const CreateUserPage = () => {
    let user = useSessionStore(state => state.user);

    return (
        <ThemeProvider theme={theme}>
            <Box style={{
                position: 'absolute', left: '40%', top: '40%', display: 'flex'
            }}>
                <div className="gridContainer">
                    <div className="gridElement">
                        <TextField id="password" label="Login" variant="outlined" />
                    </div>
                    <div className="gridElement">
                        <TextField id="login" label="Password" variant="outlined" />
                    </div>
                </div>
            </Box>

        </ThemeProvider>
    );
};

export default CreateUserPage;
