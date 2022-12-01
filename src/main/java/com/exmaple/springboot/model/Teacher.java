package com.exmaple.springboot.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Value
@Builder
@Table("teacher")
public class Teacher {
    @Id
    @Column("teacher_id")
    int teacherId;
    String fio;
}
