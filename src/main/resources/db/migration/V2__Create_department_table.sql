create table department
(
    department_id serial unique primary key,
    department_name varchar not null
);

INSERT INTO department (department_name)
VALUES
    ('IT')
