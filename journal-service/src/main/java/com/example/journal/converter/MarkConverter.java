package com.example.journal.converter;

import com.example.journal.dto.mark.MarkResponse;
import com.example.journal.dto.mark.SaveOrUpdateMarkRequest;
import com.example.journal.model.Mark;
import org.mapstruct.Mapper;

@Mapper
public interface MarkConverter {
    Mark fromDto(SaveOrUpdateMarkRequest request);


    MarkResponse toDto(Mark mark);
}
