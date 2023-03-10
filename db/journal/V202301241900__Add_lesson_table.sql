create table lesson
(
    id                BIGSERIAL NOT NULL UNIQUE,
    journal_id        BIGINT NOT NULL,
    subject_id        BIGINT NOT NULL,
    theme_name        TEXT NOT NULL,
    date              BIGINT NOT NULL,
    FOREIGN KEY (journal_id) REFERENCES journal (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (subject_id) REFERENCES subject (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO lesson (journal_id, subject_id, theme_name, date) VALUES (1, 1, 'ООП', 21312412412)
