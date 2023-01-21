create table admin
(
    id              BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    user_id         BIGINT UNIQUE NOT NULL,
    fio             TEXT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user" (id) ON DELETE CASCADE ON UPDATE CASCADE
);
