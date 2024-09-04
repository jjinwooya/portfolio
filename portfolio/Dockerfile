FROM openjdk:21

LABEL maintainer="jjinwoo1987@naver.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=build/libs/portfolio-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} portfolio-jinwoo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/portfolio-jinwoo.jar"]