ALTER TABLE mark
    ADD CONSTRAINT uniqueMarkOnLesson UNIQUE (lesson_id, student_id)
