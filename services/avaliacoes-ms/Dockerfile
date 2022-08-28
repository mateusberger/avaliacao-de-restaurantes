FROM openjdk:17

WORKDIR /avaliacoesms

ENV CONFIG_SERVER_URL="http://configservice:8888"

COPY /target/avaliacoes-ms-0.0.1-SNAPSHOT.jar .

CMD [ "java", "-jar", "avaliacoes-ms-0.0.1-SNAPSHOT.jar" , "-DCONFIG_SERVER_URL="${CONFIG_SERVER_URL}]