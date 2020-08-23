FROM adoptopenjdk/openjdk11
COPY target/licence-app*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]