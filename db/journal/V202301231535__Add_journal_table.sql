create table journal
(
    id              BIGSERIAL NOT NULL UNIQUE,
    group_id        BIGINT NOT NULL UNIQUE,
    FOREIGN KEY (group_id) REFERENCES groups (id) ON DELETE CASCADE ON UPDATE CASCADE
);
