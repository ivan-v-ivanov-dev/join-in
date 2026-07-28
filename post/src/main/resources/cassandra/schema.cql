CREATE KEYSPACE IF NOT EXISTS post_service
WITH replication = {
    'class': 'SimpleStrategy',
    'replication_factor': 1
};

USE post_service;

CREATE TABLE IF NOT EXISTS posts_by_id (
    post_id text PRIMARY KEY,
    author_id text,
    group_id text,
    content text,

    has_text boolean,
    has_image boolean,
    has_video boolean,
    is_poll boolean,

    image_id text,
    youtube_url text,

    poll_question text,
    poll_options list<text>,

    comment_count int,
    created_at timestamp
);