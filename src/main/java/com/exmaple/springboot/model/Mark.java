package com.exmaple.springboot.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Value
@Builder
@Table("mark")
public class Mark {
    int number;
    LocalDate date;
}
