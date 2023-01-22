package com.example.journal.converter;

import com.example.journal.dto.subject.AddSubjectToTheGroupRequest;
import com.example.journal.dto.subject.GroupHasSubjectResponse;
import com.example.journal.model.GroupHasSubject;
import org.mapstruct.Mapper;

@Mapper
public interface GroupHasSubjectConverter {
    GroupHasSubject fromDto(AddSubjectToTheGroupRequest request);

    GroupHasSubjectResponse toDto(GroupHasSubject addSubjectToTheGroup);
}
