use("admin");
db.auth("rootuser", "rootpass");
console.log("*** Authentication with root user ***");

use("storage");
db.createCollection("profiles");
db.createCollection("plugins");
db.createCollection("plugin_versions");
db.createCollection("groups");
db.createCollection("posts");
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
        profilePictureUrl: "profile/0e1f7c5f7b9e92df58bbd6d9a4c7a7d5be71bbdc40d5d3cbf7dd1b7c3fd8e4b5/profile.webp",
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

db.groups.insertMany([
    {
        identity: "c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519",
        imageUrl: "group/c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519.webp"
    },
    {
        identity: "a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91",
        imageUrl: "group/a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91.webp"
    },
    {
        identity: "4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55",
        imageUrl: "group/4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55.webp"
    },
    {
        identity: "a4199f65e484c1df316f2581513ceae75698b372485151c006d63fda5412cc7b2b051827759b25694969669c60ff8811b4e58b67660a183218bd5e1a2dba6fa4",
        imageUrl: "group/a4199f65e484c1df316f2581513ceae75698b372485151c006d63fda5412cc7b2b051827759b25694969669c60ff8811b4e58b67660a183218bd5e1a2dba6fa4.webp"
    },
    {
        identity: "cd043e97409ff96e355bded695ab414c97d55c748f18bf71c3ffbce80905148cd63d6b629c5f02a98e47c23ae584129d71d2be544dfc4f7fb2b7a3d6df9fb38b",
        imageUrl: "group/cd043e97409ff96e355bded695ab414c97d55c748f18bf71c3ffbce80905148cd63d6b629c5f02a98e47c23ae584129d71d2be544dfc4f7fb2b7a3d6df9fb38b.webp"
    },
    {
        identity: "b9e55013d3ad4fdc45b9a0766d9f72c10c6e8430097995b4ba9facc54fcaddf4c46c04693e1354fbd212a7c07b53b0d44808ddce87ae36a79268e2354936feba",
        imageUrl: "group/b9e55013d3ad4fdc45b9a0766d9f72c10c6e8430097995b4ba9facc54fcaddf4c46c04693e1354fbd212a7c07b53b0d44808ddce87ae36a79268e2354936feba.webp"
    }
]);

db.posts.insertMany([
    {
        identity: "afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72",
        imageUrl: "posts/afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72.webp"
    },
    {
        identity: "2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb",
        imageUrl: "posts/2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb.webp"
    },
    {
        identity: "a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f",
        imageUrl: "posts/a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f.webp"
    },
    {
        identity: "89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e",
        imageUrl: "posts/89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e.webp"
    },
    {
        identity: "b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0",
        imageUrl: "posts/b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0.webp"
    },
    {
        identity: "900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4",
        imageUrl: "posts/900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4.webp"
    },
    {
        identity: "6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065",
        imageUrl: "posts/6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065.webp"
    },
    {
        identity: "8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4",
        imageUrl: "posts/8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4.webp"
    },
    {
        identity: "695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c",
        imageUrl: "posts/695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c.webp"
    },
    {
        identity: "1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d",
        imageUrl: "posts/1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d.webp"
    },
    {
        identity: "91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c",
        imageUrl: "posts/91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c.webp"
    }
]);

db.plugin_versions.insertMany([
    {
        identity: "afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72",
        contentUrl: "posts/afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72.webp"
    },
    {
        identity: "2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb",
        contentUrl: "posts/2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb.webp"
    }
]);

console.log("*** Groups inserted successfully ***");