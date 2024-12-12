# Usamos una imagen base de OpenJDK 11
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/shopper-franchise-api-0.0.1-SNAPSHOT.jar shopper-franchise-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "shopper-franchise-api.jar"]
