package com.example.journal.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("subject")
public class Subject {
    @Id
    Long id;
    String name;
    @Column("knowledge_test_type_id")
    Long knowledgeTestTypeId;
}
