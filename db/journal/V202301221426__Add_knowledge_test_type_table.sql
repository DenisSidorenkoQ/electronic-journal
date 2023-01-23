create table knowledge_test_type
(
    id              BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    name            TEXT NOT NULL
);

INSERT INTO knowledge_test_type (name) VALUES ('Экзамен'), ('Зачет')
