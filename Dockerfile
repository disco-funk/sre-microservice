FROM mongo

RUN apt-get update
RUN apt-get -y install wget
RUN wget http://media.mongodb.org/zips.json
RUN mongod --fork --logpath /var/log/mongod.log
RUN until pids=$(pidof mongod); do ps -Af; sleep 1;  done
RUN mongoimport -v --file=zips.json

