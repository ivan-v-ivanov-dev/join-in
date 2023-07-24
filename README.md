# Join-IN

This repository is **under development**.

# Content

**1. General overview**   
**2. How to start the project**    
**3. Microvervice communication**    
**4. Microservice description**    
**5. Page layout**  
**6. Disclaimer**

# 1. General overview

In this repository, I designed a social media platform with a microservice architecture. Each service is created as an individual module (a standalone Spring Boot application) with its own database (see the **docker-compose.yml** file for each module). Microservices communicate synchronously (Feign client) and asynchronously (using Kafka messages).   

**Note**   
Keep in mind that I use MVC controllers, which means that I always need to generate a View. As the "main" service that generates the Views (the html pages) I designed the Profile service. The MVC approach complicates microservice communication even further. When I design a React frontend for example, some of the microservice communication will be replaced with HTTP requests from the frontend towards the backend. All other services have REST controllers.     

# 2. How to start the project

Git clone the repository and start on first place the **docker-compose.yml** file in each service - it contains the database (as official docker image) and database UI tool for each service. In all services (excluding Relatinship and Reaction services) the sample data will be imported automatiocally, since I am using docker volumes (see **Microservice description** for more details).    
As a second step start each service individually since each service is a single standalone Spring Boot application.     
The **Join IN** application runs on **http://localhost:8080/**

**Note**   
In order to start the project you need to have Docker Desktop installed on your machine.  

# 3. Microvervice communication

## 3.1. Login and Register new user

![image](https://github.com/ivanovbiol/join-in/assets/51414119/e8822fac-d29e-469a-bfef-89e145cb73c4)

1. When the user signs up, a POST Feign request is sent to the Authentication service with the user credentials   
2. When new user is registered Kafka Message is sent to Authentication service to add the new user credentials
3. New User message is send from Authentication to Relashionship service to create new Node for the user
4. New User message is send from Authentication to Reaction service to create new Node for the user
5. New User message is send from Authentication to Notification service to create new collection for the user
6. New User message is send from Authentication to Message service to create new collection for the user
7. New User message is send from Authentication to Image service to create new collection for the user
8. New User message is send from Authentication to Post service to create new collection for the user

## 3.2. Post and edit a Publication / Comment

![image](https://github.com/ivanovbiol/join-in/assets/51414119/95e3ead0-103a-42d9-9ff2-023882efb087)

1. When new publication/comment is posted or updated new Kafka message is send from Profile to Post service
2. Post service retrieves all frinds for the user from Relationship service
3. Post sends Kafka message notifications to the Notification service for all friends of the user that new publication/comment is created/edited

## 3.3. React to Post(publication) / Comment

![image](https://github.com/ivanovbiol/join-in/assets/51414119/78c9670a-94d4-47ca-b78a-68bb9917fc7c)

1. Profile service sends Kafka message to Reaction service for the Post/Comment reaction
2. Reaction service retrieves all friends of the user whose post/comment has been reacted
3. Reaction service sends notifications via Kafka messaging to Notification service that someone reacted to the post/comment

## 3.4. Generate User profile page

![image](https://github.com/ivanovbiol/join-in/assets/51414119/202f9a0d-0f9f-44a5-bb96-11091e288d15)

1. Profile retrieves user image, background image and album images from Image service
2. Profile retrieves user posts from Post service
3. Post service retrieves user profile photo from Image service for each user post
4. Post retrieves all reactions (likes, dislikes, stars) for each post from Reactions service
5. Profile retrieves all friends form Relationship service
6. Relationship service retrieves friends profile images from Image service
7. Profile retrieves all notification for the user form Notification service
8. Notofocations service retrieves profile image for each notification form Image service
9. Profile retrieves all chat messages from Message service
10. Message service retrieves user profile images for each chat message from Image service

# 4. Microservice description   

## 4.1 Kafka service     

Runs on **http://localhost:8089/**. The service contains all Kafka message models and is imported in other services as **Maven dependency**. 

### Technical overview   

 - **Spring Boot 2.5** and and **Java 17** used
 - **Maven** used as a a software project management and comprehension tool
 - **Kafka** as official docker image runnig on port **9092** (see **kafka/docker-compose.yml**)
 - **Zookeeper** as official docker image, running on port **2181** 

## 4.2. Authentication service

Runs on **http://localhost:8081/**. The service perform user authentication towards database credentials (email and password) stored as BCryptPasswordEncoded values in the database. Also service registeres new users and sends Kafka messages for the new user to other services.   

### Technical overview   

 - **Spring Boot 2.5** and and **Java 17** used
 - **Maven** used as a a software project management and comprehension tool
 - **MySQL** as official docker image running on port **3306** (see **authentication/docker-compose.yml**)
 - **Flyway** as official docker image to create tables, relations and import sample data on start up (see **resources/flyway/V1__Initial.sql** - file name convention is mandatory!)
 - **Spring Data JPA** as persistent strategy   

## 4.3. Post service  

Runs on **http://localhost:8082/**. Service stores Post (publications) and comments. The posts are stored in MongoDB collections (each user has it's own collection created when user is registered). The comment are stored in Redis hashmap with Post identity as Key and Comment as value. Post and comment identity used as @RequestParams in microservice communications are calculated as SHA-512 values of Post/Comment owner + content + posted date.   

**Note**     
It is debatable whether I should use Mongo relations to store comments or Neo4j as a database to store Posts and Comments. However I decided to user MongoDB for the posts and Redis for the comments for now (I might change the implementation in the future).

### Technical overview   

 - **Spring Boot 2.5** and and **Java 17** used
 - **Maven** used as a a software project management and comprehension tool
 - **MongoDB** as official docker image runnig on port **27020** (see **post/docker-compose.yml**). Collection and sample data are imported on start up via docker volume and **.js** script (see **resources/mongo/ini.js**)
 - **Mongo express** as official docker image running on port **9091** as database UI tool
 - **Redis** as official docker image runnign on port **6379**. Sample data are imported on start up via **CommandLineRunner** (see **config/RedisConfig.java**)
 - **MongoTemplate** used as persistent strategy for the MongoDB persistence
 - **RedisTemplate** used as persistent strategy for the Redis persistence 

## 4.4. Image service   

Runs on **http://localhost:8085/**. Service stores user images (profile photo, background photos and album photos /each user has only one album with maximum of 9 photos/). Each user has it's own collection created when new user is registered. Photos are stored as Base64 encoded strings.  

### Technical overview     

 - **Spring Boot 2.5** and and **Java 17** used
 - **Maven** used as a a software project management and comprehension tool
 - **MongoDB** as official docker image runnig on port **27018** (see **image/docker-compose.yml**). Collection and sample data are imported on start up via docker volume and **.js** script (see **resources/mongo/ini.js**)
 - **Mongo express** as official docker image running on port **9093** as database UI tool
 - **MongoTemplate** used as persistent strategy for the MongoDB persistence

## 4.5. Reaction service  

Runs on **http://localhost:8084/**. Stores posts reactions (likes, dislikes and stars) and comment reactions (likes, dislikes). Uses Neo4j as a database.

### Technical overview     

 - **Spring Boot 2.5** and and **Java 17** used
 - **Maven** used as a a software project management and comprehension tool
 - **Neo4j** as official docker image running on port **7688** and Neo4j browser running on port **7475** (see **reaction/docker-compose.yml**). In order to create nodes and import sample data after container initialisation, please take the content of **import.cypher** (**resources/neo4j/import.cypher**) and paste it in the Neo4j browser (**http://localhost:7475/browser/**)
 - **Spring Data JPA (Neo4jRepository)** with native queries used as persistence strategy

## 4.6. Relashionship service  

Runs on **http://localhost:8083/**. Stores friendship relations for the users. Uses Neo4j as a database.

### Technical overview     

 - **Spring Boot 2.5** and and **Java 17** used
 - **Maven** used as a a software project management and comprehension tool
 - **Neo4j** as official docker image running on port **7687** and Neo4j browser running on port **7474** (see **relationship/docker-compose.yml**). In order to create nodes and import sample data after container initialisation, please take the content of **import.cypher** (**resources/neo4j/import.cypher**) and paste it in the Neo4j browser (**http://localhost:7474/browser/**)
 - **Spring Data JPA (Neo4jRepository)** with native queries used as persistence strategy 

## 4.7. Profile service  

Runs on **http://localhost:8080/**. Stores profie information for users. Contains the MVC controllers for the Views.

### Technical overview     

 - **Spring Boot 2.5** and and **Java 17** used
 - **Maven** used as a a software project management and comprehension tool
 - **Spring MVC framework** used to create the controllers and connect to the frontend
 - **Thymeleaf** used as a template engine to create and populate the html pages
 - **MongoDB** as official docker image runnig on port **27017** (see **profile/docker-compose.yml**). Collection and sample data are imported on start up via docker volume and **.js** script (see **resources/mongo/ini.js**)
 - **Mongo express** as official docker image running on port **9090** as database UI tool

# 5. Page layout  

## 5.1. Profile page

![image](https://github.com/ivanovbiol/join-in/assets/51414119/7776f18b-6fa1-4104-9be4-b00920d106c9)

# 6. Disclaimer  

This is personal coding skills training project. NO real software products are distrubuted. NO real personal identities/information/profiles/names/photos are distrubuted/collected - the data/identities are non-realistic. Official Docker images are used for the technologies. Paid bootstrap theme was used for the frontend view (for styled HTML sources). Sample images obtained from https://pixabay.com/bg/.
