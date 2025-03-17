# Imagen base de Java 17 (puedes ajustar a la versión que uses)
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado a la imagen
COPY target/miapp.jar app.jar

# Exponer el puerto (opcional, solo informativo)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
