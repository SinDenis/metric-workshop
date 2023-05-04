FROM openjdk:17-slim
ADD target/metric-workshop.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
