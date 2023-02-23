create table users
(
    id         BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    login      TEXT UNIQUE NOT NULL,
    password   TEXT NOT NULL,
    role_id       BIGINT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO users (login, password, role_id) VALUES ('DenisStudent', '1111', 2), ('DenisAdmin', '1111', 1), ('DenisTeacher', '1111', 3)
