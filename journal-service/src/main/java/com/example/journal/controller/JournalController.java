package com.example.journal.controller;

import com.example.journal.converter.JournalConverter;
import com.example.journal.dto.journal.JournalResponse;
import com.example.journal.dto.journal.SaveJournalRequest;
import com.example.journal.facade.JournalFacade;
import com.example.journal.model.Journal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/journal")
@RequiredArgsConstructor
public class JournalController {
    private final JournalConverter converter;
    private final JournalFacade journalFacade;

    @PostMapping
    JournalResponse saveOrGet(@RequestBody SaveJournalRequest request) {
        Journal journal = converter.fromDto(request);

        return converter.toDto(journalFacade.saveOrGet(journal));
    }
}
