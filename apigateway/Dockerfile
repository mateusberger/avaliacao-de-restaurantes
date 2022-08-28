FROM openjdk:17

WORKDIR /apigateway

ARG PORT_BUILD=8181

ENV PORT=${PORT_BUILD}, \
    CONFIG_SERVER_URL="http://configservice:8888"

EXPOSE ${PORT_BUILD}

COPY /target/apigateway-0.0.1-SNAPSHOT.jar .

CMD [ "java", "-jar", "apigateway-0.0.1-SNAPSHOT.jar" , "--server.port="${PORT}, "-DCONFIG_SERVER_URL="${CONFIG_SERVER_URL}]