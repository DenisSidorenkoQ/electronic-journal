package com.example.journal.repository;

import com.example.journal.model.Subject;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface SubjectRepository extends Repository<Subject, Long> {

    @Query("SELECT * FROM subject WHERE name=:name")
    Optional<Subject> getByName(@Param("name") String name);

    @Query("INSERT INTO subject(name, knowledge_test_type_id) VALUES(:name, :knowledgeTestTypeId) RETURNING id, name, knowledge_test_type_id")
    Subject save(@Param("name") String name, @Param("knowledgeTestTypeId") Long knowledgeTestTypeId);

    @Query("SELECT * FROM subject WHERE id=:subjectId")
    Optional<Subject> getById(@Param("subjectId") Long subjectId);
}
