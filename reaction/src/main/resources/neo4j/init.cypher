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

// ============================================================================
// ADDITIONAL REACTION SERVICE IMPORT
//
// This file is an ADD-ON to the existing Reaction Service import.
// It contains ONLY the 18 new posts and 54 new comments from the new
// Cassandra Post Service import, plus random reactions.
//
// Existing constraints, Profile nodes, old Post nodes, old Comment nodes,
// and old reactions are intentionally NOT repeated.
//
// Assumption: the original Reaction Service import has already created
// the 10 Profile nodes used below.
// ============================================================================

// ============================================================================
// 1. NEW POSTS
// Identity is the only node property.
// ============================================================================

UNWIND [
    "7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573",
    "a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f",
    "89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e",
    "6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5",
    "a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341",
    "b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0",
    "6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635",
    "900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4",
    "5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c",
    "6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065",
    "8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4",
    "d72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d",
    "0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5",
    "695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c",
    "56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984",
    "1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d",
    "f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401",
    "91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c"
] AS identityValue

MERGE (:Post {
    identity: identityValue
});


// ============================================================================
// 2. NEW COMMENTS
// Identity is the only node property.
// ============================================================================

UNWIND [
    "e4978ad7b95dd9acfbebf3454d3fd115860f2fce22c26ef1a93a95edc0bd43fb4329e4d0428dd0a993fcb054e72b940bcfa684a606f0809e5308fb608bf0dbb6",
    "3dab9e9191c26f3923b5ef2a9fad15754fd2d395b092166a83be0c35403e2e55d009cbb02812fa346345524c599ac8c3fdbb0e98792f60ac0e725fc22e474565",
    "9dcd4d50c689b3062756c816c5f4a601873d6f2ac0d64d1afdadcb586eba36790565070c8b53047861b92852e6f4c550daee29ea73d7e61c4987fc5091b7faa1",
    "fcbb713b71de49d0be9aae64de47b92d5eeaa9c7367065d88ec6851bfaa8304ae1ee3219652ba8720b5c79a185172b9635bf5fb323d365f3bd7b5cd023c0b4ce",
    "2e1301c218ccc8b6b03a630c271ff825f57c365398de8e69ecce39aad94b1bd5bfc8b3b39d35215f5433423b6bd74732e56aaf2ff6caad4d575937847ffa456f",
    "0580547e79437450dec689ece7c64956f848112854716ef809dc814edd896c0820193ff814a11e721a9cb9e1db9618bbd8e613db91f53d7c964e74cac93d074f",
    "aeef004b52732cb81bd39d62cd18ec6028879373622291815442ddab956caf983e8701d154bfb001a69c7737973e81b96fc9b7dafc8a23afff0063fbb7aa23e9",
    "d4a4dae60a60f9e99db255e7c7525dff383a457b1734aacfa96a6bce13d7e6e682e3d4d80de61f8534cffe47c8250cb856a01c7dd98a40f1a19672a65d4fdd6c",
    "a970bacfa27fc57fb2fa83059b82dbc82b7316173f041bde866a6de388ffdcbf933cd08938c51090ba9c3d0f2f0f0fc455127d26990a8b1b72aaab9bbd1c644c",
    "047128c05508a3598216a45cba92185f3c1c441c28cd1ee9c741d37faa6ef55f02ed6e3dfb5cd2da27647ff1401469ca9452bccff5ff4fcd0bd4c53d33a8f32c",
    "713e7e63f779cf1f6924bbbf574cd5bb2c7295f409aa389bb2fc70bd248531fa27bb9315a58152c7ee746d6da871d2d221bc73a4aee52620b4b419ac6dfa8f15",
    "0f1e4d6d2c53e59d294cc4b55edbf7647d1365429d0b5be58c01b3c19743457e72462e0612ed9a47f124edc10655fc75e1dd7f3c25792027e89c7e142e422031",
    "2ca06c51473a33c59ea6b90d63798eefe1080fe75e5456b263efaaafe6caf09fad4c814c739033faef0b3fc739274060fbbdaaccd0f3f95afdcdafd7c9b9a6e7",
    "6938d4711b6fbd7b204513ff902b004faefd67575c7a3553b5457c00161f1a5e169c13cfb443f5dc1378434cd72db2dabaf6c2c818762beca00646b1fa3a570f",
    "b5f2759c208b2ab4e3692d449975ab1c932f87a19cff767a41a076a471a028d4d53babdbdf109279966e94142fa1a7679554544918eb660887f6ff70ff5d8e90",
    "bb0bbca0dae5448a7e217cc02d301830a0e396a3901a585c849a2c486b3416559444acf8d1232ad42c7076b5af1adb732f9e79728645573309cfc1f4de2a8a94",
    "f06b134e6e7c47e1eb969f0866f86aa0c9bc212b955d3b0f90ac066395717fcb28ff0689c2dd898c4170a19cb3d226713cd1eed9a80b24907730125add852e2f",
    "d9983cdb5af0bd1b4e4ce695aade856c16c607f8edfb95b19bfd59a64e9cb4f9baba4fe770d8048db8fc60e1277cc421a17c425388c02cf2c2688bc161452700",
    "c8098bee68f2af133946a91340dd7c0bc8ccd6c80e0f7347736d7e89a448ec572dbbcb51686295ac42378c34d8800fff8bef1e98f3901f7c25a43121c3f30cb9",
    "0b7eb6a5be147da1b4bf63ab531c79dcf6b24645b1f55a05c8f3cf5c18c12cd0155f27ad07d05cc85b3da0445721e7fc9e859c5281c2876920c20187d77a6731",
    "d2370de0bebd2bcef1f369f444547c513569a8d0f3fa168a7bcac6dc8dc734a85a7c8c88a0c76929c1a80ec8a902edfc96792e908c22ba9b6b7662d055cfb4a9",
    "17ae4e7bfa7c2917d748758a5010ced5a6864215298e13f70598279eda8f28ea4a9bf7a48e19cfa6b1ceeb1f02ff6cec9aff15deb3c2613a47eb6c48402c1e81",
    "97bd3f85bb6aa7bcbf283d7cc39ec4481e5734e86c19916b19e43c94e6fc7767af329928108a755048159581ebe4afb20dccb0dbe090ff0d1ab7918a48f637f7",
    "e17f20e616131a0252d6b843a43ea06a87f67aab8aa5decdeb53274c03dc186c5970ce122f8746edca0534519d7107aefb451ef8667a071b6f78ff41a67f1d9f",
    "82a3fc2f302552d3c682b830ce3fe53f2eb56c821c83738147f1092c23bc7f66eb54b8d1d281e58b1c7c0784a2e1edcf68c566f46e6f34123621f02ef635370f",
    "e9aaea3a7aacf101df98a48fb8befab48648828fe3d94fe6fe291bb09bdb20ca14d1ddbcccfdbd3fab4b92b229b85f749b17d9cbdcc36222adb92673f5fd9ae2",
    "54ea83cc808f8cb8d711b9aa519ea0668ff3da1b717c00456d1f036db3f5b1c5f99886193ea064a0e5012b71597864b328650dfbc6a5eb52cdd00a90d46bdaaf",
    "50a941dbfa1aa66a8545f50c3e212d9513260e0aff9e04010adccaab3cbeb489d2d44e8931873d8fa053b2f6cb43991ac0805c7a6e0efe0888586672bb3c5090",
    "f5060bbe5f03ffdddb8d737d725cf68bd04b6764189e41ecd6e5f5df1e9008bb8ff18071bcfe7d3b0018c6df1b2fe909220dfd723c79dc2b1457c619089a4278",
    "abbbbe8b8b375cdd75760bfba8638ff5745ebeab99dacbb04990d220c4360db703cf36cc8aea12ecc991a7f63fbcc7326bffc8af599cc634da738bf8286ba3d6",
    "f515a9e4746f3f01bcd9f00693079ebe2d9f0e81d56c1225b7b953d956c88622fe82848156eea84321eff95f4a719597ea51bcd55693b42a1447ca43a9f0e6e9",
    "60d8a9fbfd9260a58063bdb22cecd0fe29386a626eb9e20822e69c30301bebe8b928485a5d003dbeb2a7101af0c8cf40af4f68929b9b92037c86a54945a4a289",
    "6b368cab8d75220c18eaba46a5fc9b98bd6c182271f7dfa7a0c02f86031d23b34d65190b657f8cc31887ad8cc92f4673a068f86e3a72d3e381ce2d8eb1e7981f",
    "6611811e146f0e51f48dbecfdc8d9216f2df580bf1fcfe7807d39fdb3e129c3b60dfa1efac5da7dc3d95dbbf8a54a53be98fed6b8c831ecaf1c48c6a5f03a0c7",
    "fe67d22bea3b1c4eaabd333742174b6b3d86d2772f3c22e6d0fa3be91ab49b53b00fd96f675820436d620abbab6a60649720d9ef2b125d8ffd4b2e82e96ea7d7",
    "8530f6e1981302d5e4a68b5cd962316506bd69c235d0f223a61e015a3ebeb203f5306d883880fb44b0dee4a3ea4f8e519a89f3899bbc3531297fa97ea050fff2",
    "b5f86a9adb88d68a70e28e648b1b7922c8ca689c9e8828059daea9271de67e16b27087bb6732e7bd9f31b541e3910896cee619caf2c61444452fc7a65de4f468",
    "930c1052e00c070be8b4ae9b26b1736f72c6b05119d8673ae3435719bf558965c081313d7302c4dce0299ff6231917bc22e1208319944d28bc57efae2f3f3778",
    "1f67a92e38ba7d2189fb1dcf6fa409cdd5194de1447098acd5cd2b00bfd807bd780f66da42afa9994b1bea416c5913acaeb0508cd8610cb5c707ed00d1a6bd13",
    "7979c419ebe826fe83679598b5fb35475fd73bfc43a587014b2967617a5ebc0baea07d3e95be5805435ad796133be6aa24eff27324e3b86d90705e8065960b07",
    "fc5251e06927a7bf79fbd4e63211dd57bc335cfc09b03362e0f84827ca193a75e8f5b1e0d8fd5523098ce910d91c0ccecb8e19bab7db7428000b33cefd427bf8",
    "79f8aeb0ce7faf3b20d3897ae6e99f57e246a8b91ad005c7829293d62855a8347115b10d8ff4072b8d3baca08b47b159c7163dae150c65dfdca2f014e88c8f2e",
    "96fbe98eda8b1fa686e799945f895d777fc4d7ffc6bc92e64da07e17a37f3078c9dd1a1f4cdd61e588ad21e95844291274d51a109c03bcb5ac0f27444efd28b9",
    "0b7a24ca8c2a3d7b0687967b0e6f698ed34b565f824bbb700841ba32e627d83faf3800bed0632c8e5ac697a0f40fd08a69962bbf8a83a7fc76513eae9307b21b",
    "55e59ae8f21e224c0662adb2140cab16bcf28aa5cea937e85fdf4edcbc967c28c37d064e20b042c1c0aa3c8fefcaf8c1bfbe0d976a4c5e388d704e503f286673",
    "f532d31e16b5a4f7d0403c703aa2d2ad4a61eafbba80f9e6ac0eacf9e73a15b29a4f6c41bc5614bb5963843c8253e05c4649446627655944a14ac0e3f9b3c01b",
    "eec9ad9c950c9cf1a4b291ba3b714a1e98b0a3be22d01a624f663cf71ec24c99ca585cc2e8560f902719bdabc890a96973c421824f4961cf229072525e26a096",
    "c6f4c1e070963eed3e048f3616fedfcfdc732d3f6c55a59dd1522d75f93f64176e033abfc82bab5eac3c2ebe5909fa33967e46a7a57b454bce21a3f04d1ad915",
    "ef1d29b88b38da0e4153f43a9b6b27265257124a1c62c390a8f0b76b0cea6175ebfbabb13d7edaa8438b361b01cf03be3bf6b49f660403557285ed05d9efc9c0",
    "da0bac8ded9f5d6bd2b7b02867a1aa6b8227720261dc402259173f1f044cf5d75f8322f8a46fe22c0f12080c398950e45502918897888b359594b47b4ae59bd2",
    "885a8fd84b3d78e5098298cd9c86525cd49bd41cd6c4575c2f4e6a37f70931500fed3bd1c559d4036e913b4be3932622a65e270fba7111533624dfa14d63ecad",
    "f1e0dda9f7505a51fe8191aa52e15c4bbf5aa59df38013f81174f3f6c2b16d6f7ef3d12d194cb4133db2fec1b7591727029eeb9a10c139eee1ca2ba616f2aa66",
    "bb8641a18fdf6071be4ca012365e32706ff5b6fc8d08049ab5e3c590d3244e25d123b0f6cc22d4d207b99bae1bbc191df86dc68a28330c2da3e1a81fb1aae6b2",
    "04601608fb48eb922cdc68de8df1d631cc8ca2b05bcf885b683a8f9b10977e5c7e3d0bbc7f4cc5876cd6da2f24db65fa8814aa41e241a8d02a118769b142fd7e"
] AS identityValue

MERGE (:Comment {
    identity: identityValue
});


// ============================================================================
// 3. RANDOM POST REACTIONS
//
// Each new post receives reactions from 3 distinct profiles.
// The post author is excluded.
// Before MERGE, all supported reactions for the same Profile -> Post pair
// are removed, preserving one reaction per profile/post pair.
// ============================================================================

// ------------------------------------
// LIKE reactions to posts
// ------------------------------------

UNWIND [
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "d72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c"
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
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "d72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401"
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
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "d72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c"
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
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c"
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
// 4. RANDOM COMMENT REACTIONS
//
// Each new comment receives reactions from 2 distinct profiles.
// The comment author is excluded.
// Before MERGE, LIKE/DISLIKE for the same Profile -> Comment pair are removed.
// ============================================================================

// ------------------------------------
// LIKE reactions to comments
// ------------------------------------

UNWIND [
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "e4978ad7b95dd9acfbebf3454d3fd115860f2fce22c26ef1a93a95edc0bd43fb4329e4d0428dd0a993fcb054e72b940bcfa684a606f0809e5308fb608bf0dbb6"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "3dab9e9191c26f3923b5ef2a9fad15754fd2d395b092166a83be0c35403e2e55d009cbb02812fa346345524c599ac8c3fdbb0e98792f60ac0e725fc22e474565"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "9dcd4d50c689b3062756c816c5f4a601873d6f2ac0d64d1afdadcb586eba36790565070c8b53047861b92852e6f4c550daee29ea73d7e61c4987fc5091b7faa1"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "9dcd4d50c689b3062756c816c5f4a601873d6f2ac0d64d1afdadcb586eba36790565070c8b53047861b92852e6f4c550daee29ea73d7e61c4987fc5091b7faa1"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "fcbb713b71de49d0be9aae64de47b92d5eeaa9c7367065d88ec6851bfaa8304ae1ee3219652ba8720b5c79a185172b9635bf5fb323d365f3bd7b5cd023c0b4ce"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "2e1301c218ccc8b6b03a630c271ff825f57c365398de8e69ecce39aad94b1bd5bfc8b3b39d35215f5433423b6bd74732e56aaf2ff6caad4d575937847ffa456f"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "2e1301c218ccc8b6b03a630c271ff825f57c365398de8e69ecce39aad94b1bd5bfc8b3b39d35215f5433423b6bd74732e56aaf2ff6caad4d575937847ffa456f"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "0580547e79437450dec689ece7c64956f848112854716ef809dc814edd896c0820193ff814a11e721a9cb9e1db9618bbd8e613db91f53d7c964e74cac93d074f"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "aeef004b52732cb81bd39d62cd18ec6028879373622291815442ddab956caf983e8701d154bfb001a69c7737973e81b96fc9b7dafc8a23afff0063fbb7aa23e9"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "d4a4dae60a60f9e99db255e7c7525dff383a457b1734aacfa96a6bce13d7e6e682e3d4d80de61f8534cffe47c8250cb856a01c7dd98a40f1a19672a65d4fdd6c"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "d4a4dae60a60f9e99db255e7c7525dff383a457b1734aacfa96a6bce13d7e6e682e3d4d80de61f8534cffe47c8250cb856a01c7dd98a40f1a19672a65d4fdd6c"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "047128c05508a3598216a45cba92185f3c1c441c28cd1ee9c741d37faa6ef55f02ed6e3dfb5cd2da27647ff1401469ca9452bccff5ff4fcd0bd4c53d33a8f32c"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "047128c05508a3598216a45cba92185f3c1c441c28cd1ee9c741d37faa6ef55f02ed6e3dfb5cd2da27647ff1401469ca9452bccff5ff4fcd0bd4c53d33a8f32c"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "713e7e63f779cf1f6924bbbf574cd5bb2c7295f409aa389bb2fc70bd248531fa27bb9315a58152c7ee746d6da871d2d221bc73a4aee52620b4b419ac6dfa8f15"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "0f1e4d6d2c53e59d294cc4b55edbf7647d1365429d0b5be58c01b3c19743457e72462e0612ed9a47f124edc10655fc75e1dd7f3c25792027e89c7e142e422031"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "0f1e4d6d2c53e59d294cc4b55edbf7647d1365429d0b5be58c01b3c19743457e72462e0612ed9a47f124edc10655fc75e1dd7f3c25792027e89c7e142e422031"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "2ca06c51473a33c59ea6b90d63798eefe1080fe75e5456b263efaaafe6caf09fad4c814c739033faef0b3fc739274060fbbdaaccd0f3f95afdcdafd7c9b9a6e7"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "6938d4711b6fbd7b204513ff902b004faefd67575c7a3553b5457c00161f1a5e169c13cfb443f5dc1378434cd72db2dabaf6c2c818762beca00646b1fa3a570f"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "b5f2759c208b2ab4e3692d449975ab1c932f87a19cff767a41a076a471a028d4d53babdbdf109279966e94142fa1a7679554544918eb660887f6ff70ff5d8e90"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "bb0bbca0dae5448a7e217cc02d301830a0e396a3901a585c849a2c486b3416559444acf8d1232ad42c7076b5af1adb732f9e79728645573309cfc1f4de2a8a94"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "d9983cdb5af0bd1b4e4ce695aade856c16c607f8edfb95b19bfd59a64e9cb4f9baba4fe770d8048db8fc60e1277cc421a17c425388c02cf2c2688bc161452700"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "d9983cdb5af0bd1b4e4ce695aade856c16c607f8edfb95b19bfd59a64e9cb4f9baba4fe770d8048db8fc60e1277cc421a17c425388c02cf2c2688bc161452700"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "c8098bee68f2af133946a91340dd7c0bc8ccd6c80e0f7347736d7e89a448ec572dbbcb51686295ac42378c34d8800fff8bef1e98f3901f7c25a43121c3f30cb9"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "0b7eb6a5be147da1b4bf63ab531c79dcf6b24645b1f55a05c8f3cf5c18c12cd0155f27ad07d05cc85b3da0445721e7fc9e859c5281c2876920c20187d77a6731"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "d2370de0bebd2bcef1f369f444547c513569a8d0f3fa168a7bcac6dc8dc734a85a7c8c88a0c76929c1a80ec8a902edfc96792e908c22ba9b6b7662d055cfb4a9"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "d2370de0bebd2bcef1f369f444547c513569a8d0f3fa168a7bcac6dc8dc734a85a7c8c88a0c76929c1a80ec8a902edfc96792e908c22ba9b6b7662d055cfb4a9"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "e17f20e616131a0252d6b843a43ea06a87f67aab8aa5decdeb53274c03dc186c5970ce122f8746edca0534519d7107aefb451ef8667a071b6f78ff41a67f1d9f"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "82a3fc2f302552d3c682b830ce3fe53f2eb56c821c83738147f1092c23bc7f66eb54b8d1d281e58b1c7c0784a2e1edcf68c566f46e6f34123621f02ef635370f"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "e9aaea3a7aacf101df98a48fb8befab48648828fe3d94fe6fe291bb09bdb20ca14d1ddbcccfdbd3fab4b92b229b85f749b17d9cbdcc36222adb92673f5fd9ae2"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "54ea83cc808f8cb8d711b9aa519ea0668ff3da1b717c00456d1f036db3f5b1c5f99886193ea064a0e5012b71597864b328650dfbc6a5eb52cdd00a90d46bdaaf"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "50a941dbfa1aa66a8545f50c3e212d9513260e0aff9e04010adccaab3cbeb489d2d44e8931873d8fa053b2f6cb43991ac0805c7a6e0efe0888586672bb3c5090"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "f5060bbe5f03ffdddb8d737d725cf68bd04b6764189e41ecd6e5f5df1e9008bb8ff18071bcfe7d3b0018c6df1b2fe909220dfd723c79dc2b1457c619089a4278"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "f5060bbe5f03ffdddb8d737d725cf68bd04b6764189e41ecd6e5f5df1e9008bb8ff18071bcfe7d3b0018c6df1b2fe909220dfd723c79dc2b1457c619089a4278"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "abbbbe8b8b375cdd75760bfba8638ff5745ebeab99dacbb04990d220c4360db703cf36cc8aea12ecc991a7f63fbcc7326bffc8af599cc634da738bf8286ba3d6"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "f515a9e4746f3f01bcd9f00693079ebe2d9f0e81d56c1225b7b953d956c88622fe82848156eea84321eff95f4a719597ea51bcd55693b42a1447ca43a9f0e6e9"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "f515a9e4746f3f01bcd9f00693079ebe2d9f0e81d56c1225b7b953d956c88622fe82848156eea84321eff95f4a719597ea51bcd55693b42a1447ca43a9f0e6e9"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "60d8a9fbfd9260a58063bdb22cecd0fe29386a626eb9e20822e69c30301bebe8b928485a5d003dbeb2a7101af0c8cf40af4f68929b9b92037c86a54945a4a289"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "60d8a9fbfd9260a58063bdb22cecd0fe29386a626eb9e20822e69c30301bebe8b928485a5d003dbeb2a7101af0c8cf40af4f68929b9b92037c86a54945a4a289"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "6b368cab8d75220c18eaba46a5fc9b98bd6c182271f7dfa7a0c02f86031d23b34d65190b657f8cc31887ad8cc92f4673a068f86e3a72d3e381ce2d8eb1e7981f"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "6611811e146f0e51f48dbecfdc8d9216f2df580bf1fcfe7807d39fdb3e129c3b60dfa1efac5da7dc3d95dbbf8a54a53be98fed6b8c831ecaf1c48c6a5f03a0c7"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "6611811e146f0e51f48dbecfdc8d9216f2df580bf1fcfe7807d39fdb3e129c3b60dfa1efac5da7dc3d95dbbf8a54a53be98fed6b8c831ecaf1c48c6a5f03a0c7"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "fe67d22bea3b1c4eaabd333742174b6b3d86d2772f3c22e6d0fa3be91ab49b53b00fd96f675820436d620abbab6a60649720d9ef2b125d8ffd4b2e82e96ea7d7"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "b5f86a9adb88d68a70e28e648b1b7922c8ca689c9e8828059daea9271de67e16b27087bb6732e7bd9f31b541e3910896cee619caf2c61444452fc7a65de4f468"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "b5f86a9adb88d68a70e28e648b1b7922c8ca689c9e8828059daea9271de67e16b27087bb6732e7bd9f31b541e3910896cee619caf2c61444452fc7a65de4f468"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "930c1052e00c070be8b4ae9b26b1736f72c6b05119d8673ae3435719bf558965c081313d7302c4dce0299ff6231917bc22e1208319944d28bc57efae2f3f3778"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "7979c419ebe826fe83679598b5fb35475fd73bfc43a587014b2967617a5ebc0baea07d3e95be5805435ad796133be6aa24eff27324e3b86d90705e8065960b07"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "7979c419ebe826fe83679598b5fb35475fd73bfc43a587014b2967617a5ebc0baea07d3e95be5805435ad796133be6aa24eff27324e3b86d90705e8065960b07"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "fc5251e06927a7bf79fbd4e63211dd57bc335cfc09b03362e0f84827ca193a75e8f5b1e0d8fd5523098ce910d91c0ccecb8e19bab7db7428000b33cefd427bf8"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "fc5251e06927a7bf79fbd4e63211dd57bc335cfc09b03362e0f84827ca193a75e8f5b1e0d8fd5523098ce910d91c0ccecb8e19bab7db7428000b33cefd427bf8"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "79f8aeb0ce7faf3b20d3897ae6e99f57e246a8b91ad005c7829293d62855a8347115b10d8ff4072b8d3baca08b47b159c7163dae150c65dfdca2f014e88c8f2e"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "96fbe98eda8b1fa686e799945f895d777fc4d7ffc6bc92e64da07e17a37f3078c9dd1a1f4cdd61e588ad21e95844291274d51a109c03bcb5ac0f27444efd28b9"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "0b7a24ca8c2a3d7b0687967b0e6f698ed34b565f824bbb700841ba32e627d83faf3800bed0632c8e5ac697a0f40fd08a69962bbf8a83a7fc76513eae9307b21b"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "eec9ad9c950c9cf1a4b291ba3b714a1e98b0a3be22d01a624f663cf71ec24c99ca585cc2e8560f902719bdabc890a96973c421824f4961cf229072525e26a096"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "c6f4c1e070963eed3e048f3616fedfcfdc732d3f6c55a59dd1522d75f93f64176e033abfc82bab5eac3c2ebe5909fa33967e46a7a57b454bce21a3f04d1ad915"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "c6f4c1e070963eed3e048f3616fedfcfdc732d3f6c55a59dd1522d75f93f64176e033abfc82bab5eac3c2ebe5909fa33967e46a7a57b454bce21a3f04d1ad915"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "ef1d29b88b38da0e4153f43a9b6b27265257124a1c62c390a8f0b76b0cea6175ebfbabb13d7edaa8438b361b01cf03be3bf6b49f660403557285ed05d9efc9c0"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "ef1d29b88b38da0e4153f43a9b6b27265257124a1c62c390a8f0b76b0cea6175ebfbabb13d7edaa8438b361b01cf03be3bf6b49f660403557285ed05d9efc9c0"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "da0bac8ded9f5d6bd2b7b02867a1aa6b8227720261dc402259173f1f044cf5d75f8322f8a46fe22c0f12080c398950e45502918897888b359594b47b4ae59bd2"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "885a8fd84b3d78e5098298cd9c86525cd49bd41cd6c4575c2f4e6a37f70931500fed3bd1c559d4036e913b4be3932622a65e270fba7111533624dfa14d63ecad"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "f1e0dda9f7505a51fe8191aa52e15c4bbf5aa59df38013f81174f3f6c2b16d6f7ef3d12d194cb4133db2fec1b7591727029eeb9a10c139eee1ca2ba616f2aa66"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "bb8641a18fdf6071be4ca012365e32706ff5b6fc8d08049ab5e3c590d3244e25d123b0f6cc22d4d207b99bae1bbc191df86dc68a28330c2da3e1a81fb1aae6b2"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "bb8641a18fdf6071be4ca012365e32706ff5b6fc8d08049ab5e3c590d3244e25d123b0f6cc22d4d207b99bae1bbc191df86dc68a28330c2da3e1a81fb1aae6b2"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "04601608fb48eb922cdc68de8df1d631cc8ca2b05bcf885b683a8f9b10977e5c7e3d0bbc7f4cc5876cd6da2f24db65fa8814aa41e241a8d02a118769b142fd7e"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "04601608fb48eb922cdc68de8df1d631cc8ca2b05bcf885b683a8f9b10977e5c7e3d0bbc7f4cc5876cd6da2f24db65fa8814aa41e241a8d02a118769b142fd7e"
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
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "e4978ad7b95dd9acfbebf3454d3fd115860f2fce22c26ef1a93a95edc0bd43fb4329e4d0428dd0a993fcb054e72b940bcfa684a606f0809e5308fb608bf0dbb6"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "3dab9e9191c26f3923b5ef2a9fad15754fd2d395b092166a83be0c35403e2e55d009cbb02812fa346345524c599ac8c3fdbb0e98792f60ac0e725fc22e474565"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "fcbb713b71de49d0be9aae64de47b92d5eeaa9c7367065d88ec6851bfaa8304ae1ee3219652ba8720b5c79a185172b9635bf5fb323d365f3bd7b5cd023c0b4ce"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "0580547e79437450dec689ece7c64956f848112854716ef809dc814edd896c0820193ff814a11e721a9cb9e1db9618bbd8e613db91f53d7c964e74cac93d074f"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "aeef004b52732cb81bd39d62cd18ec6028879373622291815442ddab956caf983e8701d154bfb001a69c7737973e81b96fc9b7dafc8a23afff0063fbb7aa23e9"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "a970bacfa27fc57fb2fa83059b82dbc82b7316173f041bde866a6de388ffdcbf933cd08938c51090ba9c3d0f2f0f0fc455127d26990a8b1b72aaab9bbd1c644c"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "a970bacfa27fc57fb2fa83059b82dbc82b7316173f041bde866a6de388ffdcbf933cd08938c51090ba9c3d0f2f0f0fc455127d26990a8b1b72aaab9bbd1c644c"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "713e7e63f779cf1f6924bbbf574cd5bb2c7295f409aa389bb2fc70bd248531fa27bb9315a58152c7ee746d6da871d2d221bc73a4aee52620b4b419ac6dfa8f15"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "2ca06c51473a33c59ea6b90d63798eefe1080fe75e5456b263efaaafe6caf09fad4c814c739033faef0b3fc739274060fbbdaaccd0f3f95afdcdafd7c9b9a6e7"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "6938d4711b6fbd7b204513ff902b004faefd67575c7a3553b5457c00161f1a5e169c13cfb443f5dc1378434cd72db2dabaf6c2c818762beca00646b1fa3a570f"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "b5f2759c208b2ab4e3692d449975ab1c932f87a19cff767a41a076a471a028d4d53babdbdf109279966e94142fa1a7679554544918eb660887f6ff70ff5d8e90"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "bb0bbca0dae5448a7e217cc02d301830a0e396a3901a585c849a2c486b3416559444acf8d1232ad42c7076b5af1adb732f9e79728645573309cfc1f4de2a8a94"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "f06b134e6e7c47e1eb969f0866f86aa0c9bc212b955d3b0f90ac066395717fcb28ff0689c2dd898c4170a19cb3d226713cd1eed9a80b24907730125add852e2f"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "f06b134e6e7c47e1eb969f0866f86aa0c9bc212b955d3b0f90ac066395717fcb28ff0689c2dd898c4170a19cb3d226713cd1eed9a80b24907730125add852e2f"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "c8098bee68f2af133946a91340dd7c0bc8ccd6c80e0f7347736d7e89a448ec572dbbcb51686295ac42378c34d8800fff8bef1e98f3901f7c25a43121c3f30cb9"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "0b7eb6a5be147da1b4bf63ab531c79dcf6b24645b1f55a05c8f3cf5c18c12cd0155f27ad07d05cc85b3da0445721e7fc9e859c5281c2876920c20187d77a6731"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "17ae4e7bfa7c2917d748758a5010ced5a6864215298e13f70598279eda8f28ea4a9bf7a48e19cfa6b1ceeb1f02ff6cec9aff15deb3c2613a47eb6c48402c1e81"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "17ae4e7bfa7c2917d748758a5010ced5a6864215298e13f70598279eda8f28ea4a9bf7a48e19cfa6b1ceeb1f02ff6cec9aff15deb3c2613a47eb6c48402c1e81"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "97bd3f85bb6aa7bcbf283d7cc39ec4481e5734e86c19916b19e43c94e6fc7767af329928108a755048159581ebe4afb20dccb0dbe090ff0d1ab7918a48f637f7"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "97bd3f85bb6aa7bcbf283d7cc39ec4481e5734e86c19916b19e43c94e6fc7767af329928108a755048159581ebe4afb20dccb0dbe090ff0d1ab7918a48f637f7"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "e17f20e616131a0252d6b843a43ea06a87f67aab8aa5decdeb53274c03dc186c5970ce122f8746edca0534519d7107aefb451ef8667a071b6f78ff41a67f1d9f"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "82a3fc2f302552d3c682b830ce3fe53f2eb56c821c83738147f1092c23bc7f66eb54b8d1d281e58b1c7c0784a2e1edcf68c566f46e6f34123621f02ef635370f"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "e9aaea3a7aacf101df98a48fb8befab48648828fe3d94fe6fe291bb09bdb20ca14d1ddbcccfdbd3fab4b92b229b85f749b17d9cbdcc36222adb92673f5fd9ae2"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "54ea83cc808f8cb8d711b9aa519ea0668ff3da1b717c00456d1f036db3f5b1c5f99886193ea064a0e5012b71597864b328650dfbc6a5eb52cdd00a90d46bdaaf"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "50a941dbfa1aa66a8545f50c3e212d9513260e0aff9e04010adccaab3cbeb489d2d44e8931873d8fa053b2f6cb43991ac0805c7a6e0efe0888586672bb3c5090"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "abbbbe8b8b375cdd75760bfba8638ff5745ebeab99dacbb04990d220c4360db703cf36cc8aea12ecc991a7f63fbcc7326bffc8af599cc634da738bf8286ba3d6"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "6b368cab8d75220c18eaba46a5fc9b98bd6c182271f7dfa7a0c02f86031d23b34d65190b657f8cc31887ad8cc92f4673a068f86e3a72d3e381ce2d8eb1e7981f"
    },
    {
        profileIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        targetIdentity: "fe67d22bea3b1c4eaabd333742174b6b3d86d2772f3c22e6d0fa3be91ab49b53b00fd96f675820436d620abbab6a60649720d9ef2b125d8ffd4b2e82e96ea7d7"
    },
    {
        profileIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        targetIdentity: "8530f6e1981302d5e4a68b5cd962316506bd69c235d0f223a61e015a3ebeb203f5306d883880fb44b0dee4a3ea4f8e519a89f3899bbc3531297fa97ea050fff2"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "8530f6e1981302d5e4a68b5cd962316506bd69c235d0f223a61e015a3ebeb203f5306d883880fb44b0dee4a3ea4f8e519a89f3899bbc3531297fa97ea050fff2"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "930c1052e00c070be8b4ae9b26b1736f72c6b05119d8673ae3435719bf558965c081313d7302c4dce0299ff6231917bc22e1208319944d28bc57efae2f3f3778"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "1f67a92e38ba7d2189fb1dcf6fa409cdd5194de1447098acd5cd2b00bfd807bd780f66da42afa9994b1bea416c5913acaeb0508cd8610cb5c707ed00d1a6bd13"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "1f67a92e38ba7d2189fb1dcf6fa409cdd5194de1447098acd5cd2b00bfd807bd780f66da42afa9994b1bea416c5913acaeb0508cd8610cb5c707ed00d1a6bd13"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "79f8aeb0ce7faf3b20d3897ae6e99f57e246a8b91ad005c7829293d62855a8347115b10d8ff4072b8d3baca08b47b159c7163dae150c65dfdca2f014e88c8f2e"
    },
    {
        profileIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        targetIdentity: "96fbe98eda8b1fa686e799945f895d777fc4d7ffc6bc92e64da07e17a37f3078c9dd1a1f4cdd61e588ad21e95844291274d51a109c03bcb5ac0f27444efd28b9"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "0b7a24ca8c2a3d7b0687967b0e6f698ed34b565f824bbb700841ba32e627d83faf3800bed0632c8e5ac697a0f40fd08a69962bbf8a83a7fc76513eae9307b21b"
    },
    {
        profileIdentity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        targetIdentity: "55e59ae8f21e224c0662adb2140cab16bcf28aa5cea937e85fdf4edcbc967c28c37d064e20b042c1c0aa3c8fefcaf8c1bfbe0d976a4c5e388d704e503f286673"
    },
    {
        profileIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        targetIdentity: "55e59ae8f21e224c0662adb2140cab16bcf28aa5cea937e85fdf4edcbc967c28c37d064e20b042c1c0aa3c8fefcaf8c1bfbe0d976a4c5e388d704e503f286673"
    },
    {
        profileIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        targetIdentity: "f532d31e16b5a4f7d0403c703aa2d2ad4a61eafbba80f9e6ac0eacf9e73a15b29a4f6c41bc5614bb5963843c8253e05c4649446627655944a14ac0e3f9b3c01b"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "f532d31e16b5a4f7d0403c703aa2d2ad4a61eafbba80f9e6ac0eacf9e73a15b29a4f6c41bc5614bb5963843c8253e05c4649446627655944a14ac0e3f9b3c01b"
    },
    {
        profileIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        targetIdentity: "eec9ad9c950c9cf1a4b291ba3b714a1e98b0a3be22d01a624f663cf71ec24c99ca585cc2e8560f902719bdabc890a96973c421824f4961cf229072525e26a096"
    },
    {
        profileIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        targetIdentity: "da0bac8ded9f5d6bd2b7b02867a1aa6b8227720261dc402259173f1f044cf5d75f8322f8a46fe22c0f12080c398950e45502918897888b359594b47b4ae59bd2"
    },
    {
        profileIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        targetIdentity: "885a8fd84b3d78e5098298cd9c86525cd49bd41cd6c4575c2f4e6a37f70931500fed3bd1c559d4036e913b4be3932622a65e270fba7111533624dfa14d63ecad"
    },
    {
        profileIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        targetIdentity: "f1e0dda9f7505a51fe8191aa52e15c4bbf5aa59df38013f81174f3f6c2b16d6f7ef3d12d194cb4133db2fec1b7591727029eeb9a10c139eee1ca2ba616f2aa66"
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

