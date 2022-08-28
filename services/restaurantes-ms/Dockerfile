FROM openjdk:17

WORKDIR /restaurantesms

ENV CONFIG_SERVER_URL="http://configservice:8888"

COPY /target/restaurantes-ms-0.0.1-SNAPSHOT.jar .

CMD [ "java", "-jar", "restaurantes-ms-0.0.1-SNAPSHOT.jar" , "-DCONFIG_SERVER_URL="${CONFIG_SERVER_URL}]