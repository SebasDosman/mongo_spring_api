# Spring MongoDB REST API Project
Welcome to our Spring project with MongoDB integration. This project demonstrates building a RESTful API using Spring Boot and MongoDB, dockerized for easy deployment.

## HTTP Methods
In RESTful APIs, various HTTP methods (verbs) are used to perform different actions on resources. Here are the commonly used HTTP verbs:

## GET
The GET method is used to retrieve data from a specified resource. It should only retrieve data and should not have any other effect.

Example:
```bash
GET /user/getAllUsers
```

## POST
The POST method is used to submit data to be processed to a specified resource. It's often used to create a new resource.

Example:
```bash
POST /user/saveUser
{
    "name": "John",
    "lastName": "Doe",
    "age": 20,
    "email": "johndoe@example.com",
    "password": "John123*"
}
```

## DELETE
The DELETE method is used to delete a specified resource.

Example:
```bash
DELETE /user/deleteUser/123
```

## PATCH
The PATCH method is used to apply partial modifications to a resource.

Example:
```bash
PATCH /api/patchUser/123
{
    "id": "123",
    "name": "John",
    "lastName": "Doe",
    "age": 20,
    "email": "johndoe@example.com",
    "password": "John123*"
}
```

## PUT
The PUT method is used to update a resource or create a new resource if it does not exist.

Example:
```bash
PUT /user/updateUser/123
{
    "id": "123",
    "name": "John",
    "lastName": "Doe",
    "age": 20,
    "email": "johndoe@example.com",
    "password": "John123*"
}
```

## HEAD
The HEAD method asks for a response identical to that of a GET request, but without the response body. It's useful for retrieving metadata.

Example:
```bash
HEAD /user/getUserHeaderById/123
```

## OPTIONS
The OPTIONS method is used to describe the communication options for the target resource.

Example:
```bash
OPTIONS /user/userOptions
```

## Getting Started
Follow these steps to get started with the project:
1. Clone the repository.
2. Install Docker and Docker Compose if not already installed.
3. Run docker-compose up to start the MongoDB container.
4. Run the Spring Boot application.
5. Use tools like Postman or curl to interact with the API using the defined HTTP verbs.
