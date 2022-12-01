package com.exmaple.springboot.service;

import com.exmaple.springboot.repository.MarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MarkService {
    private final MarkRepository markRepository;

    public void insertMarkByStudentIdAndSubjectId(int studentId, int subjectId, int number) {
        Date dateBuffer = Date.valueOf(LocalDate.now());
        markRepository.insertMarkByStudentIdAndSubjectId(studentId, subjectId, dateBuffer, number);
    }

    public void insertMarkByStudentIdAndSubjectId(int studentId, int subjectId, Date date, int number) {
        markRepository.insertMarkByStudentIdAndSubjectId(studentId, subjectId, date, number);
    }

    public void delMarkBySubjectIdStudentIdAndDate(int studentId, int subjectId, Date date, int number) {
        markRepository.delMarkBySubjectIdStudentIdAndDate(studentId, subjectId, date, number);
    }
}
