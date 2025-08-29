import {useState} from "react";
import RegisterPage from './RegisterPage'

function LoginPage() {
    const [showRegister, setShowRegister] = useState(false);

    if(showRegister){
        return <RegisterPage />; // swap to register page
    }

    return (
        <>
            <h1>Login</h1>

            <input type={"name"} name={"Username"} placeholder={"Username"}/>
            <br />
            <input type={"password"} name={"Password"} placeholder={"Password"}/>
            <br />

            <button>Login</button>
            <br />
            Don't have an account? Register now!
            <br />
            <button onClick={() => setShowRegister(true)}> Register</button>
        </>
    );
}

export default LoginPage