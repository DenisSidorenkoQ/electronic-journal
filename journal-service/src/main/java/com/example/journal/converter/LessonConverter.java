package com.example.journal.converter;

import com.example.journal.dto.lesson.LessonResponse;
import com.example.journal.dto.lesson.SaveLessonRequest;
import com.example.journal.model.Lesson;
import org.mapstruct.Mapper;

@Mapper
public interface LessonConverter {
    Lesson fromDto(SaveLessonRequest request);

    LessonResponse toDto(Lesson save);
}
