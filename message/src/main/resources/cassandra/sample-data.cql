USE message_service;

-- Current user:
-- 429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b
--
-- conversation_id rule:
--
-- Java:
--
-- if (userId1.compareTo(userId2) <= 0) {
--     return userId1 + "_" + userId2;
-- }
-- return userId2 + "_" + userId1;

-- ============================================================
-- FRIEND 1
-- ============================================================

INSERT INTO messages_by_conversation (conversation_id,
                                      created_at,
                                      message_id,
                                      sender_id,
                                      recipient_id,
                                      content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        '2026-08-07T07:01:00Z',
        'MSG-001',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Hey, how are you?');

INSERT INTO messages_by_conversation (conversation_id,
                                      created_at,
                                      message_id,
                                      sender_id,
                                      recipient_id,
                                      content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        '2026-08-07T07:02:00Z',
        'MSG-002',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        'I am good, thanks!');

INSERT INTO conversations_by_user (user_id,
                                   last_message_at,
                                   conversation_id,
                                   participant_id)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-08-07T07:02:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        '9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91');

INSERT INTO conversations_by_user (user_id,
                                   last_message_at,
                                   conversation_id,
                                   participant_id)
VALUES ('9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        '2026-08-07T07:02:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b');



-- ============================================================
-- FRIEND 2
-- ============================================================

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        '2026-08-07T06:51:00Z',
        'MSG-003',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        'Are you free later today?');

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        '2026-08-07T06:52:00Z',
        'MSG-004',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Yes, after work.');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-08-07T06:52:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        '2026-08-07T06:52:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b');



-- ============================================================
-- FRIEND 3
-- ============================================================

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        '2026-08-07T06:41:00Z',
        'MSG-005',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Did you see the new post?');

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        '2026-08-07T06:42:00Z',
        'MSG-006',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        'Yes, I just saw it.');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-08-07T06:42:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        '2026-08-07T06:42:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b');



-- ============================================================
-- FRIEND 4
-- ============================================================

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        '2026-08-07T06:31:00Z',
        'MSG-007',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        'Hello!');

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        '2026-08-07T06:32:00Z',
        'MSG-008',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Hi!');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-08-07T06:32:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        '2026-08-07T06:32:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b');



-- ============================================================
-- FRIEND 5
-- ============================================================

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        '2026-08-07T06:21:00Z',
        'MSG-009',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'What are you doing today?');

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        '2026-08-07T06:22:00Z',
        'MSG-010',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        'Working on my project.');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-08-07T06:22:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        '2026-08-07T06:22:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b');



-- ============================================================
-- FRIEND 6
-- ============================================================

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        '2026-08-07T06:11:00Z',
        'MSG-011',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        'How is everything?');

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        '2026-08-07T06:12:00Z',
        'MSG-012',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Everything is fine.');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-08-07T06:12:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        '2026-08-07T06:12:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b');



-- ============================================================
-- FRIEND 7
-- ============================================================

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        '2026-08-07T06:01:00Z',
        'MSG-013',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Coffee tomorrow?');

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        '2026-08-07T06:02:00Z',
        'MSG-014',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        'Sure!');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-08-07T06:02:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        '519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        '2026-08-07T06:02:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b');


-- FRIEND 8

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        '2026-08-07T05:51:00Z',
        'MSG-015',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        'Have a nice day!');

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        '2026-08-07T05:52:00Z',
        'MSG-016',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'You too!');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-08-07T05:52:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        'a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        '2026-08-07T05:52:00Z',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b_a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b');


-- FRIEND 9

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93_429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-08-07T05:41:00Z',
        'MSG-017',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        'Are you online?');

INSERT INTO messages_by_conversation (conversation_id, created_at, message_id,
                                      sender_id, recipient_id, content)
VALUES ('31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93_429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-08-07T05:42:00Z',
        'MSG-018',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93',
        'Yes, I am here.');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '2026-08-07T05:42:00Z',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93_429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93');

INSERT INTO conversations_by_user (user_id, last_message_at, conversation_id, participant_id)
VALUES ('31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93',
        '2026-08-07T05:42:00Z',
        '31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93_429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b',
        '429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b');