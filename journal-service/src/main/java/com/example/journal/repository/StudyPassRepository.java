package com.example.journal.repository;

import com.example.journal.dto.study_pass.StudyPassResponse;
import com.example.journal.model.Mark;
import com.example.journal.model.StudyPass;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StudyPassRepository extends Repository<StudyPass, Long> {

    StudyPass save(final StudyPass studyPass);

    @Query("UPDATE study_pass SET pass=:pass WHERE student_id=:studentId AND lesson_id=:lessonId " +
            "RETURNING id, lesson_id, student_id, pass")
    StudyPass update(@Param("lessonId") final Long lessonId,
                     @Param("studentId") final Long studentID,
                     @Param("pass") final Boolean pass);

    @Query("SELECT * FROM study_pass WHERE lesson_id=:lessonId AND student_id=:studentId")
    Optional<Mark> getByLessonIdAndStudentId(@Param("lessonId") final Long lessonId, @Param("studentId") final Long studentId);

    @Query("SELECT * FROM study_pass WHERE lesson_id=:lessonId")
    List<StudyPass> getAllPassByLessonId(@Param("lessonId") Long lessonId);

    @Query("SELECT study_pass.id, study_pass.lesson_id, study_pass.student_id, study_pass.pass FROM study_pass " +
            "JOIN lesson l on l.id = study_pass.lesson_id " +
            "JOIN group_has_subject ghs on l.subject_id = ghs.subject_id " +
            "WHERE ghs.subject_id=:subjectId AND ghs.group_id=:groupId")
    List<StudyPass> getBySubjectIdAndGroupId(@Param("groupId") Long groupId, @Param("subjectId") Long subjectId);
}
