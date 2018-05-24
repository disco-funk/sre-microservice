FROM alpine

COPY buildandstart.sh /tmp/buildandstart.sh
ENV PATH $PATH:/opt/gradle/gradle-4.7/bin
RUN chmod u+x /tmp/buildandstart.sh && \
    mkdir /opt && mkdir /opt/gradle && mkdir /src && \
    apk update && \
    apk add wget unzip openjdk8 git && \
    wget https://services.gradle.org/distributions/gradle-4.7-bin.zip && \
    unzip -d /opt/gradle gradle-4.7-bin.zip && \
    cd /src && \
    git clone https://github.com/disco-funk/sre-microservice.git
EXPOSE 8080
ENTRYPOINT /tmp/buildandstart.sh