create table lesson
(
    id                BIGSERIAL NOT NULL UNIQUE,
    journal_id        BIGINT NOT NULL,
    subject_id        BIGINT NOT NULL,
    theme_name        TEXT NOT NULL,
    date              DATE NOT NULL,
    FOREIGN KEY (journal_id) REFERENCES journal (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (subject_id) REFERENCES subject (id) ON DELETE CASCADE ON UPDATE CASCADE
);
