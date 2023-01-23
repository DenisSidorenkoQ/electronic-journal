package com.example.journal.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("group_has_subject")
public class GroupHasSubject {
    @Column("group_id")
    Long groupId;
    @Column("teacher_id")
    Long teacherId;
    @Column("subject_id")
    Long subjectId;
}
