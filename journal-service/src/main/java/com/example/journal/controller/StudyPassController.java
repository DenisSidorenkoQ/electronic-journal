package com.example.journal.controller;

import com.example.journal.converter.StudyPassConverter;
import com.example.journal.dto.study_pass.SaveStudyPassRequest;
import com.example.journal.dto.study_pass.StudyPassResponse;
import com.example.journal.facade.StudyPassFacade;
import com.example.journal.model.StudyPass;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudyPassController {
    private final StudyPassConverter converter;
    private final StudyPassFacade markFacade;

    @PostMapping("study-pass")
    StudyPassResponse saveOrUpdate(@RequestBody SaveStudyPassRequest request) {
        StudyPass studyPass = converter.fromDto(request);

        return converter.toDto(markFacade.saveOrUpdate(studyPass));
    }
}
