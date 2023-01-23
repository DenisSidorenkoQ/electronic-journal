create table journal
(
    id        BIGSERIAL NOT NULL UNIQUE,
    group_id        BIGINT NOT NULL UNIQUE,
    FOREIGN KEY (group_id) REFERENCES "group" (id) ON DELETE CASCADE ON UPDATE CASCADE
);
