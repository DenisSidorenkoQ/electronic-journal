create table department
(
    id              BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    name            TEXT UNIQUE NOT NULL
);
