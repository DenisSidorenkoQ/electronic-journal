ALTER TABLE study_pass
    ADD CONSTRAINT uniquePassOnLesson UNIQUE (lesson_id, student_id)
