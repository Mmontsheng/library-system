#!/bin/sh
cd api
echo "===========BUILDING APPLICATION==========="
mvn clean package
echo  "===========DONE BUILDING APPLICATION==========="

echo  "===========BUILDING DOCKER FILE==========="
docker build -t library-system-api:latest .
echo  "===========DONE BUILDING DOCKER FILE==========="

cd ..
echo "===========STARTING DOCKER COMPOSE APPLICATION==========="
docker-compose up