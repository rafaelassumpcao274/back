FROM maven as build

RUN mkdir home/app
COPY ./ .
RUN mvn clean package





######## build back
FROM openjdk:19-jdk-slim

#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar

COPY --from=build /target/*.jar app.jar

RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev./urandom","-jar","/app.jar"]