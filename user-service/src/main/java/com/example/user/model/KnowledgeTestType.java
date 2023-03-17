package com.example.user.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("knowledge_test_type")
public class KnowledgeTestType {
    @Id
    Long id;
    String name;
}
