# Stage 1: build com JDK 21 + Maven instalado
FROM eclipse-temurin:21-jdk AS build

# Instala Maven
RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Compila o projeto
RUN mvn clean install -DskipTests

# Stage 2: imagem final mais leve com apenas o JDK 21
FROM eclipse-temurin:21-jdk-jammy

EXPOSE 8080
WORKDIR /app

# Copia o JAR gerado
COPY --from=build /app/target/global_solution-0.0.1-SNAPSHOT.jar app.jar

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
