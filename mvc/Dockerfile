ARG BUILD_HOME=/app

FROM maven:3.9.6-eclipse-temurin-21 AS build_process

ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME

WORKDIR $APP_HOME

COPY pom.xml .
COPY src ./src

RUN --mount=type=secret,id=maven_settings,target=/root/.m2/settings.xml,required=true \
    mvn --settings /root/.m2/settings.xml clean package

FROM eclipse-temurin:21-jre

COPY --from=build_process /app/target/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]