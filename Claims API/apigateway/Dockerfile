FROM openjdk:11
VOLUME /tmp
ADD target/apigateway-0.0.1-SNAPSHOT.jar gatewaydocker.jar
ENTRYPOINT ["java", "-jar", "/gatewaydocker.jar"]