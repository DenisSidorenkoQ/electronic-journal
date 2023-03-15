import * as React from "react";
import {blue, grey} from "@mui/material/colors";
import Button from "@mui/material/Button";
import {useNavigate} from "react-router-dom";
import AccountBoxIcon from "@mui/icons-material/AccountBox";
import AutoStoriesIcon from "@mui/icons-material/AutoStories";

const JournalButton = () => {
    let navigate = useNavigate();

    const handleJournalButton = () => {
        navigate('/journal');
    };

    return (
        <Button
            type="submit"
            variant="outlined"
            sx={{bgcolor: blue[500], color: grey[900]}}
            size={"large"}
            onClick={handleJournalButton}
        >
            <AutoStoriesIcon style={{width: '100%', height: '100%'}}/>
        </Button>
    )
}

export default JournalButton;
