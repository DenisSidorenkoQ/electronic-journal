package com.example.journal.facade;

import com.example.journal.model.Mark;
import com.example.journal.service.MarkService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarkFacade {
    private final MarkService markService;


    public Mark saveOrUpdate(final Mark mark) {
        Optional<Mark> foundMark = markService.getByLessonIdAndStudentId(mark.getLessonId(), mark.getStudentId());

        if (foundMark.isPresent()) {
            return markService.update(mark.getLessonId(), mark.getStudentId(), mark.getNumber());
        }
        return markService.save(mark);
    }

    public List<Mark> getMarksByLessonId(final Long lessonId) {
        return markService.getMarksByLessonId(lessonId);
    }
}
