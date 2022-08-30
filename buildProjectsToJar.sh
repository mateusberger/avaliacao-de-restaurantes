#!/bin/sh
echo "COMPILANDO AVALIAÇÕES DE RESTAURANTES"

echo "Compilando ApiGateway"
cd ./apigateway
./mvnw clean package
cd ..

echo "Compilando Config-Server"
cd ./config-server
./mvnw clean package
cd ..

echo "Compilando ServiceDiscovery"
cd ./servicediscovery
./mvnw clean package
cd ..

echo "Compilando SpringBoot-Admin"
cd ./springboot-admin
./mvnw clean package
cd ..

echo "Compilando Usuarios-MS"
cd ./services/usuarios-ms
./mvnw clean package
cd ../..

echo "Compilando Restaurantes-MS"
cd ./services/restaurantes-ms
./mvnw clean package
cd ../..

echo "Compilando Avaliacoes-MS"
cd ./services/avaliacoes-ms
./mvnw clean package
cd ../..