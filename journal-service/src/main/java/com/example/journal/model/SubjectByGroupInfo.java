package com.example.journal.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Builder
@Value
public class SubjectByGroupInfo {
    @Id
    Long id;
    @Column("name")
    String subjectName;
    @Column("time_to_study")
    Long timeToStudy;
    @Column("testTypeName")
    String knowledgeTestTypeName;
    @Column("fio")
    String teacherFio;
}
