package com.example.user.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("\"user\"")
public class User {
    @Id
    Long id;
    String login;
    String password;
    @Column("role_id")
    Integer roleId;
}
