package com.example.journal.converter;

import com.example.journal.dto.subject.SaveSubjectRequest;
import com.example.journal.dto.subject.SubjectByGroupInfoResponse;
import com.example.journal.dto.subject.SubjectResponse;
import com.example.journal.model.Subject;
import com.example.journal.model.SubjectByGroupInfo;
import org.mapstruct.Mapper;

@Mapper
public interface SubjectConverter {
    Subject fromDto(SaveSubjectRequest request);

    SubjectResponse toDto(Subject saveOrGet);

    SubjectByGroupInfoResponse toDto(SubjectByGroupInfo saveOrGet);
}
