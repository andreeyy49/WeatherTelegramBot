# Stage 1: сборка JAR
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Копируем только pom.xml для кэширования зависимостей
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем исходники
COPY src ./src

# Сборка JAR без тестов
RUN mvn clean package -DskipTests

# Stage 2: runtime
FROM openjdk:17-jdk-slim
WORKDIR /app

# Копируем собранный JAR из первого этапа
COPY --from=build /app/target/*.jar app.jar

# Указываем порт
EXPOSE 8080

# Запуск приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
