# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Установка curl для работы Health Check
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

# Первый этап (build) использует тяжелый Maven для сборки .jar файла.
# Второй этап использует легкий openjdk-slim, куда копируется только готовый архив приложения.
# Всё лишнее (исходный код, кэш Maven) выбрасывается.
# В итоге финальный образ весит в 2–3 раза меньше
