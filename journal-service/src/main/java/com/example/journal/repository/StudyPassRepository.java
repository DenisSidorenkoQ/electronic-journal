package com.example.journal.repository;

import com.example.journal.model.StudyPass;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StudyPassRepository extends Repository<StudyPass, Long> {

    @Query("INSERT INTO study_pass(lesson_id, student_id, pass) VALUES (:lessonId, :studentId, :pass)" +
            "ON CONFLICT (lesson_id, student_id) " +
            "DO UPDATE SET pass=:pass " +
            "RETURNING id, lesson_id, student_id, pass")
    StudyPass upsert(@Param("lessonId") Long lessonId, @Param("studentId") Long studentId, @Param("pass") Boolean pass);

    @Query("SELECT study_pass.id, study_pass.lesson_id, study_pass.student_id, study_pass.pass FROM study_pass " +
            "JOIN lesson l on l.id = study_pass.lesson_id " +
            "JOIN group_has_subject ghs on l.subject_id = ghs.subject_id " +
            "WHERE ghs.subject_id=:subjectId AND ghs.group_id=:groupId")
    List<StudyPass> getBySubjectIdAndGroupId(@Param("groupId") Long groupId, @Param("subjectId") Long subjectId);
}
