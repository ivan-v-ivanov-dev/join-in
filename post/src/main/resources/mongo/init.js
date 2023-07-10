use ("admin");
db.auth("rootuser", "rootpass");
console.log('*** Authentication with root user ***')

use ("storage");
db.createCollection("posts");
console.log('*** Collection created ***')

db.posts.insertMany(
[
    {
        authorIdentity: "1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032",
        postIdentity: "postIdentity11",
        content: "content",
        postDate: "2021-01-23"
    },
    {
        authorIdentity: "1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032",
        postIdentity: "postIdentity22",
        content: "content",
        postDate: "2023-07-09"
    }
]);
console.log('*** Data Imported ***')

