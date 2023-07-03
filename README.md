# join-in

This repository is under development.

In this repository I want to design a social media platform with a microservice architecture. Each service is created as an individual module (standalone Spring Boot application) with its own database (see the docker-cpompose.yml file for each module). Microservices will communicate synchronously (Feign client, for example) and asynchronously (using Kafka messaging).
