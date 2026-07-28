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
