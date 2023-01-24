package com.example.journal.facade;

import com.example.journal.model.Journal;
import com.example.journal.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JournalFacade {
    private final JournalService journalService;


    public Journal saveOrGet(final Journal journal) {
        return journalService.getByGroupId(journal.getGroupId())
                .orElseGet(() -> journalService.save(journal));
    }
}
