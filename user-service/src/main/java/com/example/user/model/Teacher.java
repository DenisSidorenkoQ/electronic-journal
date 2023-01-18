package com.example.user.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("teacher")
public class Teacher {
    @Id
    Long id;
    @Column("user_id")
    Long userId;
    @Column("department_id")
    Long departmentId;
    String fio;
}
