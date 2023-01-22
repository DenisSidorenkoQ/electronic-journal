package com.example.journal.repository;


import com.example.journal.model.KnowledgeTestType;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface KnowledgeTestTypeRepository extends Repository<KnowledgeTestType, Long> {

    @Query("INSERT INTO knowledge_test_type(name) VALUES(:name) RETURNING id, name")
    KnowledgeTestType save(@Param("name") final String name);

    @Query("SELECT * FROM knowledge_test_type WHERE name=:name")
    Optional<KnowledgeTestType> getByName(@Param("name") final String name);
}
