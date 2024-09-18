FROM openjdk:17-jdk-alpine

LABEL maintainer="karthik97nagaraj@gmail.com"

VOLUME /tmp

EXPOSE 8082

ARG JAR_FILE=target/Integrating-Payment-Gateway-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Djasypt.encryptor.password=karthik", "-jar", "/app.jar"]