use ("admin");
db.auth("rootuser", "rootpass");
console.log('*** Authentication with root user ***')

use ("storage");
db.createCollection("429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b");
db.createCollection("9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91");
db.createCollection("771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551");
console.log('*** Collections created ***')

db.getCollection(
    "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b"
).insertMany([

    // =====================================================
    // COMMENTS ON POST 1
    // =====================================================

    {
        authorIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        postIdentity: "5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd",
        content: "Petur Petrov commented on your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:01:00.000Z")
    },
    {
        authorIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        postIdentity: "5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd",
        content: "Georgi Georgiev commented on your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:02:00.000Z")
    },

    // =====================================================
    // REACTIONS TO POST 1
    // =====================================================

    {
        authorIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        postIdentity: "5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd",
        content: "Petur Petrov liked your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:03:00.000Z")
    },
    {
        authorIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        postIdentity: "5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd",
        content: "Konstantin Dimitrov disliked your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:04:00.000Z")
    },
    {
        authorIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        postIdentity: "5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd",
        content: "Iliya Iliev reacted with HAHA to your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:05:00.000Z")
    },
    {
        authorIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        postIdentity: "5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd",
        content: "Tanya Petrova reacted with ANGRY to your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:06:00.000Z")
    },

    // =====================================================
    // COMMENTS ON POST 2
    // =====================================================

    {
        authorIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        postIdentity: "afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72",
        content: "Stoyan Stoyanov commented on your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:06:00.000Z")
    },
    {
        authorIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        postIdentity: "afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72",
        content: "Victoriya Petrova commented on your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:07:00.000Z")
    },

    // =====================================================
    // REACTIONS TO POST 2
    // =====================================================

    {
        authorIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        postIdentity: "afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72",
        content: "Georgi Georgiev liked your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:08:00.000Z")
    },
    {
        authorIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        postIdentity: "afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72",
        content: "Angel Angelov disliked your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:09:00.000Z")
    },
    {
        authorIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        postIdentity: "afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72",
        content: "Stoyan Stoyanov reacted with HAHA to your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:10:00.000Z")
    },
    {
        authorIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        postIdentity: "afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72",
        content: "Victoriya Petrova reacted with ANGRY to your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:11:00.000Z")
    },

    // =====================================================
    // COMMENTS ON POST 3
    // =====================================================

    {
        authorIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        postIdentity: "6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507",
        content: "Mariya Georgieva commented on your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:11:00.000Z")
    },
    {
        authorIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        postIdentity: "6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507",
        content: "Konstantin Dimitrov commented on your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:12:00.000Z")
    },

    // =====================================================
    // REACTIONS TO POST 3
    // =====================================================

    {
        authorIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        postIdentity: "6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507",
        content: "Mariya Georgieva liked your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:13:00.000Z")
    },
    {
        authorIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        postIdentity: "6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507",
        content: "Petur Petrov disliked your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:14:00.000Z")
    },
    {
        authorIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        postIdentity: "6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507",
        content: "Konstantin Dimitrov reacted with HAHA to your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:15:00.000Z")
    },
    {
        authorIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        postIdentity: "6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507",
        content: "Iliya Iliev reacted with ANGRY to your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:16:00.000Z")
    },

    // =====================================================
    // COMMENTS ON POST 4
    // =====================================================

    {
        authorIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        postIdentity: "2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb",
        content: "Angel Angelov commented on your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:16:00.000Z")
    },
    {
        authorIdentity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        postIdentity: "2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb",
        content: "Iliya Iliev commented on your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:17:00.000Z")
    },

    // =====================================================
    // REACTIONS TO POST 4
    // =====================================================

    {
        authorIdentity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        postIdentity: "2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb",
        content: "Angel Angelov liked your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:18:00.000Z")
    },
    {
        authorIdentity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        postIdentity: "2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb",
        content: "Georgi Georgiev disliked your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:19:00.000Z")
    },
    {
        authorIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        postIdentity: "2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb",
        content: "Tanya Petrova reacted with HAHA to your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:20:00.000Z")
    },
    {
        authorIdentity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        postIdentity: "2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb",
        content: "Stoyan Stoyanov reacted with ANGRY to your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:21:00.000Z")
    },

    // =====================================================
    // COMMENT ON POST 5
    // =====================================================

    {
        authorIdentity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        postIdentity: "0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9",
        content: "Tanya Petrova commented on your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:21:00.000Z")
    },

    // =====================================================
    // REACTIONS TO POST 5
    // =====================================================

    {
        authorIdentity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        postIdentity: "0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9",
        content: "Victoriya Petrova liked your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:22:00.000Z")
    },
    {
        authorIdentity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        postIdentity: "0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9",
        content: "Mariya Georgieva disliked your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:23:00.000Z")
    },
    {
        authorIdentity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        postIdentity: "0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9",
        content: "Petur Petrov reacted with HAHA to your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:24:00.000Z")
    },
    {
        authorIdentity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        postIdentity: "0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9",
        content: "Konstantin Dimitrov reacted with ANGRY to your post.",
        seen: false,
        createdAt: ISODate("2026-07-28T10:25:00.000Z")
    }
]);

console.log("*** Notifications imported ***");