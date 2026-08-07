-- KEYSPACE

CREATE KEYSPACE IF NOT EXISTS message_service
    WITH replication = {
        'class': 'NetworkTopologyStrategy',
        'datacenter1': 1
        }
     AND durable_writes = true;


USE message_service;


--  MESSAGES BY CONVERSATION

CREATE TABLE IF NOT EXISTS messages_by_conversation
(

    conversation_id text,

    created_at      timestamp,

    message_id      text,

    sender_id       text,

    recipient_id    text,

    content         text,

    PRIMARY KEY ((conversation_id), created_at, message_id )
)
            WITH CLUSTERING ORDER BY (created_at DESC, message_id ASC);


-- CONVERSATIONS BY USER

CREATE TABLE IF NOT EXISTS conversations_by_user
(

    user_id         text,

    last_message_at timestamp,

    conversation_id text,

    participant_id  text,

    PRIMARY KEY (
        (user_id),
         last_message_at,
         conversation_id
        )
)
    WITH CLUSTERING ORDER BY (
                              last_message_at DESC,
                              conversation_id ASC
        );