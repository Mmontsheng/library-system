FROM maven:3.6-amazoncorretto-11 as target
WORKDIR /src
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src /builder/src

RUN mvn package

FROM amazoncorretto:11 
LABEL maintainer="mmontshengmaoto@gmail.com"

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY --from=target /build/src/${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]