FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customer-service.jar
ENTRYPOINT ["java","-jar","/customer-service.jar"]