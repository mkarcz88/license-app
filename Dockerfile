FROM adoptopenjdk/openjdk11
COPY target/licence-app*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]