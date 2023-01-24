package com.example.journal.service;

import com.example.journal.model.Journal;
import com.example.journal.repository.JournalRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JournalService {
    private final JournalRepository journalRepository;

    public Optional<Journal> getByGroupId(final Long groupId) {
        return journalRepository.getByGroupId(groupId);
    }

    public Journal save(final Journal journal) {
        return journalRepository.save(journal);
    }

    public Optional<Journal> getById(final Long journalId) {
        return journalRepository.getById(journalId);
    }
}
