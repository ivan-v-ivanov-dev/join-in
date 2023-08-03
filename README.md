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
Keep in mind that I use MVC controllers, which means that I always need to generate a View. As the "main" service that generates the Views (the html pages) I designed the Profile service. All other services have REST controllers. 
The MVC approach complicates the microservice communication even further. A React frontend, for example, would simplify some of the microservice communication - some of the Kafka messaging from Profile to other services would be replaced with HTTP requests from the frontend towards the backend.        

# 2. How to start the project

 - Git clone the repository and on first place start the **docker-compose.yml** file in each service - it contains the database (as official docker image) and database UI tool for each service. In all services (excluding Relationship and Reaction services) the sample data will be imported automatically, since I am using docker volumes (see **Microservice description** for more details).    
 - As a second step, start each service individually since each service is a standalone Spring Boot application.     
 - The **Join IN** application runs on **http://localhost:8080/**

**User login credentials**  
email:    ```petur@petur.com```    
password: ```petur@petur.com```     

**Note**   
In order to start the project you need to have Docker Desktop installed on your machine. Also, the Flyway container in Authentication service starts, creates the tables and imports the data into the MySQL container then shuts down, which is normal behavior. Despite the fact that Flyway depends on MySQL, keep an eye on it and restart it manually if needed.

![image](https://github.com/ivanovbiol/join-in/assets/51414119/c138f481-c8cb-4455-9aad-1f61ebce17c9)

# 3. Microvervice communication

## 3.1. Login and Register new user

![image](https://github.com/ivanovbiol/join-in/assets/51414119/e8822fac-d29e-469a-bfef-89e145cb73c4)

1. When the user signs up, a POST Feign request is sent to the Authentication service with the user credentials   
2. When a new user is registered, a Kafka Message is sent to Authentication service to add the new user's credentials
3. New User message is sent from Authentication to Relashionship service to create a new Node for the user
4. New User message is sent from Authentication to Reaction service to create a new Node for the user
5. New User message is sent from Authentication to Notification service to create a new collection for the user
6. New User message is sent from Authentication to Message service to create a new collection for the user
7. New User message is sent from Authentication to Image service to create a new collection for the user
8. New User message is sent from Authentication to Post service to create a new collection for the user

## 3.2. Post a Publication

![image](https://github.com/ivanovbiol/join-in/assets/51414119/cc43ef20-a7c9-400d-a6f9-d08fc7447e27)

1. When a new publication is posted or edited, a new Kafka message is sent from the Profile to Post service 
2. Post service retrieves all friends for the user from Relationship service (when a post is edited or deleted, this communication is not performed)
3. Post sends a Kafka message to Reaction service to create a new node for the new post (when a post is edited or deleted, this communication is not performed)
4. Post sends Kafka message notifications to Notification service for all friends of the user that new publication is created (when a post is edited or deleted, this communication is not performed)

## 3.4. Post a Comment on a publication

![image](https://github.com/ivanovbiol/join-in/assets/51414119/974a8dab-9b8a-4658-a103-54a910b244ea)

1. When a new comment is posted or edited, a new Kafka message is sent from the Profile to Post service 
2. Post service retrieves people who have already reacted to the post from Reaction service. Also Post service retrieves all users who commented on the publication already from Post service itself (not shown in the picture) (when a comment is edited, these communications are not performed). 
3. Post sends a Kafka message to the Reaction service to create a new node for the new comment (when a comment is edited, this communication is not performed)
4. Post sends Kafka message notifications to Notification service to all users related to the publication that new comment is posted (when comment is edited this communication is not performed)

## 3.5. Delete a Post

![image](https://github.com/ivanovbiol/join-in/assets/51414119/d5a297c4-4f5f-4d54-82f7-acf62a0844fe)

1. When a post is deleted new Kafka message is sent from the Profile to Post service
2. Post sends a Kafka message to Reaction to delete the nodes for the post and all its comments

## 3.6. React to Post

![image](https://github.com/ivanovbiol/join-in/assets/51414119/9b7fd9c7-e1fa-45ee-b58d-3c64cd0b2e2e)

1. Profile service sends Kafka message to Reaction service for the Post reaction
2. Reaction service retrieves all users who commented the post to sends them notification about the reaction
3. Reaction service sends notifications via Kafka messaging to Notification service that someone reacted to the post (notifications are send to those users who reacted previously to the post /obtained from Reaction service/ or has commented the post /obtained from Post service/)

## 3.7 View and Edit a post

![image](https://github.com/ivanovbiol/join-in/assets/51414119/f93b64e3-b708-46c0-af1e-cfb83d29684a)

1. Profile service retrieves Post from post service
2. Post service retrieves user profile picture from Image service
3. When post is edited new Kafka message is sent from Profile to Post service

## 3.8. Generate User profile page

![image](https://github.com/ivanovbiol/join-in/assets/51414119/202f9a0d-0f9f-44a5-bb96-11091e288d15)

1. Profile retrieves user image, background image and album images from Image service
2. Profile retrieves user posts from Post service
3. Post service retrieves user profile photo from Image service for each user post
4. Post retrieves all reactions (likes, dislikes, stars) for each post from Reactions service
5. Profile retrieves all friends and friendship requests form Relationship service
6. Relationship service retrieves friends and friendship requests profile images from Image service
7. Profile retrieves all notification for the user form Notification service
8. Notofocations service retrieves profile image for each notification form Image service
9. Profile retrieves all chat messages from Message service
10. Message service retrieves user profile images for each chat message from Image service

## 3.9. Accept / Decline / Send Friendship request

![image](https://github.com/ivanovbiol/join-in/assets/51414119/f6ac374e-f00f-4272-b3b8-f8ca4edfbca2)

1. Profile service sends Kafka messaging to Relationship service the friendship request or to accept or decline it

# 4. Microservice description   

## 4.1 Kafka service     

Runs on **http://localhost:8089/**. The service contains all Kafka message models and is imported in other services as **Maven dependency**. 

### Technical overview   

 - **Spring Boot 2.5** and and **Java 17** used
 - **Maven** used as a software project management and comprehension tool
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

Runs on **http://localhost:8082/**. Service stores Post (publications) and comments. The posts are stored in MongoDB collections (each user has its own collection created when the user is registered). The comments are stored in the Posts (as embedded mongo relations). Post and comment identities used as @RequestParams in microservice communications are calculated as SHA-512 values of Post/Comment owner + content + posted date.   

**Note**     
It is debatable whether I should use MongoDB with relations relations or Neo4j as a database to store Posts and Comments. However I decided to user MongoDB (I might change the implementation in the future).

### Technical overview   

 - **Spring Boot 2.5** and and **Java 17** used
 - **Maven** used as a a software project management and comprehension tool
 - **MongoDB** as official docker image runnig on port **27020** (see **post/docker-compose.yml**). Collection and sample data are imported on start up via docker volume and **.js** script (see **resources/mongo/init.js**)
 - **Mongo express** as official docker image running on port **9091** as database UI tool
 - **MongoTemplate** used as persistent strategy for the MongoDB persistence   

## 4.4. Image service   

Runs on **http://localhost:8085/**. Service stores user images (profile photo, background photos and album photos /each user has only one album with maximum of 9 photos/). Each user has it's own collection created when new user is registered. Photos are stored as Base64 encoded strings.  

### Technical overview     

 - **Spring Boot 2.5** and and **Java 17** used
 - **Maven** used as a a software project management and comprehension tool
 - **MongoDB** as official docker image runnig on port **27018** (see **image/docker-compose.yml**). Collection and sample data are imported on start up via docker volume and **.js** script (see **resources/mongo/init.js**)
 - **Mongo express** as official docker image running on port **9093** as database UI tool
 - **MongoTemplate** used as persistent strategy for the MongoDB persistence

## 4.5. Reaction service  

Runs on **http://localhost:8084/**. Stores posts reactions (LIKE, DISLIKE and STAR) and comment reactions (LIKE and DISLIKE). Uses Neo4j as a database. Posts, comments and users are created as nodes (with identity as Id) and Users has a relationship to the posts and comments.

Example of Users (purple nodes), Posts (orange nodes) and Comments (blue nodes)

![image](https://github.com/ivanovbiol/join-in/assets/51414119/16b51e68-7bb5-48e0-8f6b-71fcc835925f)

### Technical overview     

 - **Spring Boot 2.5** and and **Java 17** used
 - **Maven** used as a a software project management and comprehension tool
 - **Neo4j** as official docker image running on port **7688** and Neo4j browser running on port **7475** (see **reaction/docker-compose.yml**). In order to create nodes and import sample data after container initialisation, please take the content of **import.cypher** (**resources/neo4j/import.cypher**) and paste it in the Neo4j browser (**http://localhost:7475/browser/**)
 - **Spring Data JPA (Neo4jRepository)** with native queries used as persistence strategy

## 4.6. Relashionship service  

Runs on **http://localhost:8083/**. Stores friendship relations for the users and friend invitations.  Uses Neo4j as a database. The FRIENDSHIP relationships are outgoing for each user. The FRIENDSHIP_REQUEST relationship are outgoing from the user who sends the invitation to another who accepts it. After accepting the frienship this relation is replaced with FRINEDSHIP. The service can be extended to support other relationships (FOLLOWS, for example).

Example

![image](https://github.com/ivanovbiol/join-in/assets/51414119/d3e76a18-88c8-4680-b34b-9f998b937ed5)

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
 - **MongoDB** as official docker image runnig on port **27017** (see **profile/docker-compose.yml**). Collection and sample data are imported on start up via docker volume and **.js** script (see **resources/mongo/init.js**)
 - **Mongo express** as official docker image running on port **9090** as database UI tool

## 4.8. Notification service

Runs on **http://localhost:8086/**. Stores the notificatins for each user. Each user has its own collection.

 - **Spring Boot 2.5** and and **Java 17** used
 - **Maven** used as a software project management and comprehension tool
 - **MongoDB** as official docker image runnig on port **27019** (see **notification/docker-compose.yml**). Collection and sample data are imported on start up via docker volume and **.js** script (see **resources/mongo/init.js**)
 - **Mongo express** as official docker image running on port **9094** as database UI tool
 - **MongoTemplate** used as persistent strategy for the MongoDB persistence


# 5. Pages layouts  

## 5.1. Sign in

![image](https://github.com/ivanovbiol/join-in/assets/51414119/e6701756-0b40-45ec-8464-b764e72c5ce8)

## 5.2. Sign up

![image](https://github.com/ivanovbiol/join-in/assets/51414119/e677e9bb-2a32-48d9-b9de-55ffbb6a63d1)

## 5.3. User Profile

![image](https://github.com/ivanovbiol/join-in/assets/51414119/7776f18b-6fa1-4104-9be4-b00920d106c9)

## 5.4. Friendship requests

![image](https://github.com/ivanovbiol/join-in/assets/51414119/2bea4a4b-1be6-4c50-af37-d9904e0117cf)

## 5.5. Notifications

![image](https://github.com/ivanovbiol/join-in/assets/51414119/9398fc94-a318-4139-b6f7-88a9bcf487b6)

![image](https://github.com/ivanovbiol/join-in/assets/51414119/2932ea88-998b-41f0-9e59-6f70a1df025e)

## 5.6. Edit profile

![image](https://github.com/ivanovbiol/join-in/assets/51414119/920ba7fc-13ad-4bf8-bc56-31650999a75b)

# 6. Disclaimer  

This is personal coding skills training project. NO real software products are distrubuted. NO real personal identities/information/profiles/names/photos are distrubuted/collected - the data/identities are non-realistic. Official Docker images are used for the technologies. Paid bootstrap theme was used for the frontend view (for styled HTML sources). Sample images obtained from https://pixabay.com/bg/.
