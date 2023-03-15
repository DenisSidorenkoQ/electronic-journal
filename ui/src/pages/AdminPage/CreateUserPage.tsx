import { createTheme, ThemeProvider } from '@mui/material/styles';
import {useSessionStore} from "../../store";
import 'bootstrap/dist/css/bootstrap.min.css';
import CreateNewUserButton from "../../components/Menu/button/CreateNewUserButton";
import * as React from "react";
import './Admin.css'
import TextField from "@mui/material/TextField";
import Box from "@mui/material/Box";
import {useEffect} from "react";
import {FormControl, InputLabel, MenuItem, Select, SelectChangeEvent} from "@mui/material";
import {Role} from "../../model/RoleState";
import roleService from "../../service/RoleService";
import Button from "@mui/material/Button";
import userService from "../../service/UserService";
import {Group} from "../../model/GroupState";
import groupService from "../../service/GroupService";
import studentService from "../../service/StudentService";

const theme = createTheme();

const CreateUserPage = () => {
    let user = useSessionStore(state => state.user);

    const [roleList, setRoleList] = React.useState<Role[]>([]);
    const [login, setLogin] = React.useState('');
    const [password, setPassword] = React.useState('');
    const [selectedRoleId, setSelectedRoleId] = React.useState(0);
    const [selectedRoleName, setSelectedRoleName] = React.useState('');
    const [selectedFio, setSelectedFio] = React.useState('');
    const [selectedSex, setSelectedSex] = React.useState('');
    const [createdUserId, setCreatedUserId] = React.useState(0);
    const [groupList, setGroupList] = React.useState<Group[]>([]);
    const [selectedGroupId, setSelectedGroupId] = React.useState(0);


    useEffect(() => {
        roleService.getAllRoles().then(roles => setRoleList(roles));
    }, [user]);

    useEffect(() => {
        groupService.getGroupList().then(groups => setGroupList(groups));
    }, [selectedRoleName === "STUDENT"]);

    useEffect(() => {
        studentService.saveStudent(createdUserId, selectedGroupId, selectedFio, selectedSex);
    }, [createdUserId]);


    const handleRoleChange = (event: any) => {
        const roleId = parseInt(event.target.value);

        roleService.getRoleById(roleId).then(role => setSelectedRoleName(role.name));

        setSelectedRoleId(roleId);
    };

    const handleLoginChange = (event: { target: { value: React.SetStateAction<string>; }; }) => {
        setLogin(event.target.value);
    }

    const handlePasswordChange = (event: { target: { value: React.SetStateAction<string>; }; }) => {
        setPassword(event.target.value);
    }

    const handleSaveButton = async () => {
        await userService.saveUser(login, password, selectedRoleId).then(user => setCreatedUserId(user.id));
    };

    const selectionInputInformationByRoleId = (selectedRoleName: string) => {
        if (selectedRoleName === 'STUDENT') {
            return inputStudentInformation();
        }
    }

    const inputStudentInformation = () => {
        const handleFioChange = (event: { target: { value: React.SetStateAction<string>; }; }) => {
            setSelectedFio(event.target.value);
        }

        const handleSexChange = (event: { target: { value: React.SetStateAction<string>; }; }) => {
            setSelectedSex(event.target.value);
        }

        const handleGroupChange = (event: any) => {
            const groupId = parseInt(event.target.value);

            setSelectedGroupId(groupId);
        }

        return (
            <>
                <div className="gridElement">
                    <TextField onChange={handleFioChange} id="fio" label="fio" variant="outlined" />
                </div>
                <div className="gridElement">
                    <TextField onChange={handleSexChange} id="sex" label="sex" variant="outlined" />
                </div>
                <div className="gridElement">
                    <FormControl>
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
                                    <MenuItem value={group.id}>{group.name}</MenuItem>
                                ))
                            }
                        </Select>
                    </FormControl>
                </div>
            </>
        )
    }

    return (
        <ThemeProvider theme={theme}>
            <Box style={{
                position: 'absolute', left: '20%', top: '40%', display: 'flex'
            }}>
                <div className="gridContainer">
                    <div className="gridElement">
                        <TextField onChange={handleLoginChange} id="login" label="Login" variant="outlined" />
                    </div>
                    <div className="gridElement">
                        <TextField onChange={handlePasswordChange} id="password" label="Password" variant="outlined" />
                    </div>
                    <div className="gridElement">
                        <FormControl>
                            <InputLabel id="Role">Role</InputLabel>
                            <Select
                                labelId="Roles"
                                id="Roles"
                                value={selectedRoleId.toString()}
                                onChange={handleRoleChange}
                                label="Roles"
                                sx={{width: 300}}
                            >
                                {
                                    roleList.map((role) => (
                                        <MenuItem value={role.id}>{role.name}</MenuItem>
                                    ))
                                }
                            </Select>
                        </FormControl>
                    </div>
                    {selectionInputInformationByRoleId(selectedRoleName)}
                    <div className="gridElement">
                        <Button onClick={handleSaveButton} variant="contained" color="success">
                            Create
                        </Button>
                    </div>
                </div>
            </Box>

        </ThemeProvider>
    );
};

export default CreateUserPage;
