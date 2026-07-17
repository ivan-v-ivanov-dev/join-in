use ("admin");
db.auth("rootuser", "rootpass");
console.log('*** Authentication with root user ***')

use ("storage");
db.createCollection("429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b");
db.createCollection("9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91");
db.createCollection("771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551");
console.log('*** Collections created ***')