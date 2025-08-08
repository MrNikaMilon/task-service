FROM eclipse-temurin:21-jdk
WORKDIR /task-service-api
COPY build/libs/task-service-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]