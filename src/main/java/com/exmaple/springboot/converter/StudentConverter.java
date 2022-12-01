package com.exmaple.springboot.converter;

import com.exmaple.springboot.dto.StudentDto;
import com.exmaple.springboot.model.Mark;
import com.exmaple.springboot.model.Student;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentConverter {
    List<StudentDto> toDto(List<Student> students);
    Map<StudentDto, List<Mark>> toDto(Map<Student, List<Mark>> studentWithMarkMap);
}

