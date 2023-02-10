import * as React from 'react';
import { ReactNode } from 'react';
import {
    Box,
    Tab, Tabs
} from '@mui/material';
import {Link} from "react-router-dom";
import MeetingRoomIcon from '@mui/icons-material/MeetingRoom';
import {Menu} from "@mui/icons-material";
import {useSessionStore} from "../store";

interface Props {
    children: ReactNode;
}

const drawerWidth=250
const navigationItems = [
  {
    title: 'Authorization',
    path: 'login',
    icon: <MeetingRoomIcon />
  },
  {
    title: 'Menu',
    path: 'menu',
    icon: <Menu />
  }
];

const JournalLayout = ({ children }: Props) => {
    const user = useSessionStore(state => state.user);

    return (
        <>
            <Tabs aria-label="Header">
                {navigationItems.map((item) => (
                    <Tab icon={item.icon} label={item.title} component={Link} to={item.path} />
                ))}
            </Tabs>
            <Box
                component="main"
                sx={{flexGrow: 1, p: 1, width: {sm: `calc(100% - ${drawerWidth}px)`}}}
            >
                {children}
            </Box>
        </>
    );
};


export default JournalLayout;
