CREATE CONSTRAINT profile_identity_unique IF NOT EXISTS
FOR (profile:Profile)
REQUIRE profile.identity IS UNIQUE;

MERGE (profile1:Profile {
    identity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b"
});

MERGE (profile2:Profile {
    identity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91"
});

