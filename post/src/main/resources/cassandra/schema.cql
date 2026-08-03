CREATE KEYSPACE IF NOT EXISTS post_service
    WITH replication = {
        'class': 'NetworkTopologyStrategy',
        'datacenter1': 1
        }
     AND durable_writes = true;

USE post_service;


-- =====================================================
-- Poll option user-defined type
-- =====================================================

CREATE TYPE IF NOT EXISTS poll_option
    (
        option_identity text,
        option_text     text,
        vote_count      int
    );


-- =====================================================
-- Find one post by its identity
--
-- SELECT *
-- FROM posts_by_id
-- WHERE post_identity = ?;
-- =====================================================

CREATE TABLE IF NOT EXISTS posts_by_identity
(
    post_identity   text PRIMARY KEY,

    author_identity text,
    group_identity  text,

    content         text,

    has_text        boolean,
    has_image       boolean,
    has_video       boolean,
    is_poll         boolean,

    image_identity  text,
    youtube_url     text,

    poll_question   text,
    poll_options    list<frozen<poll_option>>,

    created_at      timestamp
);


-- =====================================================
-- Find posts belonging to one author
--
-- SELECT *
-- FROM posts_by_author
-- WHERE author_identity = ?;
-- =====================================================

CREATE TABLE IF NOT EXISTS posts_by_author
(
    author_identity text,
    created_at      timestamp,
    post_identity   text,

    group_identity  text,

    content         text,

    has_text        boolean,
    has_image       boolean,
    has_video       boolean,
    is_poll         boolean,

    image_identity  text,
    youtube_url     text,

    poll_question   text,
    poll_options    list<frozen<poll_option>>,

    PRIMARY KEY ( (author_identity), created_at, post_identity )
)
            WITH CLUSTERING ORDER BY (created_at DESC, post_identity ASC);


-- =====================================================
-- Find posts belonging to one group
--
-- SELECT *
-- FROM posts_by_group
-- WHERE group_identity = ?;
-- =====================================================

CREATE TABLE IF NOT EXISTS posts_by_group
(
    group_identity  text,
    created_at      timestamp,
    post_identity   text,

    author_identity text,

    content         text,

    has_text        boolean,
    has_image       boolean,
    has_video       boolean,
    is_poll         boolean,

    image_identity  text,
    youtube_url     text,

    poll_question   text,
    poll_options    list<frozen<poll_option>>,

    PRIMARY KEY ( (group_identity), created_at, post_identity )
)
            WITH CLUSTERING ORDER BY (created_at DESC, post_identity ASC);

-- =====================================================
-- Find comments belonging to one post
--
-- SELECT *
-- FROM comments_by_post
-- WHERE post_identity = ?
-- LIMIT 20;
-- =====================================================

CREATE TABLE IF NOT EXISTS comments_by_post
(
    post_identity    text,

    created_at       timestamp,
    comment_identity text,

    author_identity  text,
    content          text,

    PRIMARY KEY ((post_identity), created_at, comment_identity )
)
    WITH CLUSTERING ORDER BY (created_at ASC, comment_identity ASC);

CREATE TABLE IF NOT EXISTS feed_by_user
(
    user_identity   text,
    created_at      timestamp,
    post_identity   text,

    author_identity text,
    group_identity  text,

    content         text,

    has_text        boolean,
    has_image       boolean,
    has_video       boolean,
    is_poll         boolean,

    image_identity  text,
    youtube_url     text,

    poll_question   text,
    poll_options    list<frozen<poll_option>>,

    PRIMARY KEY ( (user_identity), created_at, post_identity )
)
            WITH CLUSTERING ORDER BY (created_at DESC, post_identity ASC);

-- =====================================================
-- Find or count comments belonging to one author
--
-- SELECT COUNT(*)
-- FROM comments_by_author
-- WHERE author_identity = ?;
-- =====================================================

CREATE TABLE IF NOT EXISTS comments_by_author
(
    author_identity  text,
    created_at       timestamp,
    comment_identity text,

    post_identity    text,
    content          text,

    PRIMARY KEY (
        (author_identity),
         created_at,
         comment_identity
        )
)
    WITH CLUSTERING ORDER BY (
                              created_at DESC,
                              comment_identity ASC
        );