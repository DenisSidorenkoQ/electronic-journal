package com.example.user.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("admin")
public class Admin {
    @Id
    Long id;
    @Column("user_id")
    Long userId;
    String fio;
}
