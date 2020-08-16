All commands should be executed from project's root directory

To run test execute:
mvnw clean test

to start server execute:
mvnw spring-boot:run 

Example requests:
GET http://localhost:8080/match/10
GET http://localhost:8080/match/10?summaryType=AvB
GET http://localhost:8080/match/10?summaryType=AvBTime

GET http://localhost:8080/match/20
GET http://localhost:8080/match/20?summaryType=AvB
GET http://localhost:8080/match/20?summaryType=AvBTime

To make it as simple as possible I didn't implement different response/status code when user does not exist.
When use has 0 subscription or does not exist I return empty response with 200.

Example data is specified in data.sql in both src and test folders to play with app and add tests.