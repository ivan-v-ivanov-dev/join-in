CREATE TABLE groups
(
    id          INT PRIMARY KEY,
    identity    VARCHAR(500) NOT NULL UNIQUE,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);


CREATE TABLE group_members
(
    id               INT PRIMARY KEY,
    group_identity   VARCHAR(500) NOT NULL,
    profile_identity VARCHAR(200) NOT NULL,

    CONSTRAINT fk_group_members_group
        FOREIGN KEY (group_identity)
            REFERENCES groups (identity)
            ON DELETE CASCADE
);

-- Prevents the same profile from joining the same group more than once.
CREATE UNIQUE INDEX uk_group_members_group_profile
    ON group_members (group_identity, profile_identity);

-- Supports finding all groups joined by a profile.
CREATE INDEX idx_group_members_profile_identity
    ON group_members (profile_identity);


CREATE TABLE group_join_requests
(
    id               INT PRIMARY KEY,
    group_identity   VARCHAR(500) NOT NULL,
    profile_identity VARCHAR(200) NOT NULL,
    status           VARCHAR(20)  NOT NULL DEFAULT 'PENDING',

    CONSTRAINT fk_group_join_requests_group
        FOREIGN KEY (group_identity)
            REFERENCES groups (identity)
            ON DELETE CASCADE,

    CONSTRAINT chk_group_join_requests_status
        CHECK (status IN ('PENDING', 'APPROVED', 'REJECTED'))
);

-- Supports retrieving requests for a group filtered by status.
CREATE INDEX idx_group_join_requests_group_status
    ON group_join_requests (group_identity, status);

-- Supports retrieving all join requests made by a profile.
CREATE INDEX idx_group_join_requests_profile_identity
    ON group_join_requests (profile_identity);

-- Prevents multiple identical requests for the same group and profile.
CREATE UNIQUE INDEX uk_group_join_requests_group_profile
    ON group_join_requests (group_identity, profile_identity);