use ("admin");
db.auth("rootuser", "rootpass");
console.log('*** Authentication with root user ***')

use ("storage");
db.createCollection("c_1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032");
console.log('*** Collection created ***')

db.c_1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032.insertMany(
[
    {
        postIdentity: "79cbd7ac103374bc6f9885eed885fec16c8c51d6d2fae9529361323065ab1c0b7e2af2f8e006622a7e321d4e1bf9e38ad0187f75ca35c0b9d8ca4b9e705484d4",
        content: "Hey, has anyone done a microservice project?",
        postDate: "2021-01-23"
    },
    {
        postIdentity: "cc66a46cad4b32f69a840a0aa29aeb30d6c014c1f09cdd9de446d7da4fcce1c5d97303c201d77a21b8f35ec67c081dd5dd01fe4637782aff360b0b968ad07e97",
        content: "Let's talk about the implementation of the microservice architecture.",
        postDate: "2023-07-09"
    }
]);
console.log('*** Data Imported ***')

