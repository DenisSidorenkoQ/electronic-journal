package com.exmaple.springboot.service;

import com.exmaple.springboot.converter.StudentConverter;
import com.exmaple.springboot.model.Mark;
import com.exmaple.springboot.model.Student;
import com.exmaple.springboot.repository.MarkRepository;
import com.exmaple.springboot.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final MarkRepository markRepository;
    private final StudentConverter studentConverter;

    public List<Student> getStudentsByGroupId(int groupId) {
        return studentRepository.getStudentsByGroupIdAndSubjectId(groupId);
    }

    public Map<Student, List<Mark>> getStudentsAndMarksByGroupIdAndSubjectId(int groupId, int subjectId) {
        List<Student> students = studentRepository.getStudentsByGroupIdAndSubjectId(groupId);
        Map<Student, List<Mark>> studentWithMarks = new HashMap<>();
        students.forEach(student -> {
            studentWithMarks.put(student, markRepository.getMarkByStudentIdAndSubjectId(student.getStudentId(), subjectId));
        });
        return studentWithMarks;
    }
}
