package com.example.journal.facade;

import com.example.journal.model.Mark;
import com.example.journal.model.StudyPass;
import com.example.journal.service.StudyPassService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudyPassFacade {
    private final StudyPassService studyPassService;

    public StudyPass saveOrUpdate(StudyPass studyPass) {
        Optional<Mark> foundStudyPass =
                studyPassService.getByLessonIdAndStudentId(studyPass.getLessonId(), studyPass.getStudentId());

        if (foundStudyPass.isPresent()) {
            return studyPassService.update(studyPass.getLessonId(), studyPass.getStudentId(), studyPass.getPass());
        }
        return studyPassService.save(studyPass);
    }

    public List<StudyPass> getAllPassByLessonId(final Long lessonId) {
        return studyPassService.getAllPassByLessonId(lessonId);
    }
}
