import * as React from 'react';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import Box from "@mui/material/Box";
import {blue, grey, red} from "@mui/material/colors";
import Button from "@mui/material/Button";
import {useNavigate} from "react-router-dom";

const theme = createTheme();


const MenuPage = () => {
    let navigate = useNavigate();

    const handleJournalButton = () => {
        navigate('/journal');
    };

    return (
        <ThemeProvider theme={theme}>
            <Box style={{
                position: 'absolute', left: '40%', top: '50%'
            }} >
                <Button
                    type="submit"
                    variant="outlined"
                    sx={{bgcolor: blue[500], color: grey[900]}}
                    size={"large"}
                    onClick={handleJournalButton}
                >
                    Journal
                </Button>
            </Box>

        </ThemeProvider>
    );
};

export default MenuPage;
