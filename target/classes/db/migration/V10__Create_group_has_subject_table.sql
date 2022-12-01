create table group_has_subject
(
    group_id int not null,
    subject_id int not null,
    CONSTRAINT fk_group_id
        FOREIGN KEY(group_id)
            REFERENCES "group"(group_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_subject_id
        FOREIGN KEY(subject_id)
            REFERENCES subject(subject_id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO group_has_subject (group_id, subject_id)
VALUES
    (1, 1)
