import {useNavigate} from "react-router-dom";
import Button from "@mui/material/Button";
import {blue, grey} from "@mui/material/colors";
import NoteAddIcon from '@mui/icons-material/NoteAdd';
import * as React from "react";

const CreateAdditionalEntitiesButton = () => {
    let navigate = useNavigate();

    const handleJournalButton = () => {
        navigate('/admin-panel/create/entities');
    };

    return (
        <Button
            type="submit"
            variant="outlined"
            sx={{bgcolor: blue[500], color: grey[900]}}
            size={"large"}
            onClick={handleJournalButton}
        >
            <NoteAddIcon style={{width: '100%', height: '100%'}}/>
        </Button>
    )
}

export default CreateAdditionalEntitiesButton;
