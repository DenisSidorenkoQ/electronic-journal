package com.example.journal.converter;

import com.example.journal.dto.subject.SaveSubjectRequest;
import com.example.journal.dto.subject.SubjectResponse;
import com.example.journal.model.Subject;
import org.mapstruct.Mapper;

@Mapper
public interface SubjectConverter {
    Subject fromDto(SaveSubjectRequest request);

    SubjectResponse toDto(Subject saveOrGet);

}
