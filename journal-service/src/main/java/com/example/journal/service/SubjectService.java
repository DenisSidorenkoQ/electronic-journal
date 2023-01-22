package com.example.journal.service;

import com.example.journal.model.Subject;
import com.example.journal.repository.SubjectRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public Optional<Subject> getByName(final String name) {
        return subjectRepository.getByName(name);
    }

    public Subject save(Subject subject) {
        return subjectRepository.save(subject.getName(), subject.getKnowledgeTestTypeId());
    }

    public Optional<Subject> getById(final Long subjectId) {
        return subjectRepository.getById(subjectId);
    }
}
