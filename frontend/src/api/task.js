const API_BASE = "http://localhost:8082";

export async function create(name, description){
    const token = localStorage.getItem("token");
    const response = await fetch(API_BASE + "/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + token
        },
        body: JSON.stringify({name, description})
    });

    if(!response.ok){
        throw new Error("Failed to create task");
    }
    return await response.json();
}

export async function deleteTask(id){
    const token = localStorage.getItem("token");
    const response = await fetch(`${API_BASE}/delete?id=${id}`, {
        method: "DELETE",
        headers: {"Authorization": "Bearer " + token},
    });

    if(!response.ok){
        throw new Error("Failed to delete task");
    }
    return await response.json();
}