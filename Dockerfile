FROM openjdk:17-jdk-alpine
ENV SPRING_PROFILES_ACTIVE docker
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java",\
        "-Djava.security.egd=file:/dev/./urandom",\
        "-jar",\
        "/app.jar"]