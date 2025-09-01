import {
    Box,
    Button,
    Heading, IconButton, Input,
    Modal, ModalBody, ModalCloseButton,
    ModalContent, ModalFooter,
    ModalHeader,
    ModalOverlay,
    Stack,
    Text,
    useDisclosure
} from "@chakra-ui/react";
import {create, deleteTask} from "../api/task.js"
import {useEffect, useState} from "react";
import {FaTrash} from "react-icons/fa";

const API_BASE = "http://localhost:8082";

function TaskPage() {

    const [tasks, setTasks] = useState([]);
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const {onOpen, onClose, isOpen} = useDisclosure();

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
                const data = await response.json();
                setTasks(data);
            } catch (e){
                alert(e);
            }
        };
        fetchTasks();
    }, []);

    const handleSubmit = async () => {
        onClose();
        try {
            const newTask = await create(name, description);
            setTasks(prevState => [...prevState, newTask]);
            setName("");
            setDescription("");
        } catch(e){
            alert("Failed to create task: " + e.message);
        }
    }

    const handleDelete = async (id) => {
        try {
            await deleteTask(id);
            setTasks(prevState => prevState.filter(task => task.id !== id));
        } catch(e){
            alert("Failed to delete task: " + e.message);
        }
    }

    return (
        <Box p={15} maxW="md" mx="auto">
            <Heading mb={"6"} textAlign={"center"} color={"green.500"}>
                Tasks
            </Heading>

            <Stack spacing={2} mb={"6"}>
                {tasks.length === 0 && <Text>No tasks available</Text>}
                {tasks.map(task => (
                    <Box
                        key={task.id}
                        p={3}
                        borderWidth="1px"
                        borderRadius="md"
                        display={"flex"}
                        justifyContent={"space-between"}
                        alignItems="flex-start"
                        bg={"green.50"}
                    >
                        <Box flex="1" mr={2}>
                            <Text wordBreak="break-word" whiteSpace={"normal"} fontWeight="bold">{task.name}</Text>
                            <Text wordBreak="break-word" whiteSpace={"normal"}>{task.description}</Text>
                        </Box>

                        <IconButton
                            aria-label={"Delete task"}
                            colorScheme={"red"}
                            icon={<FaTrash />}
                            onClick={() => handleDelete(task.id)}
                        />
                    </Box>
                ))}
            </Stack>

            <Button colorScheme={"green"} onClick={onOpen}>
                + Create Task
            </Button>

            <Modal isOpen={isOpen} onClose={onClose} isCentered={true}>
                <ModalOverlay />
                <ModalContent>
                    <ModalHeader>Create Task</ModalHeader>
                    <ModalCloseButton />
                    <ModalBody>
                        <Stack spacing={3}>
                            <Input
                                placeholder={"Name"}
                                onChange={(e) => setName(e.target.value)}
                            />
                            <Input
                                placeholder={"Description"}
                                onChange={(e) => setDescription(e.target.value)}
                            />
                        </Stack>
                    </ModalBody>

                    <ModalFooter>
                        <Button mr={3} onClick={onClose}>
                            Cancel
                        </Button>
                        <Button colorScheme={"green"} onClick={() => handleSubmit()}>
                            Submit
                        </Button>
                    </ModalFooter>
                </ModalContent>
            </Modal>
        </Box>
    );
}

export default TaskPage