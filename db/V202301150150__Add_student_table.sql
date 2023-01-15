create table student
(
    id              BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    user_id         BIGINT UNIQUE NOT NULL,
    group_id        BIGINT NOT NULL,
    fio             TEXT NOT NULL,
    sex             CHAR NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user" (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (group_id) REFERENCES "group" (id) ON DELETE CASCADE ON UPDATE CASCADE
);
