import * as React from 'react';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import Box from "@mui/material/Box";
import './Menu.css';
import CreateNewUserButton from "../../components/Menu/button/CreateNewUserButton";
import CreateAdditionalEntitiesButton from "../../components/Menu/button/CreateAdditionalEntitiesButton";

const theme = createTheme();


const AdminMenuPage = () => {
    return (
        <ThemeProvider theme={theme}>
            <Box style={{
                position: 'absolute', left: '40%', top: '40%', display: 'flex'
            }}>
                <div className="gridContainer">
                    <div className="gridElement">
                        {CreateNewUserButton()}
                    </div>
                    <div className="gridElement">
                        {CreateAdditionalEntitiesButton()}
                    </div>
                </div>
            </Box>

        </ThemeProvider>
    );
};

export default AdminMenuPage;
