BEGIN;

-- =========================================================
-- Groups
-- =========================================================

INSERT INTO groups (
    id,
    identity,
    name,
    description
)
VALUES
    (
        1,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        'VTU Students',
        'A community for students of Veliko Tarnovo University.'
    ),
    (
        2,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        'Java Developers',
        'A community for Java and Spring developers.'
    ),
    (
        3,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        'Master Thesis Projects',
        'A community for master thesis projects.'
    ),
    (
        4,
        'a4199f65e484c1df316f2581513ceae75698b372485151c006d63fda5412cc7b2b051827759b25694969669c60ff8811b4e58b67660a183218bd5e1a2dba6fa4',
        'Cloud Computing',
        'A community for cloud technologies, AWS, Azure and distributed systems.'
    ),
    (
        5,
        'b9e55013d3ad4fdc45b9a0766d9f72c10c6e8430097995b4ba9facc54fcaddf4c46c04693e1354fbd212a7c07b53b0d44808ddce87ae36a79268e2354936feba',
        'Photography Enthusiasts',
        'A community for photographers to share photos, techniques and ideas.'
    ),
    (
        6,
        'cd043e97409ff96e355bded695ab414c97d55c748f18bf71c3ffbce80905148cd63d6b629c5f02a98e47c23ae584129d71d2be544dfc4f7fb2b7a3d6df9fb38b',
        'Travel Community',
        'A community for sharing travel experiences, destinations and recommendations.'
    );

-- =========================================================
-- VTU Students members
-- =========================================================

INSERT INTO group_members (
    id,
    group_identity,
    profile_identity
)
VALUES
    (
        1,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91'
    ),
    (
        2,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551'
    ),
    (
        3,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627'
    ),
    (
        4,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8'
    ),
    (
        5,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f'
    ),
    (
        6,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85'
    ),
    (
        7,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71'
    ),
    (
        8,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6'
    ),
    (
        9,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93'
    ),
    (
        10,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        'f1bc296565b36ec1932fd0b0889fb94f3fc14f56f1141f1327fd4f58cfa6a231'
    ),
    (
        11,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        '991f49289c5745bbeba353af157a40c48edfed061ead6d417160d9b89a54baa6'
    ),
    (
        12,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        'aad12f3aa20775b329a00d0f0ccba97dafbc72fd925163e2e26f5ee91ec6b2cd'
    ),
    (
        13,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b'
    );


-- =========================================================
-- Java Developers members
-- =========================================================

INSERT INTO group_members (
    id,
    group_identity,
    profile_identity
)
VALUES
    (
        14,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91'
    ),
    (
        15,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551'
    ),
    (
        16,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627'
    ),
    (
        17,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8'
    ),
    (
        18,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f'
    ),
    (
        19,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85'
    ),
    (
        20,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71'
    ),
    (
        21,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6'
    ),
    (
        22,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93'
    ),
    (
        23,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        'f1bc296565b36ec1932fd0b0889fb94f3fc14f56f1141f1327fd4f58cfa6a231'
    ),
    (
        24,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        '991f49289c5745bbeba353af157a40c48edfed061ead6d417160d9b89a54baa6'
    ),
    (
        25,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        'aad12f3aa20775b329a00d0f0ccba97dafbc72fd925163e2e26f5ee91ec6b2cd'
    ),
    (
        26,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b'
    );


-- =========================================================
-- Master Thesis Projects members
-- =========================================================

INSERT INTO group_members (
    id,
    group_identity,
    profile_identity
)
VALUES
    (
        27,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91'
    ),
    (
        28,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551'
    ),
    (
        29,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627'
    ),
    (
        30,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8'
    ),
    (
        31,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f'
    ),
    (
        32,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85'
    ),
    (
        33,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71'
    ),
    (
        34,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6'
    ),
    (
        35,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93'
    ),
    (
        36,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        'f1bc296565b36ec1932fd0b0889fb94f3fc14f56f1141f1327fd4f58cfa6a231'
    ),
    (
        37,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        '991f49289c5745bbeba353af157a40c48edfed061ead6d417160d9b89a54baa6'
    ),
    (
        38,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        'aad12f3aa20775b329a00d0f0ccba97dafbc72fd925163e2e26f5ee91ec6b2cd'
    ),
    (
        39,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b'
    );


-- =========================================================
-- Pending join requests
-- =========================================================

INSERT INTO group_join_requests (
    id,
    group_identity,
    profile_identity,
    status
)
VALUES
    (
        1,
        'c618b165b455a1bbb4bff8574ec56f70d49f47c901b154493417a2b02ea825c26cb0bd592298995fb3f5d61b7367ee5d9051793448ef3d258fc415fa278ed519',
        '8b94a3f1bdb9d79a74bb71d933c6d0dd6c4dd08f75b89d1cbfcdf462cb0b7fd2',
        'PENDING'
    ),
    (
        2,
        'a503cd186622eaf31aebb561f159476cafcebadbc3e6d019b9b2eb85a6d4215600690efe6ff26247795ecee7af333bf45f607812065096e6888977d544e8ad91',
        '0e1f7c5f7b9e92df58bbd6d9a4c7a7d5be71bbdc40d5d3cbf7dd1b7c3fd8e4b5',
        'PENDING'
    ),
    (
        3,
        '4b219329051054e53ab7960926d09ea7bbb1177a263706a1eead03c46c2c57fb93e4fe23860f153198bbc1eb754adc0a44c704d35a722a097d43870d315a9a55',
        '3d9abcb92d1d574ef0d0d49b0cb62cb6d6fd6bb49d82f8a3a8e4a7a0d3aefb11',
        'PENDING'
    );

COMMIT;