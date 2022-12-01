package com.exmaple.springboot.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Value
@Builder
@Table("student")
public class Student {
    @Id
    @Column("student_id")
    int studentId;
    @Column("group_id")
    int groupId;
    String fio;
    Character sex;
}
