import LoginPage from "./pages/LoginPage.js"
import { Routes, Route} from "react-router-dom"
import RegisterPage from "./pages/RegisterPage";
import TaskPage from "./pages/TaskPage";

function App() {
    return (
        <Routes>
            <Route path={"/login"} element={<LoginPage />} />
            <Route path={"/register"} element={<RegisterPage />} />
            <Route path={"/tasks"} element={<TaskPage />} />
        </Routes>
    );
}

export default App;

