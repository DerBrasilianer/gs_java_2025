# Stage 1: build com JDK 21
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN ./mvnw clean install -DskipTests || mvn clean install -DskipTests

# Stage 2: runtime com JDK 21 slim
FROM eclipse-temurin:21-jdk-jammy

EXPOSE 8080
WORKDIR /app
COPY --from=build /app/target/gloal_solution-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
