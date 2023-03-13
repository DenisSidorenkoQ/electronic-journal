package com.example.journal.controller;

import com.example.journal.converter.StudyPassConverter;
import com.example.journal.dto.mark.MarkResponse;
import com.example.journal.dto.study_pass.SaveStudyPassRequest;
import com.example.journal.dto.study_pass.StudyPassResponse;
import com.example.journal.facade.StudyPassFacade;
import com.example.journal.model.Mark;
import com.example.journal.model.StudyPass;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudyPassController {
    private final StudyPassConverter converter;
    private final StudyPassFacade studyPassFacade;

    @PostMapping("study-pass")
    StudyPassResponse upsert(@RequestBody SaveStudyPassRequest request) {
        StudyPass studyPass = converter.fromDto(request);

        return converter.toDto(studyPassFacade.upsert(studyPass));
    }

    @GetMapping("lesson/{lessonId}/study-pass")
    List<StudyPassResponse> getAllPassByLessonId(@PathVariable Long lessonId) {
        List<StudyPass> studyPasses = studyPassFacade.getAllPassByLessonId(lessonId);

        return studyPasses.stream().map(converter::toDto).collect(Collectors.toList());
    }

    @GetMapping("group/{groupId}/subject/{subjectId}/pass")
    List<StudyPassResponse> getBySubjectIdAndGroupId(@PathVariable Long groupId, @PathVariable Long subjectId) {
        List<StudyPass> passList = studyPassFacade.getBySubjectIdAndGroupId(groupId, subjectId);

        return passList.stream().map((converter::toDto)).collect(Collectors.toList());
    }
}
