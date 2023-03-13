package com.example.journal.service;

import com.example.journal.model.Mark;
import com.example.journal.repository.MarkRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarkService {
    private final MarkRepository markRepository;

    public List<Mark> getMarksByLessonId(final Long lessonId) {
        return markRepository.getMarksByLessonId(lessonId);
    }

    public Mark getMarkByStudentIdAndLessonId(Long studentId, Long lessonId) {
        return markRepository.getMarkByStudentIdAndLessonId(studentId, lessonId);
    }

    public List<Mark> getMarksBySubjectIdAndGroupId(Long groupId, Long subjectId) {
        return markRepository.getMarksBySubjectIdAndGroupId(groupId, subjectId);
    }

    public Mark upsert(Mark mark) {
        return markRepository.upsert(mark.getLessonId(), mark.getStudentId(), mark.getNumber());
    }
}
