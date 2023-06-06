#define base docker image
FROM openjdk:17
LABEL maintainer="subbu.net"
ADD target/volunteer-microservices-0.0.1-SNAPSHOT.jar volunteer-microservices.jar
ENTRYPOINT ["java", "-jar", "volunteer-microservices.jar"]
 