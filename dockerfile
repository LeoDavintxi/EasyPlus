# Imagen base de Java 17 (puedes ajustar a la versión que uses)
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado a la imagen
COPY target/easy-0.0.1-SNAPSHOT.jar easy-0.0.1-SNAPSHOT.jar

# Exponer el puerto (opcional, solo informativo)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "/app/easy-0.0.1-SNAPSHOT.jar"]