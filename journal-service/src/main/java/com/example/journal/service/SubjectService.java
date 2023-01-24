package com.example.journal.service;

import com.example.journal.model.GroupHasSubject;
import com.example.journal.model.Subject;
import com.example.journal.repository.GroupHasSubjectRepository;
import com.example.journal.repository.SubjectRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final GroupHasSubjectRepository groupHasSubjectRepository;

    public Optional<Subject> getByName(final String name) {
        return subjectRepository.getByName(name);
    }

    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Optional<Subject> getById(final Long subjectId) {
        return subjectRepository.getById(subjectId);
    }

    public GroupHasSubject addSubjectToTheGroup(final GroupHasSubject groupHasSubject) {
        return groupHasSubjectRepository.save(groupHasSubject);
    }

    public List<Subject> getGroupSubjects(final Long groupId) {
        return subjectRepository.getGroupListSubject(groupId);
    }
}
