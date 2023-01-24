package com.example.journal.converter;

import com.example.journal.dto.mark.MarkResponse;
import com.example.journal.dto.mark.SaveMarkRequest;
import com.example.journal.model.Mark;
import org.mapstruct.Mapper;

@Mapper
public interface MarkConverter {
    Mark fromDto(SaveMarkRequest request);


    MarkResponse toDto(Mark mark);
}
