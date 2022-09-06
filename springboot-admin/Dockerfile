FROM openjdk:17

WORKDIR /springbootadmin

ENV CONFIG_SERVER="" \
    PROFILE=""

EXPOSE 8171

COPY /target/springboot-admin-0.0.1-SNAPSHOT.jar .

CMD java -DCONFIG_SERVER=$CONFIG_SERVER -DPROFILE=$PROFILE -jar springboot-admin-0.0.1-SNAPSHOT.jar