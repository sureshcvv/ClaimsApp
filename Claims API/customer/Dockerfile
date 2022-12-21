FROM openjdk:11
VOLUME /tmp
ADD target/customer-0.0.1-SNAPSHOT.jar customer-docker.jar
ENTRYPOINT ["java", "-jar", "customer-docker.jar"]