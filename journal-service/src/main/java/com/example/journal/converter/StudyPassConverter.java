package com.example.journal.converter;

import com.example.journal.dto.study_pass.SaveStudyPassRequest;
import com.example.journal.dto.study_pass.StudyPassResponse;
import com.example.journal.model.StudyPass;
import org.mapstruct.Mapper;

@Mapper
public interface StudyPassConverter {
    StudyPass fromDto(SaveStudyPassRequest request);

    StudyPassResponse toDto(StudyPass studyPass);
}
