package com.example.journal.repository;

import com.example.journal.model.Mark;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface MarkRepository extends Repository<Mark, Long> {

    Mark save(final Mark mark);

    @Query("UPDATE mark SET number=:number WHERE lesson_id=:lessonId AND student_id=:studentId " +
            "RETURNING id, lesson_id, student_id, number")
    Mark update(@Param("lessonId") final Long lessonId, @Param("studentId") final Long studentId, @Param("number") final Integer number);

    @Query("SELECT * FROM mark WHERE student_id=:studentId AND lesson_id=:lessonId")
    Optional<Mark> getByLessonIdAndStudentId(@Param("lessonId") final Long lessonId, @Param("studentId") final Long studentId);

    @Query("SELECT * FROM mark WHERE lesson_id=:lessonId")
    List<Mark> getMarksByLessonId(@Param("lessonId") Long lessonId);

    @Query("SELECT * FROM mark WHERE student_id=:studentId AND lesson_id=:lessonId")
    Mark getMarkByStudentIdAndLessonId(@Param("studentId") Long studentId, @Param("lessonId") Long lessonId);

    @Query("SELECT mark.id, mark.student_id, mark.lesson_id, mark.number FROM mark " +
            "JOIN student s on s.id = mark.student_id " +
            "JOIN groups g on g.id = s.group_id " +
            "JOIN group_has_subject ghs on g.id = ghs.group_id " +
            "WHERE g.id=:groupId AND ghs.subject_id=:subjectId")
    List<Mark> getMarksBySubjectIdAndGroupId(@Param("groupId") Long groupId, @Param("subjectId") Long subjectId);
}
