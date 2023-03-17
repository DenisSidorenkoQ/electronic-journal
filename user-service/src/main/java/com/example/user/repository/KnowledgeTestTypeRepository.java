package com.example.user.repository;

import com.example.user.model.Group;
import com.example.user.model.KnowledgeTestType;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

public interface KnowledgeTestTypeRepository extends Repository<KnowledgeTestType, Long> {

    @Query("SELECT * FROM knowledge_test_type")
    List<KnowledgeTestType> getKnowledgeTestTypeList();
}
