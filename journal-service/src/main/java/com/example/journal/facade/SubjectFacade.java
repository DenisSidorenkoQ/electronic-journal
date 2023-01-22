package com.example.journal.facade;

import com.example.journal.model.Subject;
import com.example.journal.service.SubjectService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectFacade {
    private final SubjectService subjectService;

    public Subject saveOrGet(final Subject subject) {
        return subjectService.getByName(subject.getName())
                .orElseGet(() -> subjectService.save(subject));
    }

    public Optional<Subject> getById(final Long subjectId) {
        return subjectService.getById(subjectId);
    }

    public Optional<Subject> getByName(final String name) {
        return subjectService.getByName(name);
    }
}
