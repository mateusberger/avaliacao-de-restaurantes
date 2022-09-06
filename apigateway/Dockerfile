FROM openjdk:17

WORKDIR /apigateway

ENV CONFIG_SERVER="" \
    PROFILE=""

EXPOSE 8181    

COPY /target/apigateway-0.0.1-SNAPSHOT.jar .

CMD java -DCONFIG_SERVER=$CONFIG_SERVER -DPROFILE=$PROFILE -jar apigateway-0.0.1-SNAPSHOT.jar