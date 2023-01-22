package com.example.user.converter;

import com.example.user.dto.student.SaveStudentRequest;
import com.example.user.dto.student.StudentResponse;
import com.example.user.model.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentConverter {
    StudentResponse toDto(final Student student);

    Student fromDto(final SaveStudentRequest request);
}
