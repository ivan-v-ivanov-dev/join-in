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
        authorIdentity: "1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032",
        content: "Hey, has anyone done a microservice project?",
        comments: [
            {
                commentIdentity: "d0b214d649e2abb2259a1d8dc6c79f877dc2e3f04684f47c22674b5d63c752949e36cd588d733d047f714a2395fb310a68893d635ea00839bf849cf652c4dcdd",
                authorIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
                content: "That is cool, I've done such a thing.",
                postDate: "2021-01-23"
            },
             {
                commentIdentity: "7f608f8b9cd3b674fa4549792a26ecef4b9ce3635ed9b5fb1643e29ff47d09f52ec6cfc0b2846cb06f605c15c7daf108c88b2ae41a4e163283980da54142b417",
                authorIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
                content: "Yes, I've done it.",
                postDate: "2021-01-23"
             }
        ],
        postDate: "2021-01-23"
    },
    {
        postIdentity: "cc66a46cad4b32f69a840a0aa29aeb30d6c014c1f09cdd9de446d7da4fcce1c5d97303c201d77a21b8f35ec67c081dd5dd01fe4637782aff360b0b968ad07e97",
        authorIdentity: "1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032",
        content: "Let's talk about the implementation of the microservice architecture.",
        comments:
        [
                {
                    commentIdentity: "d0b214d649e2abb2259a1d8dc6c79f877dc2e3f04684f47c22674b5d63c752949e36cd588d733d047f714a2395fb310a68893d635ea00839bf849cf652c4dcdd",
                    authorIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
                    content: "OK, ping me in private message.",
                    postDate: "2021-01-23"
                },
                {
                   commentIdentity: "7f608f8b9cd3b674fa4549792a26ecef4b9ce3635ed9b5fb1643e29ff47d09f52ec6cfc0b2846cb06f605c15c7daf108c88b2ae41a4e163283980da54142b417",
                   authorIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
                   content: "For the microservices you can use Kafka as message broker.",
                   postDate: "2021-01-23"
                }
        ],
        postDate: "2023-07-09"
    }
]);
console.log('*** Data Imported ***')

