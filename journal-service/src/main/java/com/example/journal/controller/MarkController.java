package com.example.journal.controller;

import com.example.journal.converter.MarkConverter;
import com.example.journal.dto.mark.MarkResponse;
import com.example.journal.dto.mark.SaveOrUpdateMarkRequest;
import com.example.journal.facade.MarkFacade;
import com.example.journal.model.Mark;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MarkController {
    private final MarkConverter converter;
    private final MarkFacade markFacade;

    @PostMapping("mark")
    MarkResponse upsert(@RequestBody @Validated SaveOrUpdateMarkRequest request) {
        Mark mark = converter.fromDto(request);

        return converter.toDto(markFacade.upsert(mark));
    }

    @GetMapping("lesson/{lessonId}/marks")
    List<Mark> getMarksByLessonId(@PathVariable Long lessonId) {
        return markFacade.getMarksByLessonId(lessonId);
    }

    @GetMapping("group/{groupId}/subject/{subjectId}/marks")
    List<Mark> getMarksBySubjectIdAndGroupId(@PathVariable Long groupId, @PathVariable Long subjectId) {
        return markFacade.getMarksBySubjectIdAndGroupId(groupId, subjectId);
    }

    @GetMapping("student/{studentId}/lesson/{lessonId}/mark")
    MarkResponse getMarkByStudentIdAndLessonId(@PathVariable Long studentId, @PathVariable Long lessonId) {
        return converter.toDto(markFacade.getMarkByStudentIdAndLessonId(studentId, lessonId));
    }
}
