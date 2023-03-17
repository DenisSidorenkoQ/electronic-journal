import { createTheme, ThemeProvider } from '@mui/material/styles';
import {useSessionStore} from "../../store";
import 'bootstrap/dist/css/bootstrap.min.css';
import * as React from "react";
import './Admin.css'
import Box from "@mui/material/Box";
import {FormControl, InputLabel, MenuItem, Select} from "@mui/material";
import {useEffect} from "react";
import groupService from "../../service/GroupService";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import userService from "../../service/UserService";

const theme = createTheme();

const CreateAdditionalEntitiesPage = () => {
    let user = useSessionStore(state => state.user);

    const [selectedEntityId, setSelectedEntityId] = React.useState(0);
    const [selectedGroupName, setSelectedGroupName] = React.useState('');

    const handleEntityChange = (event: any) => {
        const selectedEntityId = parseInt(event.target.value);

        setSelectedEntityId(selectedEntityId);
    }

    const handleSaveGroupButton = () => {
        groupService.saveGroup(selectedGroupName);
    };

    const inputGroupInformation = () => {
        const handleGroupNameChange = (event: { target: { value: React.SetStateAction<string>; }; }) => {
            setSelectedGroupName(event.target.value);
        }

        return (
            <>
                <div className="gridElement">
                    <TextField onChange={handleGroupNameChange} id="groupName" label="Group name" variant="outlined" />
                </div>
                <div className="gridElement">
                    <Button onClick={handleSaveGroupButton} variant="contained" color="success">
                        Create
                    </Button>
                </div>
            </>
        )
    }

    const selectionInputInformationByEntityId = () => {
        if (selectedEntityId === 1) {
            return inputGroupInformation();
        }
        if (selectedEntityId === 2) {

        }
        if (selectedEntityId === 3) {

        }
    }

    return (
        <ThemeProvider theme={theme}>
            <Box style={{
                position: 'absolute', left: '20%', top: '40%', display: 'flex'
            }}>
                <div className="gridContainer">
                    <div className="gridElement">
                        <FormControl>
                            <InputLabel id="Entity">Entity</InputLabel>
                            <Select
                                labelId="Entity"
                                id="Entity"
                                value={selectedEntityId.toString()}
                                onChange={handleEntityChange}
                                label="Entity"
                                sx={{width: 300}}
                            >
                                <MenuItem value={1}>Group</MenuItem>
                                <MenuItem value={2}>Department</MenuItem>
                                <MenuItem value={3}>Subject</MenuItem>
                            </Select>
                        </FormControl>
                    </div>
                    {selectionInputInformationByEntityId()}
                </div>
            </Box>

        </ThemeProvider>
    );
};

export default CreateAdditionalEntitiesPage;
