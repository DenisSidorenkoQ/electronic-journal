package com.example.journal.facade;

import com.example.journal.model.GroupHasSubject;
import com.example.journal.model.Subject;
import com.example.journal.model.SubjectByGroupInfo;
import com.example.journal.service.SubjectService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectFacade {
    private final SubjectService subjectService;

    public Subject saveOrGetSubject(final Subject subject) {
        return subjectService.getByName(subject.getName())
                .orElseGet(() -> subjectService.save(subject));
    }

    public Optional<Subject> getById(final Long subjectId) {
        return subjectService.getById(subjectId);
    }

    public Optional<Subject> getByName(final String name) {
        return subjectService.getByName(name);
    }

    public GroupHasSubject addSubjectToTheGroup(final GroupHasSubject groupHasSubject) {
        return subjectService.addSubjectToTheGroup(groupHasSubject);
    }

    public List<SubjectByGroupInfo> getGroupSubjects(final Long groupId) {
        return subjectService.getGroupSubjects(groupId);
    }
}