create table groups
(
    id              BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    name            TEXT NOT NULL
);

INSERT INTO groups (name) VALUES ('2312421421')
