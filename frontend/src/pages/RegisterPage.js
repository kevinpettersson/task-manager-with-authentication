import {Box, Button, Heading, Input, VStack} from "@chakra-ui/react";
import {useState} from "react";
import {useNavigate} from "react-router-dom";
import {register} from "../api/auth.js"


function RegisterPage() {
    const navigate = useNavigate();
    const [username, setUsername] = useState("");
    const [password1, setPassword1] = useState("");
    const [password2, setPassword2] = useState("");

    const handleRegister = async () => {
        try {
            await register(username, password1, password2);
            navigate("/login");
            console.log("register ok");
        }
        catch (e){
            alert("Register account failed: " + e.message)
        }
    }

    return (
        <Box p={15} maxW="md" mx="auto">
            <Heading
                mb={"6"}
                textAlign={"center"}
                color={"green.500"}
            >
                Register account
            </Heading>
            <VStack spacing={"4"}>
                <Input
                    type={"text"}
                    borderColor={"green"}
                    placeholder={"Enter username"}
                    onChange={(e) => setUsername(e.target.value)}
                />
                <Input
                    type={"password"}
                    borderColor={"green"}
                    placeholder={"Enter password"}
                    onChange={(e) => setPassword1(e.target.value)}
                />
                <Input
                    type={"password"}
                    borderColor={"green"}
                    placeholder={"Confirm password"}
                    onChange={(e) => setPassword2(e.target.value)}
                />

                <Button colorScheme={"green"} onClick={() => handleRegister()}>
                    Register account
                </Button>
            </VStack>
        </Box>
    );
}

export default RegisterPage