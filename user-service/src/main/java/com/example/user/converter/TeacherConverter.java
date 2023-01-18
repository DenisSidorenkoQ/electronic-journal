package com.example.user.converter;

import com.example.user.dto.teacher.SaveTeacherRequest;
import com.example.user.dto.teacher.TeacherResponse;
import com.example.user.model.Teacher;
import org.mapstruct.Mapper;

@Mapper
public interface TeacherConverter {
    TeacherResponse toDto(final Teacher teacher);

    Teacher fromDto(final SaveTeacherRequest request);
}
