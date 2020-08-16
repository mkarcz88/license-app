All commands should be executed from project's root directory

To run test execute:
mvnw clean test

to start server execute:
mvnw spring-boot:run 

Example requests:
GET http://localhost:8080/match/10?summaryType=AvB
GET http://localhost:8080/match/10?summaryType=AvBTime

GET http://localhost:8080/match/20?summaryType=AvB
GET http://localhost:8080/match/20?summaryType=AvBTime