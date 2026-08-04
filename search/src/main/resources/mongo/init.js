use("admin");
db.auth("rootuser", "rootpass");
console.log("*** Authentication with root user ***");

use("storage");
db.createCollection("search_history");
console.log("*** Collection created ***");

db.search_history.insertMany([
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        history: [
            {
                keyword: "java",
                searchedAt: ISODate("2026-07-17T10:00:00Z")
            },
            {
                keyword: "ivan",
                searchedAt: ISODate("2026-07-17T10:01:00Z")
            },
            {
                keyword: "microservice",
                searchedAt: ISODate("2026-07-17T10:02:00Z")
            }
        ]
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        history: [
            {
                keyword: "java",
                searchedAt: ISODate("2026-07-17T10:00:00Z")
            },
            {
                keyword: "ivan",
                searchedAt: ISODate("2026-07-17T10:01:00Z")
            },
            {
                keyword: "microservice",
                searchedAt: ISODate("2026-07-17T10:02:00Z")
            }
        ]
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        history: [
            {
                keyword: "java",
                searchedAt: ISODate("2026-07-17T10:00:00Z")
            },
            {
                keyword: "ivan",
                searchedAt: ISODate("2026-07-17T10:01:00Z")
            },
            {
                keyword: "microservice",
                searchedAt: ISODate("2026-07-17T10:02:00Z")
            }
        ]
    }
]);

print("*** Data Imported ***");