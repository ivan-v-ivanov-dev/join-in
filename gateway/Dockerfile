FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN --mount=type=secret,id=maven_settings,target=/root/.m2/settings.xml,required=true \
    --mount=type=cache,id=maven-repository,target=/root/.m2/repository \
    rm -rf \
        /root/.m2/repository/com/joinin/kafka-models \
        /root/.m2/repository/com/joinin/common-models && \
    mvn --settings /root/.m2/settings.xml \
        --batch-mode \
        --update-snapshots \
        clean package \
        -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar application.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "application.jar"]