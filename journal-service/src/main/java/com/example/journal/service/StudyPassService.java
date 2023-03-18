package com.example.journal.service;

import com.example.journal.model.StudyPass;
import com.example.journal.repository.StudyPassRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyPassService {
    private final StudyPassRepository studyPassRepository;

    public List<StudyPass> getBySubjectIdAndGroupId(Long groupId, Long subjectId) {
        return studyPassRepository.getBySubjectIdAndGroupId(groupId, subjectId);
    }

    public StudyPass upsert(StudyPass studyPass) {
        return studyPassRepository.upsert(studyPass.getLessonId(), studyPass.getStudentId(), studyPass.getPass());
    }
}
