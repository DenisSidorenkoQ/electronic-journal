package com.example.journal.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("journal")
public class Journal {
    @Id
    Long id;
    @Column("group_id")
    Long groupId;
}
