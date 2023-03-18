package com.example.journal.facade;

import com.example.journal.dto.study_pass.StudyPassResponse;
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

    public List<StudyPass> getBySubjectIdAndGroupId(Long groupId, Long subjectId) {
        return studyPassService.getBySubjectIdAndGroupId(groupId, subjectId);
    }

    public StudyPass upsert(StudyPass studyPass) {
        return studyPassService.upsert(studyPass);
    }
}
