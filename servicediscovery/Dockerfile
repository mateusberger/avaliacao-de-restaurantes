FROM openjdk:17

WORKDIR /springbootadmin

ENV CONFIG_SERVER="" \
    PROFILE=""

EXPOSE 8762

COPY /target/servicediscovery-0.0.1-SNAPSHOT.jar .

CMD java -DCONFIG_SERVER=$CONFIG_SERVER -DPROFILE=$PROFILE -jar servicediscovery-0.0.1-SNAPSHOT.jar
