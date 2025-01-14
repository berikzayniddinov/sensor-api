# Базовый образ с Java 17
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR-файл из сборки Gradle
COPY build/libs/sensor-api-0.0.1-SNAPSHOT.jar app.jar

# Открываем порт 8080
EXPOSE 8080

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
