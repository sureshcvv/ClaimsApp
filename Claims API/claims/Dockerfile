FROM maven:3.6.0-jdk-11-slim AS build


# Copy folder in docker
WORKDIR ./target/claims-0.0.1-SNAPSHOT.jar

COPY ./ /opt/app
RUN mvn clean install -DskipTests


# Run spring boot in Docker
FROM openjdk:11-alpine

COPY --from=build /opt/app/target/*.jar app.jar

ENV PORT 9100
EXPOSE $PORT

ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","app.jar"]
