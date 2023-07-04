use ("admin");
db.auth("rootuser", "rootpass");
console.log('*** Authentication with root user ***')

use ("storage");
db.createCollection("posts");
console.log('*** Collection created ***')

db.posts.insertMany([
    {
        authorIdentity: "authorIdentity",
        postIdentity: "postIdentity11",
        content: "content",
        postDate: null
    },
    {
        authorIdentity: "authorIdentity",
        postIdentity: "postIdentity22",
        content: "content",
        postDate: null
    }
]);
console.log('*** Data Imported ***')

