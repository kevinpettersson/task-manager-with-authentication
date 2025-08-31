import {Box, Button, Heading, Input} from "@chakra-ui/react";
import {PasswordInput} from "./ui/password-input";

function RegisterPage() {
    return (
        <Box>
            <Heading>Register account</Heading>

            <Input borderColor={"green"} placeholder={"Enter username"}/>

            <PasswordInput borderColor={"green"} placeholder={"Enter password"}/>

            <PasswordInput borderColor={"green"} placeholder={"Confirm password"}/>

            <Button colorScheme={"green"}>Register account</Button>
        </Box>
    );
}

export default RegisterPage