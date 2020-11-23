FROM adoptopenjdk/openjdk11:jdk-11.0.6_10-alpine-slim
COPY ./target/dclub-0.0.1-SNAPSHOT.jar /usr/src/app/
WORKDIR /usr/src/app
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "dclub-0.0.1-SNAPSHOT.jar"]


