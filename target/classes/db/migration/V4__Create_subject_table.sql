create table subject
(
    subject_id  serial unique primary key,
    teacher_id    int not null,
    subject_name varchar not null,
    CONSTRAINT fk_teacher_id
        FOREIGN KEY(teacher_id)
            REFERENCES teacher(teacher_id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO subject (teacher_id, subject_name)
VALUES
    (1, 'ПСП')
