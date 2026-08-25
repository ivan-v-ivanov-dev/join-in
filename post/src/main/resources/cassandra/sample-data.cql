USE post_service;

-- =====================================================
-- POST 1: Text-only post
-- =====================================================

INSERT INTO posts_by_identity (post_identity,
                               author_identity,
                               content,
                               has_text,
                               has_image,
                               has_video,
                               is_poll,
                               created_at)
VALUES ('5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Hello everyone! I am currently working on a new social network built with Java, Spring Boot and Cassandra.',
        true,
        false,
        false,
        false,
        '2026-07-28T10:00:00.000Z');

INSERT INTO posts_by_author (author_identity,
                             created_at,
                             post_identity,
                             content,
                             has_text,
                             has_image,
                             has_video,
                             is_poll)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-07-28T10:00:00.000Z',
        '5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd',
        'Hello everyone! I am currently working on a new social network built with Java, Spring Boot and Cassandra.',
        true,
        false,
        false,
        false);


INSERT INTO feed_by_user (user_identity,
                          created_at,
                          post_identity,
                          author_identity,
                          content,
                          has_text,
                          has_image,
                          has_video,
                          is_poll)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-07-28T10:00:00.000Z',
        '5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Hello everyone! I am currently working on a new social network built with Java, Spring Boot and Cassandra.',
        true,
        false,
        false,
        false);


-- =====================================================
-- POST 2: Text and image
-- =====================================================

INSERT INTO posts_by_identity (post_identity,
                               author_identity,
                               content,
                               has_text,
                               has_image,
                               has_video,
                               is_poll,
                               image_identity,
                               created_at)
VALUES ('afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Here is a preview of the new feed page of my social network.',
        true,
        true,
        false,
        false,
        'image-feed-preview-002',
        '2026-07-28T10:05:00.000Z');

INSERT INTO posts_by_author (author_identity,
                             created_at,
                             post_identity,
                             content,
                             has_text,
                             has_image,
                             has_video,
                             is_poll,
                             image_identity)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-07-28T10:05:00.000Z',
        'afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72',
        'Here is a preview of the new feed page of my social network.',
        true,
        true,
        false,
        false,
        'image-feed-preview-002');


INSERT INTO feed_by_user (user_identity,
                          created_at,
                          post_identity,
                          author_identity,
                          content,
                          has_text,
                          has_image,
                          has_video,
                          is_poll,
                          image_identity)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-07-28T10:05:00.000Z',
        'afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Here is a preview of the new feed page of my social network.',
        true,
        true,
        false,
        false,
        'image-feed-preview-002');


-- =====================================================
-- POST 3: Text and YouTube video
-- =====================================================

INSERT INTO posts_by_identity (post_identity,
                               author_identity,
                               content,
                               has_text,
                               has_image,
                               has_video,
                               is_poll,
                               youtube_url,
                               created_at)
VALUES ('6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'This video provides a useful introduction to Java programming.',
        true,
        false,
        true,
        false,
        'https://www.youtube.com/watch?v=grEKMHGYyns',
        '2026-07-28T10:10:00.000Z');

INSERT INTO posts_by_author (author_identity,
                             created_at,
                             post_identity,
                             content,
                             has_text,
                             has_image,
                             has_video,
                             is_poll,
                             youtube_url)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-07-28T10:10:00.000Z',
        '6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507',
        'This video provides a useful introduction to Java programming.',
        true,
        false,
        true,
        false,
        'https://www.youtube.com/watch?v=grEKMHGYyns');


INSERT INTO feed_by_user (user_identity,
                          created_at,
                          post_identity,
                          author_identity,
                          content,
                          has_text,
                          has_image,
                          has_video,
                          is_poll,
                          youtube_url)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-07-28T10:10:00.000Z',
        '6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'This video provides a useful introduction to Java programming.',
        true,
        false,
        true,
        false,
        'https://www.youtube.com/watch?v=grEKMHGYyns');


-- =====================================================
-- POST 4: Image-only post
-- =====================================================

INSERT INTO posts_by_identity (post_identity,
                               author_identity,
                               has_text,
                               has_image,
                               has_video,
                               is_poll,
                               image_identity,
                               created_at)
VALUES ('2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        false,
        true,
        false,
        false,
        'image-workspace-004',
        '2026-07-28T10:15:00.000Z');

INSERT INTO posts_by_author (author_identity,
                             created_at,
                             post_identity,
                             has_text,
                             has_image,
                             has_video,
                             is_poll,
                             image_identity)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-07-28T10:15:00.000Z',
        '2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb',
        false,
        true,
        false,
        false,
        'image-workspace-004');


INSERT INTO feed_by_user (user_identity,
                          created_at,
                          post_identity,
                          author_identity,
                          has_text,
                          has_image,
                          has_video,
                          is_poll,
                          image_identity)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-07-28T10:15:00.000Z',
        '2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        false,
        true,
        false,
        false,
        'image-workspace-004');


-- =====================================================
-- POST 5: Poll
-- =====================================================

INSERT INTO posts_by_identity (post_identity,
                               author_identity,
                               has_text,
                               has_image,
                               has_video,
                               is_poll,
                               poll_question,
                               poll_options,
                               created_at)
VALUES ('0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        false,
        false,
        false,
        true,
        'Which is your favourite programming language?',
        [
            {
                option_identity: 'poll-option-java',
                option_text: 'Java',
                vote_count: 12
                },
            {
                option_identity: 'poll-option-python',
                option_text: 'Python',
                vote_count: 9
                },
            {
                option_identity: 'poll-option-javascript',
                option_text: 'JavaScript',
                vote_count: 6
                },
            {
                option_identity: 'poll-option-csharp',
                option_text: 'C#',
                vote_count: 4
                }
            ],
        '2026-07-28T10:20:00.000Z');

INSERT INTO posts_by_author (author_identity,
                             created_at,
                             post_identity,
                             has_text,
                             has_image,
                             has_video,
                             is_poll,
                             poll_question,
                             poll_options)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-07-28T10:20:00.000Z',
        '0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9',
        false,
        false,
        false,
        true,
        'Which is your favourite programming language?',
        [
            {
                option_identity: 'poll-option-java',
                option_text: 'Java',
                vote_count: 12
                },
            {
                option_identity: 'poll-option-python',
                option_text: 'Python',
                vote_count: 9
                },
            {
                option_identity: 'poll-option-javascript',
                option_text: 'JavaScript',
                vote_count: 6
                },
            {
                option_identity: 'poll-option-csharp',
                option_text: 'C#',
                vote_count: 4
                }
            ]);


INSERT INTO feed_by_user (user_identity,
                          created_at,
                          post_identity,
                          author_identity,
                          has_text,
                          has_image,
                          has_video,
                          is_poll,
                          poll_question,
                          poll_options)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-07-28T10:20:00.000Z',
        '0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        false,
        false,
        false,
        true,
        'Which is your favourite programming language?',
        [
            {
                option_identity: 'poll-option-java',
                option_text: 'Java',
                vote_count: 12
                },
            {
                option_identity: 'poll-option-python',
                option_text: 'Python',
                vote_count: 9
                },
            {
                option_identity: 'poll-option-javascript',
                option_text: 'JavaScript',
                vote_count: 6
                },
            {
                option_identity: 'poll-option-csharp',
                option_text: 'C#',
                vote_count: 4
                }
            ]);


-- =====================================================
-- COMMENTS
-- One comment for each friend profile
-- comment_identity values are SHA-512 checksums
-- =====================================================

-- Petur | SHA-512("comment-petur-001")
INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd',
        '2026-07-28T10:01:00.000Z',
        '745e7ba3e356a15eee31e7c42ca83e9eab296b6ad5a13c7afee4a3779a18c1c2ea5fa65b27638aabbc50f8bc71be59ae3243db17c66ea11f63555b7e61767cad',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        'This sounds like an interesting project!');

-- Georgi | SHA-512("comment-georgi-002")
INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd',
        '2026-07-28T10:02:00.000Z',
        '06f6aece1bcab67f763945239186fea8e0147ebc61c3fc0ed80b6ff30d911d3fd90bbfc96360f7267fa24725e208c154c15feeeae2e69f829cd411da07db932e',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        'Java and Cassandra are a great combination for this type of application.');

-- Stoyan | SHA-512("comment-stoyan-003")
INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72',
        '2026-07-28T10:06:00.000Z',
        '8582e9cce74f9acc1f1806e9afcdc6b8af1e62ffeeefbd1b15d642b7ae971b2b7f3fde60d03e62d5f0c9b3f72e7b3628ac8d7226b67f1a083404e6aa25700d04',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        'The feed page looks clean and easy to use.');

-- Victoriya | SHA-512("comment-victoriya-004")
INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72',
        '2026-07-28T10:07:00.000Z',
        '03c23500a20aac85c64be572c57c5d5a83b387fb0151f801c831011c2eb7ae7b03c630d95cdacc2e87958add57683626cf2db55787c16b508b3cc6d74fafcae3',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        'I like the layout and the image preview.');

-- Mariya | SHA-512("comment-mariya-005")
INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507',
        '2026-07-28T10:11:00.000Z',
        'ae64b2a9de13224d1b0ac0758d7b9b7cdb455deb72d8f162bd09947d220963786ef3e8b5a80c17fea1b34386ff93d4c7bc9f57e1a3a2e4be4a9623dab7792481',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        'Thanks for sharing this video.');

-- Konstantin | SHA-512("comment-konstantin-006")
INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507',
        '2026-07-28T10:12:00.000Z',
        '9c4f65b0b6d677f4e586f7d43479bfe3b30822e00f9df3ff360e560b8103a95ef79ca972abb4a00db98abb7ef24ac7b8fed3992e70b590118e570c49e264573f',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        'This is a useful introduction for Java beginners.');

-- Angel | SHA-512("comment-angel-007")
INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb',
        '2026-07-28T10:16:00.000Z',
        'f0b297e834095c0425aa0e41fda086e2c56eaff036a113f0ff02878bc76cfb5dd5a0b1b0189dda167e9beae1839f8e32c1909b7f994760fce44f3e6ca5ddd6be',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        'Great development setup!');

-- Iliya | SHA-512("comment-iliya-008")
INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb',
        '2026-07-28T10:17:00.000Z',
        '86be8ae0303bf1cb58a391e0cf28d8d297d1147ab7e52501024cc7d94907bbb3608e9d983ae42ab7ca18afbde4286b811a4e22d7129d0745281be6e44ae36c9c',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        'The workspace looks very productive.');

-- Tanya | SHA-512("comment-tanya-009")
INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9',
        '2026-07-28T10:21:00.000Z',
        '40cb549c685e99214bdc012cbbbd4590019cb60639e9ffc3e0d2676ec4ef91eb47a195290b7f069a90199b81570676edd12554ac4084d77aae7e2f650ada36de',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93',
        'Java is my favourite because of Spring Boot.');


-- =====================================================
-- COMMENTS BY AUTHOR
-- Duplicated from comments_by_post for queries by user
-- =====================================================

-- Petur
INSERT INTO comments_by_author (
    author_identity,
    created_at,
    comment_identity,
    post_identity,
    content
)
VALUES (
           '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
           '2026-07-28T10:01:00.000Z',
           '745e7ba3e356a15eee31e7c42ca83e9eab296b6ad5a13c7afee4a3779a18c1c2ea5fa65b27638aabbc50f8bc71be59ae3243db17c66ea11f63555b7e61767cad',
           '5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd',
           'This sounds like an interesting project!'
       );


-- Georgi
INSERT INTO comments_by_author (
    author_identity,
    created_at,
    comment_identity,
    post_identity,
    content
)
VALUES (
           '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
           '2026-07-28T10:02:00.000Z',
           '06f6aece1bcab67f763945239186fea8e0147ebc61c3fc0ed80b6ff30d911d3fd90bbfc96360f7267fa24725e208c154c15feeeae2e69f829cd411da07db932e',
           '5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd',
           'Java and Cassandra are a great combination for this type of application.'
       );


-- Stoyan
INSERT INTO comments_by_author (
    author_identity,
    created_at,
    comment_identity,
    post_identity,
    content
)
VALUES (
           '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
           '2026-07-28T10:06:00.000Z',
           '8582e9cce74f9acc1f1806e9afcdc6b8af1e62ffeeefbd1b15d642b7ae971b2b7f3fde60d03e62d5f0c9b3f72e7b3628ac8d7226b67f1a083404e6aa25700d04',
           'afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72',
           'The feed page looks clean and easy to use.'
       );


-- Victoriya
INSERT INTO comments_by_author (
    author_identity,
    created_at,
    comment_identity,
    post_identity,
    content
)
VALUES (
           'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
           '2026-07-28T10:07:00.000Z',
           '03c23500a20aac85c64be572c57c5d5a83b387fb0151f801c831011c2eb7ae7b03c630d95cdacc2e87958add57683626cf2db55787c16b508b3cc6d74fafcae3',
           'afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72',
           'I like the layout and the image preview.'
       );


-- Mariya
INSERT INTO comments_by_author (
    author_identity,
    created_at,
    comment_identity,
    post_identity,
    content
)
VALUES (
           '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
           '2026-07-28T10:11:00.000Z',
           'ae64b2a9de13224d1b0ac0758d7b9b7cdb455deb72d8f162bd09947d220963786ef3e8b5a80c17fea1b34386ff93d4c7bc9f57e1a3a2e4be4a9623dab7792481',
           '6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507',
           'Thanks for sharing this video.'
       );


-- Konstantin
INSERT INTO comments_by_author (
    author_identity,
    created_at,
    comment_identity,
    post_identity,
    content
)
VALUES (
           'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
           '2026-07-28T10:12:00.000Z',
           '9c4f65b0b6d677f4e586f7d43479bfe3b30822e00f9df3ff360e560b8103a95ef79ca972abb4a00db98abb7ef24ac7b8fed3992e70b590118e570c49e264573f',
           '6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507',
           'This is a useful introduction for Java beginners.'
       );


-- Angel
INSERT INTO comments_by_author (
    author_identity,
    created_at,
    comment_identity,
    post_identity,
    content
)
VALUES (
           '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
           '2026-07-28T10:16:00.000Z',
           'f0b297e834095c0425aa0e41fda086e2c56eaff036a113f0ff02878bc76cfb5dd5a0b1b0189dda167e9beae1839f8e32c1909b7f994760fce44f3e6ca5ddd6be',
           '2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb',
           'Great development setup!'
       );


-- Iliya
INSERT INTO comments_by_author (
    author_identity,
    created_at,
    comment_identity,
    post_identity,
    content
)
VALUES (
           'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
           '2026-07-28T10:17:00.000Z',
           '86be8ae0303bf1cb58a391e0cf28d8d297d1147ab7e52501024cc7d94907bbb3608e9d983ae42ab7ca18afbde4286b811a4e22d7129d0745281be6e44ae36c9c',
           '2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb',
           'The workspace looks very productive.'
       );


-- Tanya
INSERT INTO comments_by_author (
    author_identity,
    created_at,
    comment_identity,
    post_identity,
    content
)
VALUES (
           '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93',
           '2026-07-28T10:21:00.000Z',
           '40cb549c685e99214bdc012cbbbd4590019cb60639e9ffc3e0d2676ec4ef91eb47a195290b7f069a90199b81570676edd12554ac4084d77aae7e2f650ada36de',
           '0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9',
           'Java is my favourite because of Spring Boot.'
       );


-- FEED Posts

-- =====================================================
-- POSTS FOR PETUR
-- =====================================================

-- Petur post 1: text
-- post_identity: 7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               created_at)
VALUES ('7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        'Started refactoring one of my backend services today. The code is already much easier to maintain.', true,
        false, false, false, '2026-07-29T09:00:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll)
VALUES ('9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91', '2026-07-29T09:00:00.000Z',
        '7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573',
        'Started refactoring one of my backend services today. The code is already much easier to maintain.', true,
        false, false, false);

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T09:00:00.000Z',
        '7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        'Started refactoring one of my backend services today. The code is already much easier to maintain.', true,
        false, false, false);

-- Comment 1 on Petur post 1 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573',
        '2026-07-29T09:01:00.000Z',
        'e4978ad7b95dd9acfbebf3454d3fd115860f2fce22c26ef1a93a95edc0bd43fb4329e4d0428dd0a993fcb054e72b940bcfa684a606f0809e5308fb608bf0dbb6',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Nice update. I like how this is progressing.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T09:01:00.000Z',
        'e4978ad7b95dd9acfbebf3454d3fd115860f2fce22c26ef1a93a95edc0bd43fb4329e4d0428dd0a993fcb054e72b940bcfa684a606f0809e5308fb608bf0dbb6',
        '7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573',
        'Nice update. I like how this is progressing.');

-- Comment 2 on Petur post 1 by Stoyan
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573',
        '2026-07-29T09:02:00.000Z',
        '3dab9e9191c26f3923b5ef2a9fad15754fd2d395b092166a83be0c35403e2e55d009cbb02812fa346345524c599ac8c3fdbb0e98792f60ac0e725fc22e474565',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        'This looks really good. Thanks for sharing it.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627', '2026-07-29T09:02:00.000Z',
        '3dab9e9191c26f3923b5ef2a9fad15754fd2d395b092166a83be0c35403e2e55d009cbb02812fa346345524c599ac8c3fdbb0e98792f60ac0e725fc22e474565',
        '7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573',
        'This looks really good. Thanks for sharing it.');

-- Comment 3 on Petur post 1 by Konstantin
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573',
        '2026-07-29T09:03:00.000Z',
        '9dcd4d50c689b3062756c816c5f4a601873d6f2ac0d64d1afdadcb586eba36790565070c8b53047861b92852e6f4c550daee29ea73d7e61c4987fc5091b7faa1',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        'Interesting idea. I would like to see the next version.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85', '2026-07-29T09:03:00.000Z',
        '9dcd4d50c689b3062756c816c5f4a601873d6f2ac0d64d1afdadcb586eba36790565070c8b53047861b92852e6f4c550daee29ea73d7e61c4987fc5091b7faa1',
        '7e72ef10d4780ea9f48cce75ccb788abed35372146cd60390519c057681e66000d9c4ed3d92c865047615cc13692a2149fa848cef318f4bada0220370ff97573',
        'Interesting idea. I would like to see the next version.');

-- Petur post 2: image + text
-- post_identity: a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f
-- image_identity (random SHA-512): 847727dc2ad05f4b0dce231fd3ce9208fbc8313fbc3692aa1b88abc08cbab02fd6e6b0bafca13c25e2289c399ad9fa06f71c1fa86dd11cf79cf24b9e1bb8e580

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               image_identity, created_at)
VALUES ('a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        'A small preview of my development setup after reorganising the workspace.', true, true, false, false,
        '847727dc2ad05f4b0dce231fd3ce9208fbc8313fbc3692aa1b88abc08cbab02fd6e6b0bafca13c25e2289c399ad9fa06f71c1fa86dd11cf79cf24b9e1bb8e580',
        '2026-07-29T09:15:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll, image_identity)
VALUES ('9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91', '2026-07-29T09:15:00.000Z',
        'a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f',
        'A small preview of my development setup after reorganising the workspace.', true, true, false, false,
        '847727dc2ad05f4b0dce231fd3ce9208fbc8313fbc3692aa1b88abc08cbab02fd6e6b0bafca13c25e2289c399ad9fa06f71c1fa86dd11cf79cf24b9e1bb8e580');

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll, image_identity)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T09:15:00.000Z',
        'a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        'A small preview of my development setup after reorganising the workspace.', true, true, false, false,
        '847727dc2ad05f4b0dce231fd3ce9208fbc8313fbc3692aa1b88abc08cbab02fd6e6b0bafca13c25e2289c399ad9fa06f71c1fa86dd11cf79cf24b9e1bb8e580');

-- Comment 1 on Petur post 2 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f',
        '2026-07-29T09:16:00.000Z',
        'fcbb713b71de49d0be9aae64de47b92d5eeaa9c7367065d88ec6851bfaa8304ae1ee3219652ba8720b5c79a185172b9635bf5fb323d365f3bd7b5cd023c0b4ce',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Great work. The project is becoming more complete.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T09:16:00.000Z',
        'fcbb713b71de49d0be9aae64de47b92d5eeaa9c7367065d88ec6851bfaa8304ae1ee3219652ba8720b5c79a185172b9635bf5fb323d365f3bd7b5cd023c0b4ce',
        'a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f',
        'Great work. The project is becoming more complete.');

-- Comment 2 on Petur post 2 by Victoriya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f',
        '2026-07-29T09:17:00.000Z',
        '2e1301c218ccc8b6b03a630c271ff825f57c365398de8e69ecce39aad94b1bd5bfc8b3b39d35215f5433423b6bd74732e56aaf2ff6caad4d575937847ffa456f',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        'This is a useful example and the result looks clean.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8', '2026-07-29T09:17:00.000Z',
        '2e1301c218ccc8b6b03a630c271ff825f57c365398de8e69ecce39aad94b1bd5bfc8b3b39d35215f5433423b6bd74732e56aaf2ff6caad4d575937847ffa456f',
        'a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f',
        'This is a useful example and the result looks clean.');

-- Comment 3 on Petur post 2 by Angel
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f',
        '2026-07-29T09:18:00.000Z',
        '0580547e79437450dec689ece7c64956f848112854716ef809dc814edd896c0820193ff814a11e721a9cb9e1db9618bbd8e613db91f53d7c964e74cac93d074f',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        'Good progress. Keep us updated when you add more features.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71', '2026-07-29T09:18:00.000Z',
        '0580547e79437450dec689ece7c64956f848112854716ef809dc814edd896c0820193ff814a11e721a9cb9e1db9618bbd8e613db91f53d7c964e74cac93d074f',
        'a78b1677ee7bcb23ce0265c6954399817e95508e065a7c89980549c0fd2bc807d63598937cf4420f614929c540d0309738035c69babe146facdc4be31533770f',
        'Good progress. Keep us updated when you add more features.');


-- =====================================================
-- POSTS FOR GEORGI
-- =====================================================

-- Georgi post 1: image
-- post_identity: 89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e
-- image_identity (random SHA-512): 350e6eedc3a5cbd98103471411128969b311ac34ff6d267e60990ea8d1f5e9b10a5270609fbcd873ea8b675c97e257423866d561f2d8e7540730e1179f4dca88

INSERT INTO posts_by_identity (post_identity, author_identity, has_text, has_image, has_video, is_poll, image_identity,
                               created_at)
VALUES ('89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551', false, true, false, false,
        '350e6eedc3a5cbd98103471411128969b311ac34ff6d267e60990ea8d1f5e9b10a5270609fbcd873ea8b675c97e257423866d561f2d8e7540730e1179f4dca88',
        '2026-07-29T09:30:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, has_text, has_image, has_video, is_poll,
                             image_identity)
VALUES ('771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551', '2026-07-29T09:30:00.000Z',
        '89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e',
        false, true, false, false,
        '350e6eedc3a5cbd98103471411128969b311ac34ff6d267e60990ea8d1f5e9b10a5270609fbcd873ea8b675c97e257423866d561f2d8e7540730e1179f4dca88');

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, has_text, has_image, has_video,
                          is_poll, image_identity)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T09:30:00.000Z',
        '89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551', false, true, false, false,
        '350e6eedc3a5cbd98103471411128969b311ac34ff6d267e60990ea8d1f5e9b10a5270609fbcd873ea8b675c97e257423866d561f2d8e7540730e1179f4dca88');

-- Comment 1 on Georgi post 1 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e',
        '2026-07-29T09:31:00.000Z',
        'aeef004b52732cb81bd39d62cd18ec6028879373622291815442ddab956caf983e8701d154bfb001a69c7737973e81b96fc9b7dafc8a23afff0063fbb7aa23e9',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'I like this approach. It should work well for the application.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T09:31:00.000Z',
        'aeef004b52732cb81bd39d62cd18ec6028879373622291815442ddab956caf983e8701d154bfb001a69c7737973e81b96fc9b7dafc8a23afff0063fbb7aa23e9',
        '89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e',
        'I like this approach. It should work well for the application.');

-- Comment 2 on Georgi post 1 by Victoriya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e',
        '2026-07-29T09:32:00.000Z',
        'd4a4dae60a60f9e99db255e7c7525dff383a457b1734aacfa96a6bce13d7e6e682e3d4d80de61f8534cffe47c8250cb856a01c7dd98a40f1a19672a65d4fdd6c',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        'Looks promising. The implementation seems very practical.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8', '2026-07-29T09:32:00.000Z',
        'd4a4dae60a60f9e99db255e7c7525dff383a457b1734aacfa96a6bce13d7e6e682e3d4d80de61f8534cffe47c8250cb856a01c7dd98a40f1a19672a65d4fdd6c',
        '89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e',
        'Looks promising. The implementation seems very practical.');

-- Comment 3 on Georgi post 1 by Angel
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e',
        '2026-07-29T09:33:00.000Z',
        'a970bacfa27fc57fb2fa83059b82dbc82b7316173f041bde866a6de388ffdcbf933cd08938c51090ba9c3d0f2f0f0fc455127d26990a8b1b72aaab9bbd1c644c',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        'Nice work. The structure is easy to understand.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71', '2026-07-29T09:33:00.000Z',
        'a970bacfa27fc57fb2fa83059b82dbc82b7316173f041bde866a6de388ffdcbf933cd08938c51090ba9c3d0f2f0f0fc455127d26990a8b1b72aaab9bbd1c644c',
        '89ee76eafadbf490e1c72a472f7352bea4c8896dfe96b722fe9a42732cac80dd1b47f97539abb55d8103aaf8af54757f1b998df9a747ed2c844f4a840183b44e',
        'Nice work. The structure is easy to understand.');

-- Georgi post 2: video
-- post_identity: 6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               youtube_url, created_at)
VALUES ('6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        'I found this programming video useful, so I am sharing it with everyone.', true, false, true, false,
        'https://www.youtube.com/watch?v=vtPkZShrvXQ', '2026-07-29T09:45:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll, youtube_url)
VALUES ('771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551', '2026-07-29T09:45:00.000Z',
        '6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5',
        'I found this programming video useful, so I am sharing it with everyone.', true, false, true, false,
        'https://www.youtube.com/watch?v=vtPkZShrvXQ');

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll, youtube_url)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T09:45:00.000Z',
        '6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        'I found this programming video useful, so I am sharing it with everyone.', true, false, true, false,
        'https://www.youtube.com/watch?v=vtPkZShrvXQ');

-- Comment 1 on Georgi post 2 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5',
        '2026-07-29T09:46:00.000Z',
        '047128c05508a3598216a45cba92185f3c1c441c28cd1ee9c741d37faa6ef55f02ed6e3dfb5cd2da27647ff1401469ca9452bccff5ff4fcd0bd4c53d33a8f32c',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Nice update. I like how this is progressing.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T09:46:00.000Z',
        '047128c05508a3598216a45cba92185f3c1c441c28cd1ee9c741d37faa6ef55f02ed6e3dfb5cd2da27647ff1401469ca9452bccff5ff4fcd0bd4c53d33a8f32c',
        '6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5',
        'Nice update. I like how this is progressing.');

-- Comment 2 on Georgi post 2 by Mariya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5',
        '2026-07-29T09:47:00.000Z',
        '713e7e63f779cf1f6924bbbf574cd5bb2c7295f409aa389bb2fc70bd248531fa27bb9315a58152c7ee746d6da871d2d221bc73a4aee52620b4b419ac6dfa8f15',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        'This looks really good. Thanks for sharing it.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f', '2026-07-29T09:47:00.000Z',
        '713e7e63f779cf1f6924bbbf574cd5bb2c7295f409aa389bb2fc70bd248531fa27bb9315a58152c7ee746d6da871d2d221bc73a4aee52620b4b419ac6dfa8f15',
        '6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5',
        'This looks really good. Thanks for sharing it.');

-- Comment 3 on Georgi post 2 by Iliya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5',
        '2026-07-29T09:48:00.000Z',
        '0f1e4d6d2c53e59d294cc4b55edbf7647d1365429d0b5be58c01b3c19743457e72462e0612ed9a47f124edc10655fc75e1dd7f3c25792027e89c7e142e422031',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        'Interesting idea. I would like to see the next version.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6', '2026-07-29T09:48:00.000Z',
        '0f1e4d6d2c53e59d294cc4b55edbf7647d1365429d0b5be58c01b3c19743457e72462e0612ed9a47f124edc10655fc75e1dd7f3c25792027e89c7e142e422031',
        '6fcc9cbdf157324d0613deca94e259a8246b5d79cb7add9b77ead267e67045852234c6a8163da29a25c998a6dd5ff7f42e76afdf851614e2ed05150337635cb5',
        'Interesting idea. I would like to see the next version.');


-- =====================================================
-- POSTS FOR STOYAN
-- =====================================================

-- Stoyan post 1: text
-- post_identity: a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               created_at)
VALUES ('a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        'Today I spent some time learning more about distributed databases and data modelling.', true, false, false,
        false, '2026-07-29T10:00:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll)
VALUES ('788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627', '2026-07-29T10:00:00.000Z',
        'a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341',
        'Today I spent some time learning more about distributed databases and data modelling.', true, false, false,
        false);

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T10:00:00.000Z',
        'a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        'Today I spent some time learning more about distributed databases and data modelling.', true, false, false,
        false);

-- Comment 1 on Stoyan post 1 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341',
        '2026-07-29T10:01:00.000Z',
        '2ca06c51473a33c59ea6b90d63798eefe1080fe75e5456b263efaaafe6caf09fad4c814c739033faef0b3fc739274060fbbdaaccd0f3f95afdcdafd7c9b9a6e7',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Great work. The project is becoming more complete.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T10:01:00.000Z',
        '2ca06c51473a33c59ea6b90d63798eefe1080fe75e5456b263efaaafe6caf09fad4c814c739033faef0b3fc739274060fbbdaaccd0f3f95afdcdafd7c9b9a6e7',
        'a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341',
        'Great work. The project is becoming more complete.');

-- Comment 2 on Stoyan post 1 by Mariya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341',
        '2026-07-29T10:02:00.000Z',
        '6938d4711b6fbd7b204513ff902b004faefd67575c7a3553b5457c00161f1a5e169c13cfb443f5dc1378434cd72db2dabaf6c2c818762beca00646b1fa3a570f',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        'This is a useful example and the result looks clean.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f', '2026-07-29T10:02:00.000Z',
        '6938d4711b6fbd7b204513ff902b004faefd67575c7a3553b5457c00161f1a5e169c13cfb443f5dc1378434cd72db2dabaf6c2c818762beca00646b1fa3a570f',
        'a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341',
        'This is a useful example and the result looks clean.');

-- Comment 3 on Stoyan post 1 by Iliya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341',
        '2026-07-29T10:03:00.000Z',
        'b5f2759c208b2ab4e3692d449975ab1c932f87a19cff767a41a076a471a028d4d53babdbdf109279966e94142fa1a7679554544918eb660887f6ff70ff5d8e90',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        'Good progress. Keep us updated when you add more features.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6', '2026-07-29T10:03:00.000Z',
        'b5f2759c208b2ab4e3692d449975ab1c932f87a19cff767a41a076a471a028d4d53babdbdf109279966e94142fa1a7679554544918eb660887f6ff70ff5d8e90',
        'a63c1af15469612d9e254e5d7c9a32dca9c71811eddc0dd60aa81c3e59a2e8b0c4b5691d7f7a974d2e4cad96f2ab1b39dff18c1b7cd66eb46d3c2ab183775341',
        'Good progress. Keep us updated when you add more features.');

-- Stoyan post 2: image + text
-- post_identity: b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0
-- image_identity (random SHA-512): 966435cf9082edf4f4e75c2a642643bf00f945fef356ce906062c5ad5de1a5e23fff84a64abfd45c20bd517c1f57efe28359a94aefda2d28553c729ac0db5d5c

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               image_identity, created_at)
VALUES ('b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        'Working on a new user interface concept for the profile page.', true, true, false, false,
        '966435cf9082edf4f4e75c2a642643bf00f945fef356ce906062c5ad5de1a5e23fff84a64abfd45c20bd517c1f57efe28359a94aefda2d28553c729ac0db5d5c',
        '2026-07-29T10:15:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll, image_identity)
VALUES ('788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627', '2026-07-29T10:15:00.000Z',
        'b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0',
        'Working on a new user interface concept for the profile page.', true, true, false, false,
        '966435cf9082edf4f4e75c2a642643bf00f945fef356ce906062c5ad5de1a5e23fff84a64abfd45c20bd517c1f57efe28359a94aefda2d28553c729ac0db5d5c');

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll, image_identity)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T10:15:00.000Z',
        'b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        'Working on a new user interface concept for the profile page.', true, true, false, false,
        '966435cf9082edf4f4e75c2a642643bf00f945fef356ce906062c5ad5de1a5e23fff84a64abfd45c20bd517c1f57efe28359a94aefda2d28553c729ac0db5d5c');

-- Comment 1 on Stoyan post 2 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0',
        '2026-07-29T10:16:00.000Z',
        'bb0bbca0dae5448a7e217cc02d301830a0e396a3901a585c849a2c486b3416559444acf8d1232ad42c7076b5af1adb732f9e79728645573309cfc1f4de2a8a94',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'I like this approach. It should work well for the application.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T10:16:00.000Z',
        'bb0bbca0dae5448a7e217cc02d301830a0e396a3901a585c849a2c486b3416559444acf8d1232ad42c7076b5af1adb732f9e79728645573309cfc1f4de2a8a94',
        'b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0',
        'I like this approach. It should work well for the application.');

-- Comment 2 on Stoyan post 2 by Konstantin
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0',
        '2026-07-29T10:17:00.000Z',
        'f06b134e6e7c47e1eb969f0866f86aa0c9bc212b955d3b0f90ac066395717fcb28ff0689c2dd898c4170a19cb3d226713cd1eed9a80b24907730125add852e2f',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        'Looks promising. The implementation seems very practical.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85', '2026-07-29T10:17:00.000Z',
        'f06b134e6e7c47e1eb969f0866f86aa0c9bc212b955d3b0f90ac066395717fcb28ff0689c2dd898c4170a19cb3d226713cd1eed9a80b24907730125add852e2f',
        'b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0',
        'Looks promising. The implementation seems very practical.');

-- Comment 3 on Stoyan post 2 by Tanya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0',
        '2026-07-29T10:18:00.000Z',
        'd9983cdb5af0bd1b4e4ce695aade856c16c607f8edfb95b19bfd59a64e9cb4f9baba4fe770d8048db8fc60e1277cc421a17c425388c02cf2c2688bc161452700',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93',
        'Nice work. The structure is easy to understand.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93', '2026-07-29T10:18:00.000Z',
        'd9983cdb5af0bd1b4e4ce695aade856c16c607f8edfb95b19bfd59a64e9cb4f9baba4fe770d8048db8fc60e1277cc421a17c425388c02cf2c2688bc161452700',
        'b29d832f9ca63c7fe921bae2cddf9f2d82c1c5222b96fab3b2e59d844ba602095bf6a21ea1e6b333aeb80727c9ed5d121a5601551a40fae452c20fcbf6d3fbe0',
        'Nice work. The structure is easy to understand.');


-- =====================================================
-- POSTS FOR VICTORIYA
-- =====================================================

-- Victoriya post 1: video
-- post_identity: 6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               youtube_url, created_at)
VALUES ('6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        'This video gives a nice overview of software development concepts.', true, false, true, false,
        'https://www.youtube.com/watch?v=RBSGKlAvoiM', '2026-07-29T10:30:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll, youtube_url)
VALUES ('d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8', '2026-07-29T10:30:00.000Z',
        '6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635',
        'This video gives a nice overview of software development concepts.', true, false, true, false,
        'https://www.youtube.com/watch?v=RBSGKlAvoiM');

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll, youtube_url)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T10:30:00.000Z',
        '6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        'This video gives a nice overview of software development concepts.', true, false, true, false,
        'https://www.youtube.com/watch?v=RBSGKlAvoiM');

-- Comment 1 on Victoriya post 1 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635',
        '2026-07-29T10:31:00.000Z',
        'c8098bee68f2af133946a91340dd7c0bc8ccd6c80e0f7347736d7e89a448ec572dbbcb51686295ac42378c34d8800fff8bef1e98f3901f7c25a43121c3f30cb9',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Nice update. I like how this is progressing.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T10:31:00.000Z',
        'c8098bee68f2af133946a91340dd7c0bc8ccd6c80e0f7347736d7e89a448ec572dbbcb51686295ac42378c34d8800fff8bef1e98f3901f7c25a43121c3f30cb9',
        '6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635',
        'Nice update. I like how this is progressing.');

-- Comment 2 on Victoriya post 1 by Konstantin
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635',
        '2026-07-29T10:32:00.000Z',
        '0b7eb6a5be147da1b4bf63ab531c79dcf6b24645b1f55a05c8f3cf5c18c12cd0155f27ad07d05cc85b3da0445721e7fc9e859c5281c2876920c20187d77a6731',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        'This looks really good. Thanks for sharing it.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85', '2026-07-29T10:32:00.000Z',
        '0b7eb6a5be147da1b4bf63ab531c79dcf6b24645b1f55a05c8f3cf5c18c12cd0155f27ad07d05cc85b3da0445721e7fc9e859c5281c2876920c20187d77a6731',
        '6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635',
        'This looks really good. Thanks for sharing it.');

-- Comment 3 on Victoriya post 1 by Tanya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635',
        '2026-07-29T10:33:00.000Z',
        'd2370de0bebd2bcef1f369f444547c513569a8d0f3fa168a7bcac6dc8dc734a85a7c8c88a0c76929c1a80ec8a902edfc96792e908c22ba9b6b7662d055cfb4a9',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93',
        'Interesting idea. I would like to see the next version.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93', '2026-07-29T10:33:00.000Z',
        'd2370de0bebd2bcef1f369f444547c513569a8d0f3fa168a7bcac6dc8dc734a85a7c8c88a0c76929c1a80ec8a902edfc96792e908c22ba9b6b7662d055cfb4a9',
        '6e4a0409340660a28ef4a9bbe6e16450961c01c78ae853770c3682815e91e4abfe90b3ba7f42c4138002826b7baf8cc60862f5a5f2c68188acabd74034406635',
        'Interesting idea. I would like to see the next version.');

-- Victoriya post 2: image
-- post_identity: 900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4
-- image_identity (random SHA-512): 3c5845bef2b0df3f8b63fcc32165d44813839c4a70211a57240ca59ca1e116362b4d0dbc7b88636625aa329fe8014bfe4c43982e3e33ea378a5b6f892658efdd

INSERT INTO posts_by_identity (post_identity, author_identity, has_text, has_image, has_video, is_poll, image_identity,
                               created_at)
VALUES ('900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8', false, true, false, false,
        '3c5845bef2b0df3f8b63fcc32165d44813839c4a70211a57240ca59ca1e116362b4d0dbc7b88636625aa329fe8014bfe4c43982e3e33ea378a5b6f892658efdd',
        '2026-07-29T10:45:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, has_text, has_image, has_video, is_poll,
                             image_identity)
VALUES ('d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8', '2026-07-29T10:45:00.000Z',
        '900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4',
        false, true, false, false,
        '3c5845bef2b0df3f8b63fcc32165d44813839c4a70211a57240ca59ca1e116362b4d0dbc7b88636625aa329fe8014bfe4c43982e3e33ea378a5b6f892658efdd');

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, has_text, has_image, has_video,
                          is_poll, image_identity)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T10:45:00.000Z',
        '900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8', false, true, false, false,
        '3c5845bef2b0df3f8b63fcc32165d44813839c4a70211a57240ca59ca1e116362b4d0dbc7b88636625aa329fe8014bfe4c43982e3e33ea378a5b6f892658efdd');

-- Comment 1 on Victoriya post 2 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4',
        '2026-07-29T10:46:00.000Z',
        '17ae4e7bfa7c2917d748758a5010ced5a6864215298e13f70598279eda8f28ea4a9bf7a48e19cfa6b1ceeb1f02ff6cec9aff15deb3c2613a47eb6c48402c1e81',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Great work. The project is becoming more complete.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T10:46:00.000Z',
        '17ae4e7bfa7c2917d748758a5010ced5a6864215298e13f70598279eda8f28ea4a9bf7a48e19cfa6b1ceeb1f02ff6cec9aff15deb3c2613a47eb6c48402c1e81',
        '900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4',
        'Great work. The project is becoming more complete.');

-- Comment 2 on Victoriya post 2 by Angel
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4',
        '2026-07-29T10:47:00.000Z',
        '97bd3f85bb6aa7bcbf283d7cc39ec4481e5734e86c19916b19e43c94e6fc7767af329928108a755048159581ebe4afb20dccb0dbe090ff0d1ab7918a48f637f7',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        'This is a useful example and the result looks clean.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71', '2026-07-29T10:47:00.000Z',
        '97bd3f85bb6aa7bcbf283d7cc39ec4481e5734e86c19916b19e43c94e6fc7767af329928108a755048159581ebe4afb20dccb0dbe090ff0d1ab7918a48f637f7',
        '900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4',
        'This is a useful example and the result looks clean.');

-- Comment 3 on Victoriya post 2 by Petur
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4',
        '2026-07-29T10:48:00.000Z',
        'e17f20e616131a0252d6b843a43ea06a87f67aab8aa5decdeb53274c03dc186c5970ce122f8746edca0534519d7107aefb451ef8667a071b6f78ff41a67f1d9f',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        'Good progress. Keep us updated when you add more features.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91', '2026-07-29T10:48:00.000Z',
        'e17f20e616131a0252d6b843a43ea06a87f67aab8aa5decdeb53274c03dc186c5970ce122f8746edca0534519d7107aefb451ef8667a071b6f78ff41a67f1d9f',
        '900e7234a68be8af01a781a1ac1ee70de86c61f319c2e387c1b22da49a7fb69238e3a3958a7d7fa6c68c39855a7bef1200025e528d114296d282d3bc46ecabd4',
        'Good progress. Keep us updated when you add more features.');


-- =====================================================
-- POSTS FOR MARIYA
-- =====================================================

-- Mariya post 1: text
-- post_identity: 5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               created_at)
VALUES ('5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        'Finished an interesting coding task today and learned a few new things along the way.', true, false, false,
        false, '2026-07-29T11:00:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll)
VALUES ('8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f', '2026-07-29T11:00:00.000Z',
        '5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c',
        'Finished an interesting coding task today and learned a few new things along the way.', true, false, false,
        false);

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T11:00:00.000Z',
        '5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        'Finished an interesting coding task today and learned a few new things along the way.', true, false, false,
        false);

-- Comment 1 on Mariya post 1 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c',
        '2026-07-29T11:01:00.000Z',
        '82a3fc2f302552d3c682b830ce3fe53f2eb56c821c83738147f1092c23bc7f66eb54b8d1d281e58b1c7c0784a2e1edcf68c566f46e6f34123621f02ef635370f',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'I like this approach. It should work well for the application.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T11:01:00.000Z',
        '82a3fc2f302552d3c682b830ce3fe53f2eb56c821c83738147f1092c23bc7f66eb54b8d1d281e58b1c7c0784a2e1edcf68c566f46e6f34123621f02ef635370f',
        '5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c',
        'I like this approach. It should work well for the application.');

-- Comment 2 on Mariya post 1 by Angel
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c',
        '2026-07-29T11:02:00.000Z',
        'e9aaea3a7aacf101df98a48fb8befab48648828fe3d94fe6fe291bb09bdb20ca14d1ddbcccfdbd3fab4b92b229b85f749b17d9cbdcc36222adb92673f5fd9ae2',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        'Looks promising. The implementation seems very practical.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71', '2026-07-29T11:02:00.000Z',
        'e9aaea3a7aacf101df98a48fb8befab48648828fe3d94fe6fe291bb09bdb20ca14d1ddbcccfdbd3fab4b92b229b85f749b17d9cbdcc36222adb92673f5fd9ae2',
        '5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c',
        'Looks promising. The implementation seems very practical.');

-- Comment 3 on Mariya post 1 by Petur
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c',
        '2026-07-29T11:03:00.000Z',
        '54ea83cc808f8cb8d711b9aa519ea0668ff3da1b717c00456d1f036db3f5b1c5f99886193ea064a0e5012b71597864b328650dfbc6a5eb52cdd00a90d46bdaaf',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        'Nice work. The structure is easy to understand.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91', '2026-07-29T11:03:00.000Z',
        '54ea83cc808f8cb8d711b9aa519ea0668ff3da1b717c00456d1f036db3f5b1c5f99886193ea064a0e5012b71597864b328650dfbc6a5eb52cdd00a90d46bdaaf',
        '5e5cb9d182b2edc40d52f2e531d83a6196e57da0d9862ca9f0dd9ca069974a772d576cebe6a720e7e792a695edf9c6c0bf191c8048ca6199f66e200884749b3c',
        'Nice work. The structure is easy to understand.');

-- Mariya post 2: image + text
-- post_identity: 6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065
-- image_identity (random SHA-512): 17fb08fd70a8e3e03abdeecdf544a5d3f71c09bb9633648dc7682043f56cbc44f3dd51bc919d3b8b850251b3b82d5d72088050a066a5d804db993956f686ad19

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               image_identity, created_at)
VALUES ('6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        'Sharing a screenshot from the project I am currently working on.', true, true, false, false,
        '17fb08fd70a8e3e03abdeecdf544a5d3f71c09bb9633648dc7682043f56cbc44f3dd51bc919d3b8b850251b3b82d5d72088050a066a5d804db993956f686ad19',
        '2026-07-29T11:15:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll, image_identity)
VALUES ('8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f', '2026-07-29T11:15:00.000Z',
        '6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065',
        'Sharing a screenshot from the project I am currently working on.', true, true, false, false,
        '17fb08fd70a8e3e03abdeecdf544a5d3f71c09bb9633648dc7682043f56cbc44f3dd51bc919d3b8b850251b3b82d5d72088050a066a5d804db993956f686ad19');

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll, image_identity)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T11:15:00.000Z',
        '6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        'Sharing a screenshot from the project I am currently working on.', true, true, false, false,
        '17fb08fd70a8e3e03abdeecdf544a5d3f71c09bb9633648dc7682043f56cbc44f3dd51bc919d3b8b850251b3b82d5d72088050a066a5d804db993956f686ad19');

-- Comment 1 on Mariya post 2 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065',
        '2026-07-29T11:16:00.000Z',
        '50a941dbfa1aa66a8545f50c3e212d9513260e0aff9e04010adccaab3cbeb489d2d44e8931873d8fa053b2f6cb43991ac0805c7a6e0efe0888586672bb3c5090',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Nice update. I like how this is progressing.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T11:16:00.000Z',
        '50a941dbfa1aa66a8545f50c3e212d9513260e0aff9e04010adccaab3cbeb489d2d44e8931873d8fa053b2f6cb43991ac0805c7a6e0efe0888586672bb3c5090',
        '6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065',
        'Nice update. I like how this is progressing.');

-- Comment 2 on Mariya post 2 by Iliya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065',
        '2026-07-29T11:17:00.000Z',
        'f5060bbe5f03ffdddb8d737d725cf68bd04b6764189e41ecd6e5f5df1e9008bb8ff18071bcfe7d3b0018c6df1b2fe909220dfd723c79dc2b1457c619089a4278',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        'This looks really good. Thanks for sharing it.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6', '2026-07-29T11:17:00.000Z',
        'f5060bbe5f03ffdddb8d737d725cf68bd04b6764189e41ecd6e5f5df1e9008bb8ff18071bcfe7d3b0018c6df1b2fe909220dfd723c79dc2b1457c619089a4278',
        '6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065',
        'This looks really good. Thanks for sharing it.');

-- Comment 3 on Mariya post 2 by Georgi
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065',
        '2026-07-29T11:18:00.000Z',
        'abbbbe8b8b375cdd75760bfba8638ff5745ebeab99dacbb04990d220c4360db703cf36cc8aea12ecc991a7f63fbcc7326bffc8af599cc634da738bf8286ba3d6',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        'Interesting idea. I would like to see the next version.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551', '2026-07-29T11:18:00.000Z',
        'abbbbe8b8b375cdd75760bfba8638ff5745ebeab99dacbb04990d220c4360db703cf36cc8aea12ecc991a7f63fbcc7326bffc8af599cc634da738bf8286ba3d6',
        '6d1e7245faf272008dd06dd32a6cd77ca1ef073dc8436d13258e09a1fd23c03fdd52bc9a43ca6a256405e7b909e5986ca4d0acdf97ba70e809a68da5935cc065',
        'Interesting idea. I would like to see the next version.');


-- =====================================================
-- POSTS FOR KONSTANTIN - Till here
-- =====================================================

-- Konstantin post 1: image
-- post_identity: 8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4
-- image_identity (random SHA-512): bb93d8ddf5737830ea185abe8b4f670d54f55ec342feae5e63480c057f6321691f95bfb6f53fed736e81567b2fd68e3ea2296b3db98bedf9a959e3378828406d

INSERT INTO posts_by_identity (post_identity, author_identity, has_text, has_image, has_video, is_poll, image_identity,
                               created_at)
VALUES ('8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85', false, true, false, false,
        'bb93d8ddf5737830ea185abe8b4f670d54f55ec342feae5e63480c057f6321691f95bfb6f53fed736e81567b2fd68e3ea2296b3db98bedf9a959e3378828406d',
        '2026-07-29T11:30:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, has_text, has_image, has_video, is_poll,
                             image_identity)
VALUES ('c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85', '2026-07-29T11:30:00.000Z',
        '8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4',
        false, true, false, false,
        'bb93d8ddf5737830ea185abe8b4f670d54f55ec342feae5e63480c057f6321691f95bfb6f53fed736e81567b2fd68e3ea2296b3db98bedf9a959e3378828406d');

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, has_text, has_image, has_video,
                          is_poll, image_identity)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T11:30:00.000Z',
        '8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85', false, true, false, false,
        'bb93d8ddf5737830ea185abe8b4f670d54f55ec342feae5e63480c057f6321691f95bfb6f53fed736e81567b2fd68e3ea2296b3db98bedf9a959e3378828406d');

-- Comment 1 on Konstantin post 1 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4',
        '2026-07-29T11:31:00.000Z',
        'f515a9e4746f3f01bcd9f00693079ebe2d9f0e81d56c1225b7b953d956c88622fe82848156eea84321eff95f4a719597ea51bcd55693b42a1447ca43a9f0e6e9',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Great work. The project is becoming more complete.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T11:31:00.000Z',
        'f515a9e4746f3f01bcd9f00693079ebe2d9f0e81d56c1225b7b953d956c88622fe82848156eea84321eff95f4a719597ea51bcd55693b42a1447ca43a9f0e6e9',
        '8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4',
        'Great work. The project is becoming more complete.');

-- Comment 2 on Konstantin post 1 by Iliya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4',
        '2026-07-29T11:32:00.000Z',
        '60d8a9fbfd9260a58063bdb22cecd0fe29386a626eb9e20822e69c30301bebe8b928485a5d003dbeb2a7101af0c8cf40af4f68929b9b92037c86a54945a4a289',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        'This is a useful example and the result looks clean.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6', '2026-07-29T11:32:00.000Z',
        '60d8a9fbfd9260a58063bdb22cecd0fe29386a626eb9e20822e69c30301bebe8b928485a5d003dbeb2a7101af0c8cf40af4f68929b9b92037c86a54945a4a289',
        '8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4',
        'This is a useful example and the result looks clean.');

-- Comment 3 on Konstantin post 1 by Georgi
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4',
        '2026-07-29T11:33:00.000Z',
        '6b368cab8d75220c18eaba46a5fc9b98bd6c182271f7dfa7a0c02f86031d23b34d65190b657f8cc31887ad8cc92f4673a068f86e3a72d3e381ce2d8eb1e7981f',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        'Good progress. Keep us updated when you add more features.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551', '2026-07-29T11:33:00.000Z',
        '6b368cab8d75220c18eaba46a5fc9b98bd6c182271f7dfa7a0c02f86031d23b34d65190b657f8cc31887ad8cc92f4673a068f86e3a72d3e381ce2d8eb1e7981f',
        '8de48c5521c8cbdb4107c105ef7903cc1d013472efb370f1c038ed55028c63499f9a673b97fdea597d96e698fabfd8e917482a87339c94161084c62bcc9592f4',
        'Good progress. Keep us updated when you add more features.');

-- Konstantin post 2: video
-- post_identity: d72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               youtube_url, created_at)
VALUES ('d72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        'A useful video for anyone interested in improving their Java skills.', true, false, true, false,
        'https://www.youtube.com/watch?v=vtPkZShrvXQ', '2026-07-29T11:45:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll, youtube_url)
VALUES ('c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85', '2026-07-29T11:45:00.000Z',
        'd72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d',
        'A useful video for anyone interested in improving their Java skills.', true, false, true, false,
        'https://www.youtube.com/watch?v=vtPkZShrvXQ');

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll, youtube_url)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T11:45:00.000Z',
        'd72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        'A useful video for anyone interested in improving their Java skills.', true, false, true, false,
        'https://www.youtube.com/watch?v=vtPkZShrvXQ');

-- Comment 1 on Konstantin post 2 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('d72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d',
        '2026-07-29T11:46:00.000Z',
        '6611811e146f0e51f48dbecfdc8d9216f2df580bf1fcfe7807d39fdb3e129c3b60dfa1efac5da7dc3d95dbbf8a54a53be98fed6b8c831ecaf1c48c6a5f03a0c7',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'I like this approach. It should work well for the application.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T11:46:00.000Z',
        '6611811e146f0e51f48dbecfdc8d9216f2df580bf1fcfe7807d39fdb3e129c3b60dfa1efac5da7dc3d95dbbf8a54a53be98fed6b8c831ecaf1c48c6a5f03a0c7',
        'd72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d',
        'I like this approach. It should work well for the application.');

-- Comment 2 on Konstantin post 2 by Tanya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('d72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d',
        '2026-07-29T11:47:00.000Z',
        'fe67d22bea3b1c4eaabd333742174b6b3d86d2772f3c22e6d0fa3be91ab49b53b00fd96f675820436d620abbab6a60649720d9ef2b125d8ffd4b2e82e96ea7d7',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93',
        'Looks promising. The implementation seems very practical.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93', '2026-07-29T11:47:00.000Z',
        'fe67d22bea3b1c4eaabd333742174b6b3d86d2772f3c22e6d0fa3be91ab49b53b00fd96f675820436d620abbab6a60649720d9ef2b125d8ffd4b2e82e96ea7d7',
        'd72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d',
        'Looks promising. The implementation seems very practical.');

-- Comment 3 on Konstantin post 2 by Stoyan
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('d72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d',
        '2026-07-29T11:48:00.000Z',
        '8530f6e1981302d5e4a68b5cd962316506bd69c235d0f223a61e015a3ebeb203f5306d883880fb44b0dee4a3ea4f8e519a89f3899bbc3531297fa97ea050fff2',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        'Nice work. The structure is easy to understand.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627', '2026-07-29T11:48:00.000Z',
        '8530f6e1981302d5e4a68b5cd962316506bd69c235d0f223a61e015a3ebeb203f5306d883880fb44b0dee4a3ea4f8e519a89f3899bbc3531297fa97ea050fff2',
        'd72a984a66b22b7728c33911e47d9503bca9a64090ec1a2c2e2a018df16a4185d4c05b291e7908a255853f3bb5e791e18d88e357a83d5544364ef120e4cc6a1d',
        'Nice work. The structure is easy to understand.');


-- =====================================================
-- POSTS FOR ANGEL
-- =====================================================

-- Angel post 1: text
-- post_identity: 0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               created_at)
VALUES ('0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        'Testing a new API endpoint today. Everything is finally working as expected.', true, false, false, false,
        '2026-07-29T12:00:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll)
VALUES ('519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71', '2026-07-29T12:00:00.000Z',
        '0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5',
        'Testing a new API endpoint today. Everything is finally working as expected.', true, false, false, false);

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T12:00:00.000Z',
        '0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        'Testing a new API endpoint today. Everything is finally working as expected.', true, false, false, false);

-- Comment 1 on Angel post 1 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5',
        '2026-07-29T12:01:00.000Z',
        'b5f86a9adb88d68a70e28e648b1b7922c8ca689c9e8828059daea9271de67e16b27087bb6732e7bd9f31b541e3910896cee619caf2c61444452fc7a65de4f468',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Nice update. I like how this is progressing.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T12:01:00.000Z',
        'b5f86a9adb88d68a70e28e648b1b7922c8ca689c9e8828059daea9271de67e16b27087bb6732e7bd9f31b541e3910896cee619caf2c61444452fc7a65de4f468',
        '0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5',
        'Nice update. I like how this is progressing.');

-- Comment 2 on Angel post 1 by Tanya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5',
        '2026-07-29T12:02:00.000Z',
        '930c1052e00c070be8b4ae9b26b1736f72c6b05119d8673ae3435719bf558965c081313d7302c4dce0299ff6231917bc22e1208319944d28bc57efae2f3f3778',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93',
        'This looks really good. Thanks for sharing it.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93', '2026-07-29T12:02:00.000Z',
        '930c1052e00c070be8b4ae9b26b1736f72c6b05119d8673ae3435719bf558965c081313d7302c4dce0299ff6231917bc22e1208319944d28bc57efae2f3f3778',
        '0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5',
        'This looks really good. Thanks for sharing it.');

-- Comment 3 on Angel post 1 by Stoyan
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5',
        '2026-07-29T12:03:00.000Z',
        '1f67a92e38ba7d2189fb1dcf6fa409cdd5194de1447098acd5cd2b00bfd807bd780f66da42afa9994b1bea416c5913acaeb0508cd8610cb5c707ed00d1a6bd13',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        'Interesting idea. I would like to see the next version.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627', '2026-07-29T12:03:00.000Z',
        '1f67a92e38ba7d2189fb1dcf6fa409cdd5194de1447098acd5cd2b00bfd807bd780f66da42afa9994b1bea416c5913acaeb0508cd8610cb5c707ed00d1a6bd13',
        '0c841308f08dee1a07db793330e90bb9e50a2f8fd681bb72816b1786c0bb3baa9ca95b2226e05323fad1eaf094b3291bb95e9fc504965fac662b523ccc6f49a5',
        'Interesting idea. I would like to see the next version.');

-- Angel post 2: image + text
-- post_identity: 695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c
-- image_identity (random SHA-512): f3df42883a564e9f1f171fa9be27697d488165e47c2d694297c49427e56f067245e48ec7f4f5b67c189782798829e2a6ac0f7ef4756d85a92fa4b459b1428e6c

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               image_identity, created_at)
VALUES ('695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        'Here is a quick look at the application running locally.', true, true, false, false,
        'f3df42883a564e9f1f171fa9be27697d488165e47c2d694297c49427e56f067245e48ec7f4f5b67c189782798829e2a6ac0f7ef4756d85a92fa4b459b1428e6c',
        '2026-07-29T12:15:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll, image_identity)
VALUES ('519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71', '2026-07-29T12:15:00.000Z',
        '695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c',
        'Here is a quick look at the application running locally.', true, true, false, false,
        'f3df42883a564e9f1f171fa9be27697d488165e47c2d694297c49427e56f067245e48ec7f4f5b67c189782798829e2a6ac0f7ef4756d85a92fa4b459b1428e6c');

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll, image_identity)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T12:15:00.000Z',
        '695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        'Here is a quick look at the application running locally.', true, true, false, false,
        'f3df42883a564e9f1f171fa9be27697d488165e47c2d694297c49427e56f067245e48ec7f4f5b67c189782798829e2a6ac0f7ef4756d85a92fa4b459b1428e6c');

-- Comment 1 on Angel post 2 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c',
        '2026-07-29T12:16:00.000Z',
        '7979c419ebe826fe83679598b5fb35475fd73bfc43a587014b2967617a5ebc0baea07d3e95be5805435ad796133be6aa24eff27324e3b86d90705e8065960b07',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Great work. The project is becoming more complete.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T12:16:00.000Z',
        '7979c419ebe826fe83679598b5fb35475fd73bfc43a587014b2967617a5ebc0baea07d3e95be5805435ad796133be6aa24eff27324e3b86d90705e8065960b07',
        '695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c',
        'Great work. The project is becoming more complete.');

-- Comment 2 on Angel post 2 by Petur
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c',
        '2026-07-29T12:17:00.000Z',
        'fc5251e06927a7bf79fbd4e63211dd57bc335cfc09b03362e0f84827ca193a75e8f5b1e0d8fd5523098ce910d91c0ccecb8e19bab7db7428000b33cefd427bf8',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        'This is a useful example and the result looks clean.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91', '2026-07-29T12:17:00.000Z',
        'fc5251e06927a7bf79fbd4e63211dd57bc335cfc09b03362e0f84827ca193a75e8f5b1e0d8fd5523098ce910d91c0ccecb8e19bab7db7428000b33cefd427bf8',
        '695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c',
        'This is a useful example and the result looks clean.');

-- Comment 3 on Angel post 2 by Victoriya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c',
        '2026-07-29T12:18:00.000Z',
        '79f8aeb0ce7faf3b20d3897ae6e99f57e246a8b91ad005c7829293d62855a8347115b10d8ff4072b8d3baca08b47b159c7163dae150c65dfdca2f014e88c8f2e',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        'Good progress. Keep us updated when you add more features.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8', '2026-07-29T12:18:00.000Z',
        '79f8aeb0ce7faf3b20d3897ae6e99f57e246a8b91ad005c7829293d62855a8347115b10d8ff4072b8d3baca08b47b159c7163dae150c65dfdca2f014e88c8f2e',
        '695c0960288f838efa9dd645c83af9f4b9500c6a1647b3af2a35b9591c10e50e39488574bc8de887148477cdaa7a3c7993e4c85c1244321e8f24b5a1996db66c',
        'Good progress. Keep us updated when you add more features.');


-- =====================================================
-- POSTS FOR ILIYA
-- =====================================================

-- Iliya post 1: video
-- post_identity: 56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               youtube_url, created_at)
VALUES ('56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        'Sharing a video that helped me understand backend architecture better.', true, false, true, false,
        'https://www.youtube.com/watch?v=RBSGKlAvoiM', '2026-07-29T12:30:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll, youtube_url)
VALUES ('a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6', '2026-07-29T12:30:00.000Z',
        '56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984',
        'Sharing a video that helped me understand backend architecture better.', true, false, true, false,
        'https://www.youtube.com/watch?v=RBSGKlAvoiM');

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll, youtube_url)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T12:30:00.000Z',
        '56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        'Sharing a video that helped me understand backend architecture better.', true, false, true, false,
        'https://www.youtube.com/watch?v=RBSGKlAvoiM');

-- Comment 1 on Iliya post 1 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984',
        '2026-07-29T12:31:00.000Z',
        '96fbe98eda8b1fa686e799945f895d777fc4d7ffc6bc92e64da07e17a37f3078c9dd1a1f4cdd61e588ad21e95844291274d51a109c03bcb5ac0f27444efd28b9',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'I like this approach. It should work well for the application.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T12:31:00.000Z',
        '96fbe98eda8b1fa686e799945f895d777fc4d7ffc6bc92e64da07e17a37f3078c9dd1a1f4cdd61e588ad21e95844291274d51a109c03bcb5ac0f27444efd28b9',
        '56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984',
        'I like this approach. It should work well for the application.');

-- Comment 2 on Iliya post 1 by Petur
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984',
        '2026-07-29T12:32:00.000Z',
        '0b7a24ca8c2a3d7b0687967b0e6f698ed34b565f824bbb700841ba32e627d83faf3800bed0632c8e5ac697a0f40fd08a69962bbf8a83a7fc76513eae9307b21b',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        'Looks promising. The implementation seems very practical.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91', '2026-07-29T12:32:00.000Z',
        '0b7a24ca8c2a3d7b0687967b0e6f698ed34b565f824bbb700841ba32e627d83faf3800bed0632c8e5ac697a0f40fd08a69962bbf8a83a7fc76513eae9307b21b',
        '56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984',
        'Looks promising. The implementation seems very practical.');

-- Comment 3 on Iliya post 1 by Victoriya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984',
        '2026-07-29T12:33:00.000Z',
        '55e59ae8f21e224c0662adb2140cab16bcf28aa5cea937e85fdf4edcbc967c28c37d064e20b042c1c0aa3c8fefcaf8c1bfbe0d976a4c5e388d704e503f286673',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        'Nice work. The structure is easy to understand.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8', '2026-07-29T12:33:00.000Z',
        '55e59ae8f21e224c0662adb2140cab16bcf28aa5cea937e85fdf4edcbc967c28c37d064e20b042c1c0aa3c8fefcaf8c1bfbe0d976a4c5e388d704e503f286673',
        '56976897dfcca45ba101af9c40b5c76a82970cb11157361672d046cdec49c051d4007630d5c3ede7955acfb506d5a452d6ccdd6721686776be90cdc1c13d9984',
        'Nice work. The structure is easy to understand.');

-- Iliya post 2: image
-- post_identity: 1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d
-- image_identity (random SHA-512): 06916222fffb4a105d11dc498661784dc115725b4b0735976e019aa50d20bae1126942b22d11b1fe53a7635e2262ddcbb8ecebea027abbf65e52d0c1dc7fb54f

INSERT INTO posts_by_identity (post_identity, author_identity, has_text, has_image, has_video, is_poll, image_identity,
                               created_at)
VALUES ('1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6', false, true, false, false,
        '06916222fffb4a105d11dc498661784dc115725b4b0735976e019aa50d20bae1126942b22d11b1fe53a7635e2262ddcbb8ecebea027abbf65e52d0c1dc7fb54f',
        '2026-07-29T12:45:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, has_text, has_image, has_video, is_poll,
                             image_identity)
VALUES ('a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6', '2026-07-29T12:45:00.000Z',
        '1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d',
        false, true, false, false,
        '06916222fffb4a105d11dc498661784dc115725b4b0735976e019aa50d20bae1126942b22d11b1fe53a7635e2262ddcbb8ecebea027abbf65e52d0c1dc7fb54f');

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, has_text, has_image, has_video,
                          is_poll, image_identity)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T12:45:00.000Z',
        '1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6', false, true, false, false,
        '06916222fffb4a105d11dc498661784dc115725b4b0735976e019aa50d20bae1126942b22d11b1fe53a7635e2262ddcbb8ecebea027abbf65e52d0c1dc7fb54f');

-- Comment 1 on Iliya post 2 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d',
        '2026-07-29T12:46:00.000Z',
        'f532d31e16b5a4f7d0403c703aa2d2ad4a61eafbba80f9e6ac0eacf9e73a15b29a4f6c41bc5614bb5963843c8253e05c4649446627655944a14ac0e3f9b3c01b',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Nice update. I like how this is progressing.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T12:46:00.000Z',
        'f532d31e16b5a4f7d0403c703aa2d2ad4a61eafbba80f9e6ac0eacf9e73a15b29a4f6c41bc5614bb5963843c8253e05c4649446627655944a14ac0e3f9b3c01b',
        '1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d',
        'Nice update. I like how this is progressing.');

-- Comment 2 on Iliya post 2 by Georgi
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d',
        '2026-07-29T12:47:00.000Z',
        'eec9ad9c950c9cf1a4b291ba3b714a1e98b0a3be22d01a624f663cf71ec24c99ca585cc2e8560f902719bdabc890a96973c421824f4961cf229072525e26a096',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        'This looks really good. Thanks for sharing it.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551', '2026-07-29T12:47:00.000Z',
        'eec9ad9c950c9cf1a4b291ba3b714a1e98b0a3be22d01a624f663cf71ec24c99ca585cc2e8560f902719bdabc890a96973c421824f4961cf229072525e26a096',
        '1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d',
        'This looks really good. Thanks for sharing it.');

-- Comment 3 on Iliya post 2 by Mariya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d',
        '2026-07-29T12:48:00.000Z',
        'c6f4c1e070963eed3e048f3616fedfcfdc732d3f6c55a59dd1522d75f93f64176e033abfc82bab5eac3c2ebe5909fa33967e46a7a57b454bce21a3f04d1ad915',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        'Interesting idea. I would like to see the next version.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f', '2026-07-29T12:48:00.000Z',
        'c6f4c1e070963eed3e048f3616fedfcfdc732d3f6c55a59dd1522d75f93f64176e033abfc82bab5eac3c2ebe5909fa33967e46a7a57b454bce21a3f04d1ad915',
        '1492477f16a62317084da8c6e19e00425cd51c1ec4919b85d31c14e289c990354bd7634a2c3096a619552545ae105586a22bd4cc96169590e7e8ab0ffe2a482d',
        'Interesting idea. I would like to see the next version.');


-- =====================================================
-- POSTS FOR TANYA
-- =====================================================

-- Tanya post 1: text
-- post_identity: f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               created_at)
VALUES ('f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93',
        'I am experimenting with a few ideas for making the application easier to use.', true, false, false, false,
        '2026-07-29T13:00:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll)
VALUES ('31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93', '2026-07-29T13:00:00.000Z',
        'f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401',
        'I am experimenting with a few ideas for making the application easier to use.', true, false, false, false);

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T13:00:00.000Z',
        'f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93',
        'I am experimenting with a few ideas for making the application easier to use.', true, false, false, false);

-- Comment 1 on Tanya post 1 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401',
        '2026-07-29T13:01:00.000Z',
        'ef1d29b88b38da0e4153f43a9b6b27265257124a1c62c390a8f0b76b0cea6175ebfbabb13d7edaa8438b361b01cf03be3bf6b49f660403557285ed05d9efc9c0',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Great work. The project is becoming more complete.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T13:01:00.000Z',
        'ef1d29b88b38da0e4153f43a9b6b27265257124a1c62c390a8f0b76b0cea6175ebfbabb13d7edaa8438b361b01cf03be3bf6b49f660403557285ed05d9efc9c0',
        'f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401',
        'Great work. The project is becoming more complete.');

-- Comment 2 on Tanya post 1 by Georgi
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401',
        '2026-07-29T13:02:00.000Z',
        'da0bac8ded9f5d6bd2b7b02867a1aa6b8227720261dc402259173f1f044cf5d75f8322f8a46fe22c0f12080c398950e45502918897888b359594b47b4ae59bd2',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        'This is a useful example and the result looks clean.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551', '2026-07-29T13:02:00.000Z',
        'da0bac8ded9f5d6bd2b7b02867a1aa6b8227720261dc402259173f1f044cf5d75f8322f8a46fe22c0f12080c398950e45502918897888b359594b47b4ae59bd2',
        'f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401',
        'This is a useful example and the result looks clean.');

-- Comment 3 on Tanya post 1 by Mariya
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401',
        '2026-07-29T13:03:00.000Z',
        '885a8fd84b3d78e5098298cd9c86525cd49bd41cd6c4575c2f4e6a37f70931500fed3bd1c559d4036e913b4be3932622a65e270fba7111533624dfa14d63ecad',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        'Good progress. Keep us updated when you add more features.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f', '2026-07-29T13:03:00.000Z',
        '885a8fd84b3d78e5098298cd9c86525cd49bd41cd6c4575c2f4e6a37f70931500fed3bd1c559d4036e913b4be3932622a65e270fba7111533624dfa14d63ecad',
        'f18f8b3add6e57cbdb76078c053bf65d70cca473a47e5208f9935330867d00adcbe6eebc2d07acdd9633e1cec1c0d134c697c75ddf3374c5e5d0f5a336572401',
        'Good progress. Keep us updated when you add more features.');

-- Tanya post 2: image + text
-- post_identity: 91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c
-- image_identity (random SHA-512): 4e0af850da13cba0696a9d58c48b19e23caf3f6b71f4e8726e4a01d78bb20bda825dc40678c83111cceb34b6796340077c449699abaa4c1f3a59a5bee1929436

INSERT INTO posts_by_identity (post_identity, author_identity, content, has_text, has_image, has_video, is_poll,
                               image_identity, created_at)
VALUES ('91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93',
        'A new design idea for the dashboard. I still have a few details to improve.', true, true, false, false,
        '4e0af850da13cba0696a9d58c48b19e23caf3f6b71f4e8726e4a01d78bb20bda825dc40678c83111cceb34b6796340077c449699abaa4c1f3a59a5bee1929436',
        '2026-07-29T13:15:00.000Z');

INSERT INTO posts_by_author (author_identity, created_at, post_identity, content, has_text, has_image, has_video,
                             is_poll, image_identity)
VALUES ('31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93', '2026-07-29T13:15:00.000Z',
        '91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c',
        'A new design idea for the dashboard. I still have a few details to improve.', true, true, false, false,
        '4e0af850da13cba0696a9d58c48b19e23caf3f6b71f4e8726e4a01d78bb20bda825dc40678c83111cceb34b6796340077c449699abaa4c1f3a59a5bee1929436');

INSERT INTO feed_by_user (user_identity, created_at, post_identity, author_identity, content, has_text, has_image,
                          has_video, is_poll, image_identity)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T13:15:00.000Z',
        '91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93',
        'A new design idea for the dashboard. I still have a few details to improve.', true, true, false, false,
        '4e0af850da13cba0696a9d58c48b19e23caf3f6b71f4e8726e4a01d78bb20bda825dc40678c83111cceb34b6796340077c449699abaa4c1f3a59a5bee1929436');

-- Comment 1 on Tanya post 2 by Me
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c',
        '2026-07-29T13:16:00.000Z',
        'f1e0dda9f7505a51fe8191aa52e15c4bbf5aa59df38013f81174f3f6c2b16d6f7ef3d12d194cb4133db2fec1b7591727029eeb9a10c139eee1ca2ba616f2aa66',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'I like this approach. It should work well for the application.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b', '2026-07-29T13:16:00.000Z',
        'f1e0dda9f7505a51fe8191aa52e15c4bbf5aa59df38013f81174f3f6c2b16d6f7ef3d12d194cb4133db2fec1b7591727029eeb9a10c139eee1ca2ba616f2aa66',
        '91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c',
        'I like this approach. It should work well for the application.');

-- Comment 2 on Tanya post 2 by Stoyan
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c',
        '2026-07-29T13:17:00.000Z',
        'bb8641a18fdf6071be4ca012365e32706ff5b6fc8d08049ab5e3c590d3244e25d123b0f6cc22d4d207b99bae1bbc191df86dc68a28330c2da3e1a81fb1aae6b2',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        'Looks promising. The implementation seems very practical.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627', '2026-07-29T13:17:00.000Z',
        'bb8641a18fdf6071be4ca012365e32706ff5b6fc8d08049ab5e3c590d3244e25d123b0f6cc22d4d207b99bae1bbc191df86dc68a28330c2da3e1a81fb1aae6b2',
        '91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c',
        'Looks promising. The implementation seems very practical.');

-- Comment 3 on Tanya post 2 by Konstantin
INSERT INTO comments_by_post (post_identity, created_at, comment_identity, author_identity, content)
VALUES ('91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c',
        '2026-07-29T13:18:00.000Z',
        '04601608fb48eb922cdc68de8df1d631cc8ca2b05bcf885b683a8f9b10977e5c7e3d0bbc7f4cc5876cd6da2f24db65fa8814aa41e241a8d02a118769b142fd7e',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        'Nice work. The structure is easy to understand.');

INSERT INTO comments_by_author (author_identity, created_at, comment_identity, post_identity, content)
VALUES ('c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85', '2026-07-29T13:18:00.000Z',
        '04601608fb48eb922cdc68de8df1d631cc8ca2b05bcf885b683a8f9b10977e5c7e3d0bbc7f4cc5876cd6da2f24db65fa8814aa41e241a8d02a118769b142fd7e',
        '91692344efdfae16a8018ed04954cf3b7190af2d4fc63387fcc35ba2dcba742b7b68167d39fc0d9311f6cb39916a132c902ef4e2829f765bc0fb34360211a15c',
        'Nice work. The structure is easy to understand.');


