FROM openjdk:17

WORKDIR /usuariosms

ENV CONFIG_SERVER="" \
    PROFILE=""

COPY /target/usuarios-ms-0.0.1-SNAPSHOT.jar .

CMD java -DCONFIG_SERVER=$CONFIG_SERVER -DPROFILE=$PROFILE -jar usuarios-ms-0.0.1-SNAPSHOT.jar