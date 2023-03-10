create table subject
(
    id                                  BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    name                                TEXT NOT NULL,
    knowledge_test_type_id              BIGINT NOT NULL,
    time_to_study                       BIGINT NOT NULL,
    FOREIGN KEY (knowledge_test_type_id) REFERENCES knowledge_test_type (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO subject (name, knowledge_test_type_id, time_to_study) VALUES ('ООП', 1, 100), ('Не ООП', 2, 10)
