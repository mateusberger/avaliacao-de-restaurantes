FROM openjdk:17

WORKDIR /usuariosms

ENV CONFIG_SERVER_URL="http://configservice:8888"

COPY /target/usuarios-ms-0.0.1-SNAPSHOT.jar .

CMD [ "java", "-jar", "usuarios-ms-0.0.1-SNAPSHOT.jar" , "-DCONFIG_SERVER_URL="${CONFIG_SERVER_URL}]