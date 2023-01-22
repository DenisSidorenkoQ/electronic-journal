package com.example.journal.repository;

import com.example.journal.model.Subject;
import com.example.journal.model.SubjectByGroupInfo;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface SubjectRepository extends Repository<Subject, Long> {

    @Query("SELECT * FROM subject WHERE name=:name")
    Optional<Subject> getByName(@Param("name") final String name);

    @Query("INSERT INTO subject(name, time_to_study, knowledge_test_type_id) VALUES(:name, :timeToStudy, :knowledgeTestTypeId) RETURNING id, name, knowledge_test_type_id")
    Subject save(@Param("name") String name, @Param("timeToStudy") final Long timeToStudy, @Param("knowledgeTestTypeId") final Long knowledgeTestTypeId);

    @Query("SELECT * FROM subject WHERE id=:subjectId")
    Optional<Subject> getById(@Param("subjectId") final Long subjectId);

    @Query("SELECT subject.id, subject.name, subject.time_to_study, ktt.name as testTypeName, t.fio FROM subject " +
            "JOIN knowledge_test_type ktt on ktt.id = subject.knowledge_test_type_id " +
            "JOIN group_has_subject ghs on subject.id = ghs.subject_id " +
            "JOIN teacher t on ghs.teacher_id = t.id " +
            "WHERE ghs.group_id=:groupId")
    List<SubjectByGroupInfo> getGroupListSubject(@Param("groupId") final Long groupId);
}
