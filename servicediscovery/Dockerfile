FROM openjdk:17

WORKDIR /springbootadmin

ARG PORT_BUILD=8762

ENV PORT=${PORT_BUILD}, \
    CONFIG_SERVER_URL="http://configservice:8888"

EXPOSE ${PORT_BUILD}

COPY /target/servicediscovery-0.0.1-SNAPSHOT.jar .

CMD [ "java", "-jar", "servicediscovery-0.0.1-SNAPSHOT.jar" , "--server.port="${PORT}, "-DCONFIG_SERVER_URL="${CONFIG_SERVER_URL}]