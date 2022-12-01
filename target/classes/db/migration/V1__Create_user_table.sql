create table "user"
(
    user_id  serial unique primary key,
    login    varchar not null unique,
    password varchar not null,
    role varchar not null
);

INSERT INTO "user" (login, password, role)
VALUES
    ('Denis', '1111', 'student'),
    ('German', '1111', 'student'),
    ('Maxim', '1111', 'student'),
    ('Kalinin M.A.', '1111', 'teacher')


