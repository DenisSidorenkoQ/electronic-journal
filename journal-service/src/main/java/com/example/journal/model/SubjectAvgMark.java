package com.example.journal.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.relational.core.mapping.Column;

@Builder
@Value
public class SubjectAvgMark {
    @Column("subject_id")
    Long subjectId;
    @Column("subject_name")
    String subjectName;
    @Column("time_to_study")
    Long timeToStudy;
    @Column("knowledge_test_type_name")
    String knowledgeTestType;
    @Column("avg_mark")
    Double avgMark;
}
