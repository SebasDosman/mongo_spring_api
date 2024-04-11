# Spring MongoDB REST API Project
Welcome to our Spring project with MongoDB integration. This project demonstrates building a RESTful API using Spring Boot and MongoDB, dockerized for easy deployment.

## HTTP Verbs
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
POST /api/users
{
    "name": "John Doe",
    "email": "johndoe@example.com"
}
```

## DELETE
The DELETE method is used to delete a specified resource.

Example:
```bash
DELETE /api/users/123
```

## PATCH
The PATCH method is used to apply partial modifications to a resource.

Example:
```bash
PATCH /api/users/123
{
  "email": "newemail@example.com"
}
```

## PUT
The PUT method is used to update a resource or create a new resource if it does not exist.

Example:
```bash
PUT /api/users/123
{
"name": "Jane Doe",
"email": "janedoe@example.com"
}
```

## HEAD
The HEAD method asks for a response identical to that of a GET request, but without the response body. It's useful for retrieving metadata.

Example:
```bash
HEAD /api/users/123
```

## OPTIONS
The OPTIONS method is used to describe the communication options for the target resource.

Example:
```bash
OPTIONS /api/users
```

## Getting Started
Follow these steps to get started with the project:
1. Clone the repository.
2. Install Docker and Docker Compose if not already installed.
3. Run docker-compose up to start the MongoDB container.
4. Run the Spring Boot application.
5. Use tools like Postman or curl to interact with the API using the defined HTTP verbs.