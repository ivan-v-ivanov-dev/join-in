USE post_service;

-- Text post
INSERT INTO posts_by_id (
    post_id,
    author_id,
    content,
    has_text,
    has_image,
    has_video,
    is_poll,
    comment_count,
    created_at
)
VALUES (
    'post-001',
    'user-001',
    'This is my first Cassandra post.',
    true,
    false,
    false,
    false,
    0,
    '2026-07-28T09:00:00Z'
);


-- Post with text and image
INSERT INTO posts_by_id (
    post_id,
    author_id,
    content,
    has_text,
    has_image,
    has_video,
    is_poll,
    image_id,
    comment_count,
    created_at
)
VALUES (
    'post-002',
    'user-001',
    'A photo from my holiday.',
    true,
    true,
    false,
    false,
    'image-8d4e2d10',
    2,
    '2026-07-28T09:15:00Z'
);


-- Image-only post
INSERT INTO posts_by_id (
    post_id,
    author_id,
    has_text,
    has_image,
    has_video,
    is_poll,
    image_id,
    comment_count,
    created_at
)
VALUES (
    'post-003',
    'user-002',
    false,
    true,
    false,
    false,
    'image-75a020b1',
    0,
    '2026-07-28T09:30:00Z'
);


-- YouTube video with text
INSERT INTO posts_by_id (
    post_id,
    author_id,
    content,
    has_text,
    has_image,
    has_video,
    is_poll,
    youtube_url,
    comment_count,
    created_at
)
VALUES (
    'post-004',
    'user-002',
    'An interesting video about Cassandra.',
    true,
    false,
    true,
    false,
    'https://www.youtube.com/watch?v=example',
    1,
    '2026-07-28T09:45:00Z'
);


-- Poll post
INSERT INTO posts_by_id (
    post_id,
    author_id,
    content,
    has_text,
    has_image,
    has_video,
    is_poll,
    poll_question,
    poll_options,
    comment_count,
    created_at
)
VALUES (
    'post-005',
    'user-003',
    'Vote for your preferred database.',
    true,
    false,
    false,
    true,
    'Which database do you prefer?',
    ['Cassandra', 'MongoDB', 'PostgreSQL'],
    3,
    '2026-07-28T10:00:00Z'
);