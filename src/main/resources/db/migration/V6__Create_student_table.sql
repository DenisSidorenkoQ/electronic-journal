create table student
(
    student_id  serial unique primary key,
    user_id    int not null unique,
    group_id int not null,
    fio varchar not null,
    sex varchar not null,
    CONSTRAINT fk_user_id
        FOREIGN KEY(user_id)
            REFERENCES "user"(user_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_group_id
        FOREIGN KEY(group_id)
            REFERENCES "group"(group_id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO student (user_id, group_id, fio, sex)
VALUES
    (1, 1, 'Сидоренко Д.Д.', 'М'),
    (2, 1, 'Жук Г.А.', 'М'),
    (3, 1, 'Валентюкевич М.А.', 'М')

