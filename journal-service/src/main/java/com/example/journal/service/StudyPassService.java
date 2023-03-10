package com.example.journal.service;

import com.example.journal.dto.study_pass.StudyPassResponse;
import com.example.journal.model.Mark;
import com.example.journal.model.StudyPass;
import com.example.journal.repository.StudyPassRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyPassService {
    private final StudyPassRepository studyPassRepository;

    public Optional<Mark> getByLessonIdAndStudentId(final Long lessonId, final Long studentId) {
        return studyPassRepository.getByLessonIdAndStudentId(lessonId, studentId);
    }

    public StudyPass update(final Long lessonId, final Long studentId, final  Boolean pass) {
        return studyPassRepository.update(lessonId, studentId, pass);
    }

    public StudyPass save(final StudyPass studyPass) {
        return studyPassRepository.save(studyPass);
    }

    public List<StudyPass> getAllPassByLessonId(final Long lessonId) {
        return studyPassRepository.getAllPassByLessonId(lessonId);
    }

    public List<StudyPass> getBySubjectIdAndGroupId(Long groupId, Long subjectId) {
        return studyPassRepository.getBySubjectIdAndGroupId(groupId, subjectId);
    }
}
