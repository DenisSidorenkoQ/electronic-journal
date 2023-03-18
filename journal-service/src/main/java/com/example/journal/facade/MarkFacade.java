package com.example.journal.facade;

import com.example.journal.model.Mark;
import com.example.journal.model.SubjectAvgMark;
import com.example.journal.service.MarkService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarkFacade {
    private final MarkService markService;


    public List<Mark> getMarksByLessonId(final Long lessonId) {
        return markService.getMarksByLessonId(lessonId);
    }

    public List<Mark> getMarksBySubjectIdAndGroupId(Long groupId, Long subjectId) {
        return markService.getMarksBySubjectIdAndGroupId(groupId, subjectId);
    }

    public Mark upsert(Mark mark) {
        return markService.upsert(mark);
    }

    public List<SubjectAvgMark> getAvgMarksByStudentId(Long studentId) {
        return markService.getAvgMarksByStudentId(studentId);
    }
}
