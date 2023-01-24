package com.example.journal.converter;

import com.example.journal.dto.journal.JournalResponse;
import com.example.journal.dto.journal.SaveJournalRequest;
import com.example.journal.model.Journal;
import org.mapstruct.Mapper;

@Mapper
public interface JournalConverter {
    Journal fromDto(SaveJournalRequest request);

    JournalResponse toDto(Journal saveOrGet);
}
