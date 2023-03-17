package com.example.journal.repository;

import com.example.journal.dto.subject.SubjectResponse;
import com.example.journal.model.Subject;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface SubjectRepository extends Repository<Subject, Long> {

    @Query("SELECT * FROM subject WHERE name=:name")
    Optional<Subject> getByName(@Param("name") final String name);

    Subject save(final Subject subject);

    @Query("SELECT * FROM subject WHERE id=:subjectId")
    Optional<Subject> getById(@Param("subjectId") final Long subjectId);

    @Query("SELECT subject.id as id, subject.name as name, knowledge_test_type_id, time_to_study FROM subject " +
            "JOIN knowledge_test_type ktt on ktt.id = subject.knowledge_test_type_id " +
            "JOIN group_has_subject ghs on subject.id = ghs.subject_id " +
            "JOIN teacher t on ghs.teacher_id = t.id " +
            "WHERE ghs.group_id=:groupId")
    List<Subject> getGroupListSubject(@Param("groupId") final Long groupId);

    @Query("SELECT * FROM subject " +
            "JOIN group_has_subject ghs ON subject.id = ghs.subject_id " +
            "WHERE ghs.teacher_id=:teacherId AND ghs.group_id=:groupId")
    List<Subject> getSubjectsByTeacherIdAndGroupId(@Param("teacherId") Long teacherId,
                                                           @Param("groupId") Long groupId);

    @Query("SELECT * FROM subject")
    List<Subject> getSubjectList();
}
