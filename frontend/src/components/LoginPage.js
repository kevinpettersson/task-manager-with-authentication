import {useState} from "react";
import RegisterPage from './RegisterPage'
import {Box, Button, Heading, Input, Text} from "@chakra-ui/react";
import { PasswordInput } from "./ui/password-input"

function LoginPage() {
    const [showRegister, setShowRegister] = useState(false);

    if(showRegister){
        return <RegisterPage />; // swap to register page
    }

    return (
        <Box>
            <Heading>Login</Heading>

            <Input borderColor={"green"} placeholder={"Username"}/>
            <PasswordInput borderColor={"green"} placeholder={"Password"}/>

            <Button colorScheme={"green"}> Login</Button>
            <Text>Don't have an account? Register now!</Text>

            <Button
                colorScheme={"green"}
                onClick={() => setShowRegister(true)}
            >
                Register
            </Button>
        </Box>
    );
}

export default LoginPage