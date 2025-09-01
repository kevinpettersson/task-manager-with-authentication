import {Box, Button, Heading, Input, Stack, Text} from "@chakra-ui/react";
import {useEffect, useState} from "react";

const API_BASE = "http://localhost:8082";

function TaskPage() {
    const [tasks, setTasks] = useState([]);

    useEffect(() => {
        const fetchTasks = async () => {
            try {
                const token = localStorage.getItem("token")?.trim();
                const response = await fetch(API_BASE + "/tasks", {
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": "Bearer " + token,
                    },
                });

                if(!response.ok){
                    throw new Error("Failed to fetch tasks")
                }
                const data = await response.json();
                setTasks(data);
            } catch (e){
                alert(e)
            }
        };
        fetchTasks();
    }, []);

    return (
        <Box p={15} maxW="md" mx="auto">
            <Heading
                mb={"6"}
                textAlign={"center"}
                color={"green.500"}
            >
                Tasks
            </Heading>
            <Stack spacing={2}>
                {tasks.length === 0 && <Text>No tasks available</Text>}
                {tasks.map(task => (
                    <Box
                        key={task.id}
                        p={3}
                        borderWidth="1px"
                        borderRadius="md"
                        bg={task.completed ? "green.50" : "red.50"}
                    >
                        <Text fontWeight="bold">{task.name}</Text>
                        <Text fontWeight="bold">{task.description}</Text>

                    </Box>
                ))}
            </Stack>
            <Box as={"fieldset"}>
                <Stack spacing={2}>
                    <Text as={"legend"}>Create Task</Text>
                    <Input placeholder={"Name"} borderColor={"green"} />
                    <Input placeholder={"Description"} borderColor={"green"} />
                    <Button type={"submit"} colorScheme={"green"}>
                        Submit
                    </Button>
                </Stack>
            </Box>
        </Box>
    );
}

export default TaskPage