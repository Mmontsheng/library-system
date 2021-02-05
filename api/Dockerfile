FROM maven:3.6-amazoncorretto-11 as builder
WORKDIR /src
COPY . /src
RUN mvn clean package

FROM amazoncorretto:11 
LABEL maintainer="mmontshengmaoto@gmail.com"

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY --from=builder /src/${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]