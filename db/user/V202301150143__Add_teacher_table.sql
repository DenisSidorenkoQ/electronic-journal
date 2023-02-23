create table teacher
(
    id              BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    user_id         BIGINT UNIQUE NOT NULL,
    department_id   BIGINT NOT NULL,
    fio             TEXT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (department_id) REFERENCES department (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO teacher (user_id, department_id, fio) VALUES (3, 1, 'Денис Препод')
