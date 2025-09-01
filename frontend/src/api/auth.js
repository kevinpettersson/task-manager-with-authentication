const API_BASE = "http://localhost:8081"

export async function login(username, password){

    const response = await fetch(API_BASE + "/login", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({username, password})
    });

    if(!response.ok){
        throw new Error("Login failed");
    }

    return await response.json();
}

export async function register(username, password1, password2){
    if(password1 !== password2){
        throw new Error("Passwords do not match");
    }

    const response = await fetch(API_BASE + "/register", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({username, password: password1})
    });

    if(!response.ok){
        throw new Error("Login Failed");
    }

    return await response.json();
}