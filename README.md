# UserLocation-API
This is a spring boot project developed using Gradle having role based authorisation(using Spring Security)

This microservice has 3 endpoints
1) /create_data == This creates table named user_location if not present. Only user having role of "ADMIN" can execute this request.
2) /update_data == This is use to update, or add new user. Only user having role of "ADMIN" can execute this request.
3) /get_users/N == This is used to get the nearest N users from (0,0);


There are 2 roles: ADMIN, READER.
ADMIN can perform CRUDE operations like POST, DELETE, PATCH, etc.
READER can perform only GET operation.

The table user_location will have three fields NAME, Latitude, and Longitude.

This microservice uses HSQL in-memory database for the database work.
