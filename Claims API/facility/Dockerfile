FROM openjdk:11
VOLUME /tmp
ADD target/facility-0.0.1-SNAPSHOT.jar facility-docker.jar
ENTRYPOINT ["java", "-jar", "facility-docker.jar"]