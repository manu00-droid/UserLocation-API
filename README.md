# Spring Boot Microservice with Role-Based Authorization
This is a simple microservice project built using Spring Boot and Gradle with Role-Based Authorization using Spring Security. This project also utilizes an HSQL in-memory database to store data.

The project has three endpoints:

* __/create_data__: This endpoint is used to create a table named **user_location** if it does not already exist. Only users with the **ADMIN** role can execute this request.
* __/update_data__: This endpoint is used to update or add a new user to the **user_location** table. Only users with the **ADMIN** role can execute this request.
* __/get_users/N__: This endpoint is used to get the nearest **N** users from the location (0,0). Any user with either **ADMIN** or **READER** role can execute this request.

## Roles
There are two roles available in this microservice:

* **ADMIN**: This role can perform Create, Read, Update, Delete (CRUD) operations, such as POST, DELETE, PATCH, etc.
* **READER**: This role can only perform GET operations.

## Technologies Used
* Java 8
* Spring Boot
* Gradle
* Spring Security
* HSQL in-memory database

## Setup Instructions
To run this microservice, please follow the instructions below:

1) Clone the repository: ``` git clone https://github.com/manu00-droid/UserLocation-API ```
2) Navigate to the project directory: ``` cd UserLocation-API ```
3) Build the project: ``` ./gradlew build ```
4) Run the project: ``` ./gradlew bootRun ```

## Endpoints
#### Create Data
**POST /create_data**
This endpoint is used to create a table named **user_location** if it does not already exist. Only users with the **ADMIN** role can execute this request.

#### Request Body

None.

#### Response

* __200 OK__: If the table __user_location__ was successfully created.
* __401 Unauthorized__: If the user does not have the __ADMIN__ role.

## Update Data
__POST /update_data__
This endpoint is used to update or add a new user to the __user_location__ table. Only users with the __ADMIN__ role can execute this request.

#### Request Body
```
{
  "name": "User 1",
  "latitude": 41.8781,
  "longitude": -87.6298
}
```

#### Response

* __200 OK__: If the user was successfully updated or added to the __user_location__ table.
* __401 Unauthorized__: If the user does not have the __ADMIN__ role.

### Get Users
__GET /get_users/N__
This endpoint is used to get the nearest **N** users from the location (0,0). Any user with either **ADMIN** or **READER** role can execute this request.

#### Request Parameters

* __N__ (required): The number of nearest users to retrieve.

#### Response
```
[
  {
    "name": "User 1",
    "latitude": 41.8781,
    "longitude": -87.6298
  },
  {
    "name": "User 2",
    "latitude": 42.3601,
    "longitude": -71.0589
  }
]
```
* __200 OK__: If the nearest users were successfully retrieved.
* __400 Bad Request__: If the N parameter is missing or invalid.
* __401 Unauthorized__: If the user does not have either ADMIN or READER role.

## Conclusion
This microservice demonstrates how to implement Role-Based Authorization using Spring Security in a Spring Boot application. The HSQL in-memory database is used to store the user location data, and the microservice provides three endpoints for creating, updating, and retrieving user data.

To run the microservice, you need to clone the repository, build the project using Gradle, and then run the project using the bootRun task.

The README file provides an overview of the project, the available endpoints, and the roles required to execute each request. It also includes instructions for setting up and running the project.

In conclusion, this microservice is a simple example of a Spring Boot application with Role-Based Authorization, utilizing an in-memory database to store data. It serves as a good starting point for developers looking to build similar applications.
