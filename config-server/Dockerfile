FROM openjdk:17

WORKDIR /configservice

ARG PORT_BUILD=8888

ENV PORT=${PORT_BUILD}, \
    CONFIG_REPOSITORY="https://github.com/mateusberger/avaliacao-de-restaurantes-configs.git"

EXPOSE ${PORT_BUILD}

COPY /target/config-server-0.0.1-SNAPSHOT.jar .

CMD [ "java", "-jar", "config-server-0.0.1-SNAPSHOT.jar" , "--server.port="${PORT}]