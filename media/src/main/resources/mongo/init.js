use("admin");
db.auth("rootuser", "rootpass");
console.log("*** Authentication with root user ***");

use("storage");
db.createCollection("profiles");
db.createCollection("plugins");
db.createCollection("groups");
console.log("*** Collection created ***");