import 'devextreme/dist/css/dx.light.css';
import React, { useEffect } from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import LoginPage from './pages/LoginPage/LoginPage';
import JournalLayout from "./components/JournalLayout";
import MenuPage from "./pages/MenuPage/MenuPage";
import {useSessionStore} from "./store";
import LoadingScreen from "./components/LoadingScreen";
import StudentJournalPage from "./pages/JournalPage/StudentJournalPage";

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
                    <Route path={'/menu'} element={<MenuPage />} />
                    <Route path={'/journal'} element={<StudentJournalPage />} />
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
