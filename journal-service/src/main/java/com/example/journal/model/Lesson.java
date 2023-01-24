package com.example.journal.model;

import java.sql.Timestamp;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("lesson")
public class Lesson {
    @Id
    Long id;
    @Column("journal_id")
    Long journalId;
    @Column("subject_id")
    Long subjectId;
    @Column("theme_name")
    String themeName;
    @Column("date")
    Long dateTimestamp;
}
