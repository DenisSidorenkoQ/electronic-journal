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


    public Mark getMarkByStudentIdAndLessonId(Long studentId, Long lessonId) {
        return markService.getMarkByStudentIdAndLessonId(studentId, lessonId);
    }

    public List<Mark> getMarksBySubjectIdAndGroupId(Long groupId, Long subjectId) {
        return markService.getMarksBySubjectIdAndGroupId(groupId, subjectId);
    }

    public Mark upsert(Mark mark) {
        return markService.upsert(mark);
    }

    public List<SubjectAvgMark> getAvgMarksByStudentIdAndSubjectId(Long studentId) {
        return markService.getAvgMarksByStudentIdAndSubjectId(studentId);
    }
}
