FROM openjdk:17

WORKDIR /restaurantesms

ENV CONFIG_SERVER="" \
    PROFILE=""

COPY /target/restaurantes-ms-0.0.1-SNAPSHOT.jar .

CMD java -jar restaurantes-ms-0.0.1-SNAPSHOT.jar -DCONFIG_SERVER=$CONFIG_SERVER -DPROFILE=$PROFILE