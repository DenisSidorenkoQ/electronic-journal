package com.example.journal.repository;

import com.example.journal.model.Mark;
import com.example.journal.model.StudyPass;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StudyPassRepository extends Repository<StudyPass, Long> {

    @Query("SELECT * FROM study_pass WHERE lesson_id=:lessonId AND student_id=:studentId")
    Optional<Mark> getByLessonIdAndStudentId(@Param("lessonId") final Long lessonId, @Param("studentId") final Long studentId);

    @Query("UPDATE study_pass SET pass=:pass WHERE student_id=:studentId AND lesson_id=:lessonId " +
            "RETURNING id, lesson_id, student_id, pass")
    StudyPass update(@Param("lessonId") final Long lessonId,
                     @Param("studentId") final Long studentID,
                     @Param("pass") final Boolean pass);

    StudyPass save(final StudyPass studyPass);
}
