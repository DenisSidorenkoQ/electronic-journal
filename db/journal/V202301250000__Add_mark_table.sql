create table mark
(
    id                BIGSERIAL NOT NULL UNIQUE,
    lesson_id         BIGINT NOT NULL,
    student_id        BIGINT NOT NULL,
    number            INT NOT NULL,
    FOREIGN KEY (lesson_id) REFERENCES lesson (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE ON UPDATE CASCADE
);
