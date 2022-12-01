create table teacher
(
    teacher_id  serial unique primary key,
    user_id    int not null unique,
    fio varchar not null,
    department_id int not null,
    CONSTRAINT fk_user_id
        FOREIGN KEY(user_id)
            REFERENCES "user"(user_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_department_id
        FOREIGN KEY(department_id)
            REFERENCES department(department_id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO teacher (user_id, fio, department_id)
VALUES
    (4, 'Kalinin M. A.', 1)
