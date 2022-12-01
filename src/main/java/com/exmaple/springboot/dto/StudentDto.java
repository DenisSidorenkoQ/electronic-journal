package com.exmaple.springboot.dto;

import lombok.Value;

@Value
public class StudentDto {
    int studentId;
    String fio;
    Character sex;
}
