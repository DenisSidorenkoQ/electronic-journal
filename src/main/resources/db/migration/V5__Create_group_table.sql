create table "group"
(
    group_id  serial unique primary key,
    group_name varchar not null
);

INSERT INTO "group" (group_name)
VALUES
    ('2020')


