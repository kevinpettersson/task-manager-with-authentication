# devops-microservices-project

## Project Overview
This project is a microservices-based application consisting of two Spring Boot services and a React frontend:

* **Auth Service** - Handles user authentication using **JWT tokens**. Users log in through the frontend, which stores the JWT for subsequent requests.

* **Task Service** - Handles **CRUD** operations. Requests to this services requires a valid JWT from Auth service

* The frontend is built using **React** and interacts with both services on different ports to provide a seamless experience.

* The application uses **PostgreSQL** as database, with each service interacting with their respective database.

## Tech Stack
**Languages & Runtimes**

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)

![NodeJS](https://img.shields.io/badge/node.js-6DA55F?style=for-the-badge&logo=node.js&logoColor=white)

**Framework & Libraries**

![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

![Chakra](https://img.shields.io/badge/chakra-%234ED1C5.svg?style=for-the-badge&logo=chakraui&logoColor=white)

**Database**

![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

**Tools & Devops**

![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

![Kubernetes](https://img.shields.io/badge/kubernetes-%23326ce5.svg?style=for-the-badge&logo=kubernetes&logoColor=white) (Not yet)

![GitHub Actions](https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white)

![Maven](https://img.shields.io/badge/apachemaven-C71A36.svg?style=for-the-badge&logo=apachemaven&logoColor=white)


##

### Running the application
The application will be runnable using Docker Compose once all services are containerized.  





          
