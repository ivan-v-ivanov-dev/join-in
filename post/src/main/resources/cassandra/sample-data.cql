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
-- One example comment for each post
-- =====================================================

INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('5ae54cd25ee6f174be6eb2f14c9c38c475f7da941ed698fca2f338db34f878c5e51ec9f10228b037885c9ee058c93c6276df02b6aa6fbc53f60d53323117f3dd',
        '2026-07-28T10:01:00.000Z',
        'a96702fa954fb9964e24ea920869f0a90e4a8c09707535b9a86a0d32c3f710cc1c1f27bb5534e4cca6bdd41667e35e543f6a9a0361df8412a19ab742c1a34895',
        'sample-comment-author-001',
        'This sounds like an interesting project!');

INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('afe70797e1b617f524fbbec74d4f8ce4d292cef7ecd500965bf2278591d18c1096a7647f578f0cbafa5d080ef0ba30d4939ed4901c103b08fd326a22cafd0b72',
        '2026-07-28T10:06:00.000Z',
        'c4ec89be2c124e3fa06d2d617dfcfeecd3ea80a0cc481dcd560efc1d88ea239834bb7006c49d541891c5869d40e68acc19a4d6b77ba381fe2135089178a67ce7',
        'sample-comment-author-002',
        'The feed page looks clean and easy to use.');

INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('6c9c4561bb7c0a19fb372907575ab8868ce68b5b46a7a837323fa80a1b76ea422d6e3e2ae04eb5eac8274f9fac62024e79e1834a1611f29a6a207b9953226507',
        '2026-07-28T10:11:00.000Z',
        'd4ce0c306a637f0371718238649ff865681defce355b2af0d41e45fc424a4a81c2284ad695a926ceb977879d20c2b1c37f24ced22f02695e409685adee1048f3',
        'sample-comment-author-003',
        'Thanks for sharing this video.');

INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('2d9f88c586a48377495a3b9691ccc4d651ecf33ca55b735348d398e42f0304194ee08fbd72705b80cdab2b8ae8e24392ee2e4e5983a903225482f452ac592dbb',
        '2026-07-28T10:16:00.000Z',
        'aa576e2a6b590770148e1846666cc5deb8d93a95ec79d41a0dda28f33f5a1ad0289a473037af324c0d6e74c1a097ea5bb352d7c290ce4db5b68000714250afc6',
        'sample-comment-author-004',
        'Great development setup!');

INSERT INTO comments_by_post (post_identity,
                              created_at,
                              comment_identity,
                              author_identity,
                              content)
VALUES ('0319e23704162c7a8961bf0f2866724641559012007b0ee1ad724a49d532ada1851c2ebd9fd0c5637907a699b203ea28d09040aa7b5eab027a7b627ae6ba8fa9',
        '2026-07-28T10:21:00.000Z',
        'ce95474b36108e9b27d126694bf8664a501535be14222d2e52423ddad6a09607a4a6b0e8b1d39bad35a8a9ca3cace2456352db24fb8ce54af46f5fdc8e926752',
        'sample-comment-author-005',
        'Java is my favourite because of Spring Boot.');
