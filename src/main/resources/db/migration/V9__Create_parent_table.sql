create table parent
(
    parent_id  serial unique primary key,
    user_id int not null,
    child_id int not null,
    CONSTRAINT fk_user_id
        FOREIGN KEY(user_id)
            REFERENCES "user"(user_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_chile_id
        FOREIGN KEY(child_id)
            REFERENCES student(student_id) ON UPDATE CASCADE ON DELETE CASCADE
);
