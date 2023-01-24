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
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudyPassController {
    private final StudyPassConverter converter;
    private final StudyPassFacade studyPassFacade;

    @PostMapping("study-pass")
    StudyPassResponse saveOrUpdate(@RequestBody SaveStudyPassRequest request) {
        StudyPass studyPass = converter.fromDto(request);

        return converter.toDto(studyPassFacade.saveOrUpdate(studyPass));
    }

    @GetMapping("lesson/{lessonId}/study-pass")
    List<StudyPassResponse> getAllPassByLessonId(@PathVariable Long lessonId) {
        List<StudyPass> studyPasses = studyPassFacade.getAllPassByLessonId(lessonId);
        List<StudyPassResponse> studyPassResponse = new ArrayList<>();

        studyPasses.forEach(studyPass -> {studyPassResponse.add(converter.toDto(studyPass));});
        return studyPassResponse;
    }
}
