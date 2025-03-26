FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/easy-0.0.1-SNAPSHOT.jar easy-0.0.1-SNAPSHOT.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "/app/easy-0.0.1-SNAPSHOT.jar"]