cd api
ECHO "===========BUILDING APPLICATION==========="
mvn clean package
ECHO  "===========DONE BUILDING APPLICATION==========="

ECHO  "===========BUILDING DOCKER FILE==========="
docker build -t library-system-api:latest .
ECHO  "===========DONE BUILDING DOCKER FILE==========="

cd ..
ECHO "===========STARTING DOCKER COMPOSE APPLICATION==========="
docker-compose up