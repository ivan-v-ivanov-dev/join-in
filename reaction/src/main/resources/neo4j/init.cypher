// ============================================================================
// 1. UNIQUENESS CONSTRAINTS
// ============================================================================

CREATE CONSTRAINT profile_identity_unique IF NOT EXISTS
FOR (profile:Profile)
REQUIRE profile.identity IS UNIQUE;

CREATE CONSTRAINT post_identity_unique IF NOT EXISTS
FOR (post:Post)
REQUIRE post.identity IS UNIQUE;

CREATE CONSTRAINT comment_identity_unique IF NOT EXISTS
FOR (comment:Comment)
REQUIRE comment.identity IS UNIQUE;


// ============================================================================
// 2. PROFILES
// Current user + 9 friends. Identity is the only node property.
// ============================================================================

UNWIND [
    "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
    "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
    "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
    "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
    "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
    "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
    "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
    "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
    "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
    "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93"
] AS identityValue

MERGE (:Profile {
    identity: identityValue
});


// ============================================================================
// 3. POSTS
// Identity is the only node property.
// ============================================================================

UNWIND [
    "5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd",
    "afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72",
    "6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507",
    "2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb",
    "0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9"
] AS identityValue

MERGE (:Post {
    identity: identityValue
});


// ============================================================================
// 4. COMMENTS
// Identity is the only node property.
// ============================================================================

UNWIND [
    "745e7ba3e356a15eee31e7c42ca83e9eab296b6ad5a13c7afee4a3779a18c1c2ea5fa65b27638aabbc50f8bc71be59ae3243db17c66ea11f63555b7e61767cad",
    "06f6aece1bcab67f763945239186fea8e0147ebc61c3fc0ed80b6ff30d911d3fd90bbfc96360f7267fa24725e208c154c15feeeae2e69f829cd411da07db932e",
    "8582e9cce74f9acc1f1806e9afcdc6b8af1e62ffeeefbd1b15d642b7ae971b2b7f3fde60d03e62d5f0c9b3f72e7b3628ac8d7226b67f1a083404e6aa25700d04",
    "03c23500a20aac85c64be572c57c5d5a83b387fb0151f801c831011c2eb7ae7b03c630d95cdacc2e87958add57683626cf2db55787c16b508b3cc6d74fafcae3",
    "ae64b2a9de13224d1b0ac0758d7b9b7cdb455deb72d8f162bd09947d220963786ef3e8b5a80c17fea1b34386ff93d4c7bc9f57e1a3a2e4be4a9623dab7792481",
    "9c4f65b0b6d677f4e586f7d43479bfe3b30822e00f9df3ff360e560b8103a95ef79ca972abb4a00db98abb7ef24ac7b8fed3992e70b590118e570c49e264573f",
    "f0b297e834095c0425aa0e41fda086e2c56eaff036a113f0ff02878bc76cfb5dd5a0b1b0189dda167e9beae1839f8e32c1909b7f994760fce44f3e6ca5ddd6be",
    "86be8ae0303bf1cb58a391e0cf28d8d297d1147ab7e52501024cc7d94907bbb3608e9d983ae42ab7ca18afbde4286b811a4e22d7129d0745281be6e44ae36c9c",
    "40cb549c685e99214bdc012cbbbd4590019cb60639e9ffc3e0d2676ec4ef91eb47a195290b7f069a90199b81570676edd12554ac4084d77aae7e2f650ada36de"
] AS identityValue

MERGE (:Comment {
    identity: identityValue
});


// ============================================================================
// 5. POST REACTIONS
//
// Before creating a seeded reaction, all supported post-reaction relationships
// for the same Profile -> Post pair are removed. This prevents a profile from
// having two different reaction types toward the same post.
// ============================================================================


// ------------------------------------
// LIKE reactions to posts
// ------------------------------------

UNWIND [
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9"
    }
] AS reactionData

MATCH (profile:Profile {
    identity: reactionData.profileIdentity
})
MATCH (post:Post {
    identity: reactionData.targetIdentity
})
OPTIONAL MATCH (profile)-[existing:LIKE|DISLIKE|HAHA|ANGRY]->(post)
WITH profile, post, collect(existing) AS existingReactions
FOREACH (reaction IN existingReactions | DELETE reaction)
MERGE (profile)-[:LIKE]->(post);


// ------------------------------------
// DISLIKE reactions to posts
// ------------------------------------

UNWIND [
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9"
    }
] AS reactionData

MATCH (profile:Profile {
    identity: reactionData.profileIdentity
})
MATCH (post:Post {
    identity: reactionData.targetIdentity
})
OPTIONAL MATCH (profile)-[existing:LIKE|DISLIKE|HAHA|ANGRY]->(post)
WITH profile, post, collect(existing) AS existingReactions
FOREACH (reaction IN existingReactions | DELETE reaction)
MERGE (profile)-[:DISLIKE]->(post);


// ------------------------------------
// HAHA reactions to posts
// ------------------------------------

UNWIND [
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9"
    }
] AS reactionData

MATCH (profile:Profile {
    identity: reactionData.profileIdentity
})
MATCH (post:Post {
    identity: reactionData.targetIdentity
})
OPTIONAL MATCH (profile)-[existing:LIKE|DISLIKE|HAHA|ANGRY]->(post)
WITH profile, post, collect(existing) AS existingReactions
FOREACH (reaction IN existingReactions | DELETE reaction)
MERGE (profile)-[:HAHA]->(post);


// ------------------------------------
// ANGRY reactions to posts
// ------------------------------------

UNWIND [
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9"
    }
] AS reactionData

MATCH (profile:Profile {
    identity: reactionData.profileIdentity
})
MATCH (post:Post {
    identity: reactionData.targetIdentity
})
OPTIONAL MATCH (profile)-[existing:LIKE|DISLIKE|HAHA|ANGRY]->(post)
WITH profile, post, collect(existing) AS existingReactions
FOREACH (reaction IN existingReactions | DELETE reaction)
MERGE (profile)-[:ANGRY]->(post);


// ============================================================================
// 6. COMMENT REACTIONS
//
// Before creating a seeded reaction, LIKE and DISLIKE relationships for the
// same Profile -> Comment pair are removed.
// ============================================================================


// ------------------------------------
// LIKE reactions to comments
// ------------------------------------

UNWIND [
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "745e7ba3e356a15eee31e7c42ca83e9eab296b6ad5a13c7afee4a3779a18c1c2ea5fa65b27638aabbc50f8bc71be59ae3243db17c66ea11f63555b7e61767cad"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "06f6aece1bcab67f763945239186fea8e0147ebc61c3fc0ed80b6ff30d911d3fd90bbfc96360f7267fa24725e208c154c15feeeae2e69f829cd411da07db932e"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "8582e9cce74f9acc1f1806e9afcdc6b8af1e62ffeeefbd1b15d642b7ae971b2b7f3fde60d03e62d5f0c9b3f72e7b3628ac8d7226b67f1a083404e6aa25700d04"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "03c23500a20aac85c64be572c57c5d5a83b387fb0151f801c831011c2eb7ae7b03c630d95cdacc2e87958add57683626cf2db55787c16b508b3cc6d74fafcae3"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "ae64b2a9de13224d1b0ac0758d7b9b7cdb455deb72d8f162bd09947d220963786ef3e8b5a80c17fea1b34386ff93d4c7bc9f57e1a3a2e4be4a9623dab7792481"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "9c4f65b0b6d677f4e586f7d43479bfe3b30822e00f9df3ff360e560b8103a95ef79ca972abb4a00db98abb7ef24ac7b8fed3992e70b590118e570c49e264573f"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "f0b297e834095c0425aa0e41fda086e2c56eaff036a113f0ff02878bc76cfb5dd5a0b1b0189dda167e9beae1839f8e32c1909b7f994760fce44f3e6ca5ddd6be"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "86be8ae0303bf1cb58a391e0cf28d8d297d1147ab7e52501024cc7d94907bbb3608e9d983ae42ab7ca18afbde4286b811a4e22d7129d0745281be6e44ae36c9c"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "40cb549c685e99214bdc012cbbbd4590019cb60639e9ffc3e0d2676ec4ef91eb47a195290b7f069a90199b81570676edd12554ac4084d77aae7e2f650ada36de"
    }
] AS reactionData

MATCH (profile:Profile {
    identity: reactionData.profileIdentity
})
MATCH (comment:Comment {
    identity: reactionData.targetIdentity
})
OPTIONAL MATCH (profile)-[existing:LIKE|DISLIKE]->(comment)
WITH profile, comment, collect(existing) AS existingReactions
FOREACH (reaction IN existingReactions | DELETE reaction)
MERGE (profile)-[:LIKE]->(comment);


// ------------------------------------
// DISLIKE reactions to comments
// ------------------------------------

UNWIND [
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "745e7ba3e356a15eee31e7c42ca83e9eab296b6ad5a13c7afee4a3779a18c1c2ea5fa65b27638aabbc50f8bc71be59ae3243db17c66ea11f63555b7e61767cad"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "06f6aece1bcab67f763945239186fea8e0147ebc61c3fc0ed80b6ff30d911d3fd90bbfc96360f7267fa24725e208c154c15feeeae2e69f829cd411da07db932e"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "8582e9cce74f9acc1f1806e9afcdc6b8af1e62ffeeefbd1b15d642b7ae971b2b7f3fde60d03e62d5f0c9b3f72e7b3628ac8d7226b67f1a083404e6aa25700d04"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "03c23500a20aac85c64be572c57c5d5a83b387fb0151f801c831011c2eb7ae7b03c630d95cdacc2e87958add57683626cf2db55787c16b508b3cc6d74fafcae3"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "ae64b2a9de13224d1b0ac0758d7b9b7cdb455deb72d8f162bd09947d220963786ef3e8b5a80c17fea1b34386ff93d4c7bc9f57e1a3a2e4be4a9623dab7792481"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "9c4f65b0b6d677f4e586f7d43479bfe3b30822e00f9df3ff360e560b8103a95ef79ca972abb4a00db98abb7ef24ac7b8fed3992e70b590118e570c49e264573f"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "f0b297e834095c0425aa0e41fda086e2c56eaff036a113f0ff02878bc76cfb5dd5a0b1b0189dda167e9beae1839f8e32c1909b7f994760fce44f3e6ca5ddd6be"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "86be8ae0303bf1cb58a391e0cf28d8d297d1147ab7e52501024cc7d94907bbb3608e9d983ae42ab7ca18afbde4286b811a4e22d7129d0745281be6e44ae36c9c"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "40cb549c685e99214bdc012cbbbd4590019cb60639e9ffc3e0d2676ec4ef91eb47a195290b7f069a90199b81570676edd12554ac4084d77aae7e2f650ada36de"
    }
] AS reactionData

MATCH (profile:Profile {
    identity: reactionData.profileIdentity
})
MATCH (comment:Comment {
    identity: reactionData.targetIdentity
})
OPTIONAL MATCH (profile)-[existing:LIKE|DISLIKE]->(comment)
WITH profile, comment, collect(existing) AS existingReactions
FOREACH (reaction IN existingReactions | DELETE reaction)
MERGE (profile)-[:DISLIKE]->(comment);

