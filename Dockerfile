FROM alpine

ARG RELEASE_VERSION
ENV RELEASE_VERSION ${RELEASE_VERSION}
LABEL release_version=${RELEASE_VERSION}
COPY ./build/libs/sre-microservice-$RELEASE_VERSION.jar sre-microservice-$RELEASE_VERSION.jar
RUN apk update && \
    apk add openjdk8
EXPOSE 8080
ENTRYPOINT java -jar sre-microservice-$RELEASE_VERSION.jar $RELEASE_VERSION
