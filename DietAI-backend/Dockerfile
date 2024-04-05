FROM eclipse-temurin:18-jre-jammy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

#docker build -t backend:1.0 .
#docker image list
#docker login
#hub.docker.com
#docker tag backend:1.0 jimmysm1995/backend:1.0
#docker push jimmysm1995/backend:1.0