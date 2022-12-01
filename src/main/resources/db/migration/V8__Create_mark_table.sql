create table mark
(
    mark_id  serial unique primary key,
    student_id int not null,
    subject_id int not null,
    date date,
    number int,
    CONSTRAINT fk_student_id
        FOREIGN KEY(student_id)
            REFERENCES student(student_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_subject_id
        FOREIGN KEY(subject_id)
            REFERENCES subject(subject_id) ON UPDATE CASCADE ON DELETE CASCADE
);
