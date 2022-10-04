FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/alticci-sequence-0.0.1-SNAPSHOT.jar /app/alticci-sequence-api.jar

EXPOSE 8080

CMD ["java", "-jar", "alticci-sequence-api.jar"]