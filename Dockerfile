FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y openjdk-17-jdk maven

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim

EXPOSE 8080

WORKDIR /app

COPY --from=build /app/target/gloal_solution-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
