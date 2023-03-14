import 'devextreme/dist/css/dx.light.css';
import React, { useEffect } from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import LoginPage from './pages/LoginPage/LoginPage';
import JournalLayout from "./components/JournalLayout";
import TeacherMenuPage from "./pages/MenuPage/TeacherMenuPage";
import {useSessionStore} from "./store";
import LoadingScreen from "./components/LoadingScreen";
import StudentJournalPage from "./pages/JournalPage/StudentJournalPage";
import TeacherJournalPage from "./pages/JournalPage/TeacherJournalPage";
import StudentMenuPage from "./pages/MenuPage/StudentMenuPage";
import StudentProfilePage from "./pages/ProfilePage/StudentProfilePage";

function App() {
    const user = useSessionStore(state => state.user);
    const loading = useSessionStore(state => state.loading);

    const getSession = useSessionStore(state => state.getSession);

    useEffect(() => {
        getSession();
    }, []);

    if (loading) {
        return <LoadingScreen />;
    }

    if (user?.roleName === 'STUDENT') {
        return (
            <JournalLayout>
                <Routes>
                    <Route path={'/login'} element={<LoginPage />} />
                    <Route path={'/menu'} element={<StudentMenuPage />} />
                    <Route path={'/journal'} element={<StudentJournalPage />} />
                    <Route path={'/profile'} element={<StudentProfilePage />} />
                    <Route path={'*'} element={<Navigate to="/menu" replace />} />
                </Routes>
            </JournalLayout>
        );
    }

    if (user?.roleName === 'TEACHER') {
        return (
            <JournalLayout>
                <Routes>
                    <Route path={'/login'} element={<LoginPage />} />
                    <Route path={'/menu'} element={<TeacherMenuPage />} />
                    <Route path={'/journal'} element={<TeacherJournalPage />} />
                    <Route path={'*'} element={<Navigate to="/menu" replace />} />
                </Routes>
            </JournalLayout>
        );
    }

    return (
        <Routes>
            <Route path={'/login'} element={<LoginPage />} />
            <Route path={'*'} element={<Navigate to="/login" replace />} />
        </Routes>

    );
}

export default App;
