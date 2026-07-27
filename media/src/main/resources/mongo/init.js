use("admin");
db.auth("rootuser", "rootpass");
console.log("*** Authentication with root user ***");

use("storage");
db.createCollection("profiles");
db.createCollection("plugins");
db.createCollection("groups");
console.log("*** Collection created ***");

db.profiles.insertMany([
    {
        identity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
        profilePictureUrl: "profile/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/profile.webp",
        backgroundPictureUrl: "background/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/background.webp",
        albumPictureUrls: [
            {
                url: "album/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/album_1.webp",
                uploadedOn: new Date("2026-06-01T09:15:00Z")
            },
            {
                url: "album/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/album_2.webp",
                uploadedOn: new Date("2026-06-05T11:30:00Z")
            },
            {
                url: "album/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/album_3.webp",
                uploadedOn: new Date("2026-06-09T14:45:00Z")
            },
            {
                url: "album/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/album_4.webp",
                uploadedOn: new Date("2026-06-14T08:20:00Z")
            },
            {
                url: "album/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/album_5.webp",
                uploadedOn: new Date("2026-06-18T16:10:00Z")
            },
            {
                url: "album/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/album_6.webp",
                uploadedOn: new Date("2026-06-23T10:05:00Z")
            },
            {
                url: "album/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/album_7.webp",
                uploadedOn: new Date("2026-06-28T13:40:00Z")
            },
            {
                url: "album/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/album_8.webp",
                uploadedOn: new Date("2026-07-02T09:50:00Z")
            },
            {
                url: "album/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/album_9.webp",
                uploadedOn: new Date("2026-07-06T15:25:00Z")
            },
            {
                url: "album/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/album_10.webp",
                uploadedOn: new Date("2026-07-10T12:35:00Z")
            },
            {
                url: "album/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/album_11.webp",
                uploadedOn: new Date("2026-07-15T17:05:00Z")
            },
            {
                url: "album/429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b/album_12.webp",
                uploadedOn: new Date("2026-07-20T10:55:00Z")
            }
        ]
    },
    {
        identity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
        profilePictureUrl: "profile/9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91/profile.webp",
    },
    {
        identity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        profilePictureUrl: "profile/771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551/profile.webp",
    },
    {
        identity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        profilePictureUrl: "profile/788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627/profile.webp",
    },
    {
        identity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        profilePictureUrl: "profile/d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8/profile.webp",
    },
    {
        identity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        profilePictureUrl: "profile/8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f/profile.webp",
    },
    {
        identity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        profilePictureUrl: "profile/c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85/profile.webp",
    },
    {
        identity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        profilePictureUrl: "profile/519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71/profile.webp",
    },
    {
        identity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        profilePictureUrl: "profile/a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6/profile.webp",
    },
    {
        identity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        profilePictureUrl: "profile/31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93/profile.webp",
    },
    {
        identity: "67c80c58573c12562067629782b72c455fbd8ab06bbf8dfbd4bc20331d1cbedf",
        profilePictureUrl: "profile/67c80c58573c12562067629782b72c455fbd8ab06bbf8dfbd4bc20331d1cbedf/profile.webp",
    },
    {
        identity: "41d52bee906b4347466558329fb7a6cbc24b5ab0a5f6c58e2e614decc764fab3",
        profilePictureUrl: "profile/41d52bee906b4347466558329fb7a6cbc24b5ab0a5f6c58e2e614decc764fab3/profile.webp",
    },
    {
        identity: "cda07e665379ec023b0577605bfd6f91770fe997d72b4e7d3b90e17c29a1ad9e",
        profilePictureUrl: "profile/cda07e665379ec023b0577605bfd6f91770fe997d72b4e7d3b90e17c29a1ad9e/profile.webp",
    },
    {
        identity: "8b94a3f1bdb9d79a74bb71d933c6d0dd6c4dd08f75b89d1cbfcdf462cb0b7fd2",
        profilePictureUrl: "profile/8b94a3f1bdb9d79a74bb71d933c6d0dd6c4dd08f75b89d1cbfcdf462cb0b7fd2/profile.webp",
    },
    {
        identity: "0e1f7c5f7b9e92df58bbd6d9a4c7a7d5be71bbdc40d5d3cbf7dd1b7c3fd8e4b5",
        profilePictureUrl: "profile/0e1f7c5f7b9e92df58bbd6d9a4c7a7d5be71bbdc40d5d3cbf7dd1b7c3fd8e4b5/profile.web",
    },
    {
        identity: "3d9abcb92d1d574ef0d0d49b0cb62cb6d6fd6bb49d82f8a3a8e4a7a0d3aefb11",
        profilePictureUrl: "profile/3d9abcb92d1d574ef0d0d49b0cb62cb6d6fd6bb49d82f8a3a8e4a7a0d3aefb11/profile.webp",
    },
    {
        identity: "f1bc296565b36ec1932fd0b0889fb94f3fc14f56f1141f1327fd4f58cfa6a231",
        profilePictureUrl: "profile/f1bc296565b36ec1932fd0b0889fb94f3fc14f56f1141f1327fd4f58cfa6a231/profile.webp",
    },
    {
        identity: "991f49289c5745bbeba353af157a40c48edfed061ead6d417160d9b89a54baa6",
        profilePictureUrl: "profile/991f49289c5745bbeba353af157a40c48edfed061ead6d417160d9b89a54baa6/profile.webp",
    },
    {
        identity: "aad12f3aa20775b329a00d0f0ccba97dafbc72fd925163e2e26f5ee91ec6b2cd",
        profilePictureUrl: "profile/aad12f3aa20775b329a00d0f0ccba97dafbc72fd925163e2e26f5ee91ec6b2cd/profile.webp",
    }
]);

console.log("*** Profiles inserted successfully ***");