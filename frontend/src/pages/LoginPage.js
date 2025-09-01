import {Box, Button, Heading, Input, VStack} from "@chakra-ui/react";
import { useNavigate } from "react-router-dom"
import { login } from "../api/auth.js"
import { useState } from "react";

function LoginPage() {
    const navigate = useNavigate();
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")

    const handleLogin = async () => {
        try {
            const response = await login(username, password);
            const token = response.token.trim();
            localStorage.setItem("token", token);
            navigate("/tasks");
            console.log("ok logggggg");
        }
        catch (e){
            alert("Login failed: " + e.message)
        }
    }

    return (

        <Box p={15} maxW="md" mx="auto">
            <Heading
                mb={"6"}
                textAlign={"center"}
                color={"green.500"}
            >
                Login
            </Heading>
            <VStack spacing={"4"}>
                <Input
                    type={"text"}
                    borderColor={"green"}
                    placeholder={"Username"}
                    onChange={(e) => setUsername(e.target.value)}
                />
                <Input
                    type={"password"}
                    borderColor={"green"}
                    placeholder={"Password"}
                    onChange={(e) => setPassword(e.target.value)}
                />

                <Button colorScheme={"green"} onClick={() => handleLogin()}>Login</Button>

                <Button colorScheme={"green"} onClick={() => navigate("/register")}>
                    Don't have an account? Register here
                </Button>
            </VStack>
        </Box>
    );
}

export default LoginPage