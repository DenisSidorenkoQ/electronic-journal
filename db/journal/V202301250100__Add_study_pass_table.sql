create table study_pass
(
    id                BIGSERIAL NOT NULL UNIQUE,
    lesson_id         BIGINT NOT NULL,
    student_id        BIGINT NOT NULL,
    pass              BOOLEAN NOT NULL,
    FOREIGN KEY (lesson_id) REFERENCES lesson (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO study_pass (lesson_id, student_id, pass) VALUES (1, 1, false)
