# Stage 1: сборка JAR
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Копируем только pom.xml сначала, чтобы кэшировать зависимости
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем исходники и собираем JAR
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: runtime
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/WeatherTelegramBot.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
