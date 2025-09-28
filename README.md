# Task Manager with Authentication

## Project Overview
This project is a microservices-based application consisting of two Spring Boot services and a React frontend:

- **Auth Service** – Handles user authentication using **JWT tokens**. Users log in through the frontend, which stores the JWT for subsequent requests.
- **Task Service** – Manages **CRUD** operations for tasks. Requests to this service require a valid JWT from the Auth Service.
- **Frontend (React)** – Interacts with both backend services on different ports to provide a seamless user experience.
- **Database (PostgreSQL)** Each service connects to its own dedicated database inside a shared PostgreSQL instance.

## Tech Stack

<table>
    <tr>
        <th>Languages & Runtimes</th>
        <th>Frameworks & Libraries</th>
        <th>Database</th>
        <th>Tools & DevOps</th>
    </tr>
    <tr>
        <td valign="top">
            <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white">
            <img src="https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E">
            <img src="https://img.shields.io/badge/node.js-6DA55F?style=for-the-badge&logo=node.js&logoColor=white">
        </td>
        <td valign="top">
            <img src="https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB">
            <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white">
            <img src="https://img.shields.io/badge/chakra-%234ED1C5.svg?style=for-the-badge&logo=chakraui&logoColor=white">
        </td>
        <td valign="top">
            <img src="https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white">
        </td>
        <td valign="top">
            <img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white">
            <img src="https://img.shields.io/badge/kubernetes-%23326ce5.svg?style=for-the-badge&logo=kubernetes&logoColor=white">
            <img src="https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white">
            <img src="https://img.shields.io/badge/apachemaven-C71A36.svg?style=for-the-badge&logo=apachemaven&logoColor=white">
        </td>
    </tr>
</table>

## Running the application
### Step 1 – Install Docker and Docker Compose
Make sure Docker **and Docker Compose** are installed on your machine.

- On **(Windows/Mac**), Docker Compose is often included by default.

- On **Linux**, Docker Compose might not be installed by default

You can download Docker Desktop here: [https://www.docker.com/products/docker-desktop](https://www.docker.com/products/docker-desktop)

To verify installation, run:
```bash
docker --version
docker compose version
```

---

### Step 2 - Clone the repository
Clone the repository into a folder of your choice:
```bash
git clone https://github.com/kevinpettersson/task-manager-with-authentication.git
```

---

### Step 3 - Build and start the Docker container
Navigate to the project directory:
```bash
cd /path/to/task-manager-with-authentication
```
Then run Docker Compose:
```bash
docker compose up
```
The first build may take a few minutes as Docker install all dependencies.

---

### Step 4 - Access the Web Application
Once the containers are up and running, open your browser and go to:
```arduino
http://localhost:3000/
```


          
