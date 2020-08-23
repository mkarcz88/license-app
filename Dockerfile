FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/licence-app*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]