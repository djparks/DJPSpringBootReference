FROM openjdk:17-alpine3.14

COPY target/todo-service-0.0.1-SNAPSHOT.jar app.jar

#CMD ["java","-jar","/app.jar"]