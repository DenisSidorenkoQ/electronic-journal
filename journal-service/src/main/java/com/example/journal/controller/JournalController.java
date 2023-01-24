package com.example.journal.controller;

import com.example.journal.converter.JournalConverter;
import com.example.journal.dto.journal.GetJournalByGroupIdRequest;
import com.example.journal.dto.journal.JournalResponse;
import com.example.journal.dto.journal.SaveJournalRequest;
import com.example.journal.facade.JournalFacade;
import com.example.journal.model.Journal;
import com.example.journal.model.KnowledgeTestType;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{journalId}")
    ResponseEntity getById(@PathVariable final Long journalId) {
        Optional<Journal> journal = journalFacade.getById(journalId);

        return journal
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping
    ResponseEntity getByGroupId(@RequestBody GetJournalByGroupIdRequest request) {
        Optional<Journal> journal = journalFacade.getByGroupId(request.getGroupId());

        return journal
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }
}
