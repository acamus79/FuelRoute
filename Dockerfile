FROM openjdk:17-alpine
LABEL authors="acamus"
VOLUME /tmp
ARG JAR_FILE=/fuelRoute/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"
