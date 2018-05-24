FROM mongo

RUN rm -f /var/log/mongod.log && \
    apt-get update && \
    apt-get -y install wget && \
    wget http://media.mongodb.org/zips.json

RUN mongod --logpath /var/log/mongod.log --pidfilepath /var/log/pid.txt --fork

# RUN mongoimport -v --file=zips.json
