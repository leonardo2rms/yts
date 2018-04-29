#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#ADD ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
FROM openjdk:8
ADD target/yts-movies.jar yts-movies.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "yts-movies.jar"]