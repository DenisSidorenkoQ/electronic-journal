package com.example.user.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("users")
public class UserAndRole {
    @Id
    Long id;
    String login;
    String password;
    @Column("name")
    String roleName;
}
