create table subject
(
    id                          BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    name                        TEXT NOT NULL,
    knowledge_test_type_id      BIGINT NOT NULL,
    FOREIGN KEY (knowledge_test_type_id) REFERENCES knowledge_test_type (id) ON DELETE CASCADE ON UPDATE CASCADE
);
