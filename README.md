# Course Management Backend

This repository contains a full-stack application for managing courses. It includes a backend API developed with Spring Boot, a frontend application developed with React, and uses PostgreSQL as the database. The application is containerized using Docker and orchestrated with Docker Compose.

**Frontend Source Code is available** [here](https://github.com/r0ckYr/course-management-frontend)



## Features
* Backend API: Developed with Spring Boot.
* Frontend: Developed with ReactJS.
* Database: PostgreSQL.
* Containerization: Docker.
* Orchestration: Docker Compose.

## Getting Started

### Prerequisites
* Docker
* Docker Compose
* Java JDK 17 (for backend development)
* ReactJs (for frontend development)


### Installation
1. Clone the repo : ```https://github.com/r0ckYr/CourseManagement.git```
2. ```cd CourseManagement```
3. ```docker-compose up --build```
 

### Accessing the Application
* **Frontend**: Open http://localhost:3000 in your web browser.
* **Backend API**: The backend API will be available at http://localhost:8080 


### Configuration
* **Database Configuration**: The PostgreSQL database will be initialized with a database named ```coursemanagement```.
* **Backend Configuration**: The backend service connects to the PostgreSQL database using environment variables defined in the ```docker-compose.yml``` file.


## Standalone Backend 
1. Clone the repo : ```https://github.com/r0ckYr/CourseManagement.git```
2. ```cd CouresManagement```
3. ```mvn clean install```
4. ```cd target```
5. ```java -jar CourseManagement*.jar```


### Docker
1. Pull the image : ```docker pull r0ckyr/course-management-backend```
2. Run : ```docker run -p 8080:8080 r0ckyr/course-management-backend```


