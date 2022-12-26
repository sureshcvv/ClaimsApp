FROM openjdk:11
EXPOSE 9100
VOLUME /tmp
COPY --from=Claims API/claims/target/claims-0.0.1-SNAPSHOT.jar 
ARG claims-0.0.1-SNAPSHOT.jar claims-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "claims-0.0.1-SNAPSHOT.jar"]
