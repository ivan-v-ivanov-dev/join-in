use ("admin");
db.auth("rootuser", "rootpass");
console.log('*** Authentication with root user ***')

use ("storage");

db.createCollection("c_1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032");
console.log('*** Collection created ***')

db.c_1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032.insertMany([
    {
        authorIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        postIdentity: "cc66a46cad4b32f69a840a0aa29aeb30d6c014c1f09cdd9de446d7da4fcce1c5d97303c201d77a21b8f35ec67c081dd5dd01fe4637782aff360b0b968ad07e97",
        notification: "Georgi Tihomirov wrote a new comment",
        date: "2023-07-23",
        seen: false
    },
    {
        authorIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        postIdentity: "cc66a46cad4b32f69a840a0aa29aeb30d6c014c1f09cdd9de446d7da4fcce1c5d97303c201d77a21b8f35ec67c081dd5dd01fe4637782aff360b0b968ad07e97",
        notification: "Stoyan Dimitrov wrote a new comment",
        date: "2023-07-20",
        seen: false
    },
    {
        authorIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        postIdentity: "cc66a46cad4b32f69a840a0aa29aeb30d6c014c1f09cdd9de446d7da4fcce1c5d97303c201d77a21b8f35ec67c081dd5dd01fe4637782aff360b0b968ad07e97",
        notification: "Georgi Tihomirov likes a post",
        date: "2023-07-20",
        seen: false
    },
    {
        authorIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        postIdentity: "cc66a46cad4b32f69a840a0aa29aeb30d6c014c1f09cdd9de446d7da4fcce1c5d97303c201d77a21b8f35ec67c081dd5dd01fe4637782aff360b0b968ad07e97",
        notification: "Viktoriya Ivanova dislikes a post",
        date: "2023-07-25",
        seen: false
    },
    {
        authorIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        postIdentity: "cc66a46cad4b32f69a840a0aa29aeb30d6c014c1f09cdd9de446d7da4fcce1c5d97303c201d77a21b8f35ec67c081dd5dd01fe4637782aff360b0b968ad07e97",
        notification: "Stoyan Dimitrov stars a post",
        date: "2023-07-30",
        seen: false
    }
]);

console.log('*** Data Imported ***')

