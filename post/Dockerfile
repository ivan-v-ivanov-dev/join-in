FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN --mount=type=secret,id=maven_settings,target=/root/.m2/settings.xml \
    --mount=type=cache,target=/root/.m2/repository \
    rm -rf /root/.m2/repository/com/joinin/kafka-models && \
    rm -rf /root/.m2/repository/com/joinin/common-models && \
    mvn --batch-mode --update-snapshots clean package -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar application.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "application.jar"]