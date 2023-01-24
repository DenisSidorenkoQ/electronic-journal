package com.example.journal.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("study_pass")
public class StudyPass {
    @Id
    Long id;
    @Column("lesson_id")
    Long lessonId;
    @Column("student_id")
    Long studentId;
    Boolean pass;
}
