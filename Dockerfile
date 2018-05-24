FROM alpine

COPY build/libs/sre-microservice-0.0.1-SNAPSHOT.jar sre-microservice-0.0.1-SNAPSHOT.jar
ENV PATH $PATH:/opt/gradle/gradle-4.7/bin
RUN apk update && \
    apk add openjdk8
EXPOSE 8080
ENTRYPOINT java -jar sre-microservice-0.0.1-SNAPSHOT.jar