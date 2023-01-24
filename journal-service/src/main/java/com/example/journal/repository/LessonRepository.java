package com.example.journal.repository;

import com.example.journal.model.KnowledgeTestType;
import com.example.journal.model.Lesson;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface LessonRepository extends Repository<Lesson, Long> {

    Lesson save(final Lesson lesson);

    @Query("SELECT * FROM lesson WHERE id=:lessonId")
    Optional<Lesson> getById(@Param("lessonId") final Long lessonId);

    @Query("SELECT lesson.id, lesson.theme_name, lesson.date FROM lesson " +
            "JOIN journal j ON j.id = lesson.journal_id " +
            "WHERE j.group_id=:groupId AND lesson.subject_id=:subjectId")
    List<Lesson> getAllLessonsByGroupIdAndSubjectId(@Param("groupId") final Long groupId, @Param("subjectId") final Long subjectId);
}
