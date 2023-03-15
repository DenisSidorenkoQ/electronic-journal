package com.example.journal.repository;

import com.example.journal.model.Mark;
import com.example.journal.model.SubjectAvgMark;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface MarkRepository extends Repository<Mark, Long> {

    @Query("INSERT INTO mark(lesson_id, student_id, number) VALUES (:lessonId, :studentId, :number)" +
            "ON CONFLICT (lesson_id, student_id) " +
            "DO UPDATE SET number=:number " +
            "RETURNING id, lesson_id, student_id, number")
    Mark upsert(@Param("lessonId") final Long lessonId, @Param("studentId") final Long studentId, @Param("number") final Integer number);

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

    @Query("SELECT subject_id, sub.name as subject_name, sub.time_to_study as time_to_study, ktt.name as knowledge_test_type_name, ROUND(AVG(mark.number), 2) as avg_mark FROM mark " +
            "JOIN lesson l on l.id = mark.lesson_id " +
            "JOIN subject sub on sub.id = l.subject_id " +
            "JOIN student stud on stud.id = mark.student_id " +
            "JOIN knowledge_test_type ktt on ktt.id = sub.knowledge_test_type_id " +
            "WHERE stud.id=:studentId GROUP BY (subject_id, subject_name, time_to_study, knowledge_test_type_name)")
    List<SubjectAvgMark> getAvgMarksByStudentIdAndSubjectId(@Param("studentId") Long studentId);
}
