FROM openjdk:8-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} learning-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "learning-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080

