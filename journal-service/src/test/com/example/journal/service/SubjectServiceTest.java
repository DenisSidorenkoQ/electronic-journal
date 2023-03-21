package com.example.journal.service;

import com.example.journal.model.Subject;
import com.example.journal.repository.SubjectRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SubjectServiceTest {
    @Autowired
    private SubjectService subjectService;
    @MockBean
    private SubjectRepository subjectRepository;

    @Test
    void shouldReturnSubjects() {
        List<Subject> subjects = getSubjectList();

        Mockito.when(subjectRepository.getSubjectList()).thenReturn(subjects);

        List<Subject> subjectList = subjectService.getSubjectList();

        Assertions.assertNotNull(subjectList);
        Assertions.assertEquals(2, subjectList.size());
    }

    private List<Subject> getSubjectList() {
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(Subject.builder().id(1L).name("ООП").knowledgeTestTypeId(1L).timeToStudy(100L).build());
        subjectList.add(Subject.builder().id(2L).name("ООП").knowledgeTestTypeId(1L).timeToStudy(100L).build());
        return subjectList;
    }
}
