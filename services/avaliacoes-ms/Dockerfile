FROM openjdk:17

WORKDIR /avaliacoesms

ENV CONFIG_SERVER="" \
    PROFILE=""

COPY /target/avaliacoes-ms-0.0.1-SNAPSHOT.jar .

CMD java -DCONFIG_SERVER=$CONFIG_SERVER -DPROFILE=$PROFILE -jar avaliacoes-ms-0.0.1-SNAPSHOT.jar