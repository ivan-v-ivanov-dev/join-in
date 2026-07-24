CREATE CONSTRAINT profile_identity_unique IF NOT EXISTS
FOR (p:Profile)
REQUIRE p.identity IS UNIQUE;


MERGE (me:Profile {
    identity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b"
})

MERGE (mother:Profile {
    identity: "67c80c58573c12562067629782b72c455fbd8ab06bbf8dfbd4bc20331d1cbedf"
})

MERGE (father:Profile {
    identity: "41d52bee906b4347466558329fb7a6cbc24b5ab0a5f6c58e2e614decc764fab3"
})

MERGE (brother:Profile {
    identity: "cda07e665379ec023b0577605bfd6f91770fe997d72b4e7d3b90e17c29a1ad9e"
})

// Mother relationships
MERGE (me)-[:SON]->(mother)
MERGE (mother)-[:MOTHER]->(me)

// Father relationships
MERGE (me)-[:SON]->(father)
MERGE (father)-[:FATHER]->(me)

// Brother relationships
MERGE (me)-[:BROTHER]->(brother)
MERGE (brother)-[:BROTHER]->(me)

WITH me

UNWIND [
    "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
    "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
    "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
    "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
    "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
    "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
    "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
    "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
    "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93"
] AS friendIdentity

MERGE (friend:Profile {
    identity: friendIdentity
})

// Me -> friend
MERGE (me)-[:FRIEND]->(friend)

// Friend -> me
MERGE (friend)-[:FRIEND]->(me);

UNWIND [
    "8b94a3f1bdb9d79a74bb71d933c6d0dd6c4dd08f75b89d1cbfcdf462cb0b7fd2",
    "0e1f7c5f7b9e92df58bbd6d9a4c7a7d5be71bbdc40d5d3cbf7dd1b7c3fd8e4b5",
    "3d9abcb92d1d574ef0d0d49b0cb62cb6d6fd6bb49d82f8a3a8e4a7a0d3aefb11"
] AS profileIdentity

MERGE (:Profile {
    identity: profileIdentity
});

MATCH (me:Profile {
    identity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b"
})

UNWIND [
    "f1bc296565b36ec1932fd0b0889fb94f3fc14f56f1141f1327fd4f58cfa6a231",
    "991f49289c5745bbeba353af157a40c48edfed061ead6d417160d9b89a54baa6",
    "aad12f3aa20775b329a00d0f0ccba97dafbc72fd925163e2e26f5ee91ec6b2cd"
] AS requesterIdentity

MERGE (requester:Profile {
    identity: requesterIdentity
})

// The requester sends a friendship request to me
MERGE (requester)-[:FRIENDSHIP_REQUEST]->(me);