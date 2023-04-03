FROM openjdk:18

WORKDIR /app

COPY ./target/trafficAnalyzeService-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "trafficAnalyzeService-0.0.1-SNAPSHOT.jar"]