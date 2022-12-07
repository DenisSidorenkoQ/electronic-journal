package com.exmaple.springboot.controller;

import com.exmaple.springboot.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class MarkRestController {
    private final MarkService markService;

    @PostMapping("/api/mark/add/{studentId}/{subjectId}")
    protected void insertMarkBySubjectAndStudentId(@PathVariable int studentId,
                                        @PathVariable int subjectId,
                                        @RequestParam Integer mark,
                                        @RequestParam(required = false) Date date) {
        if (date != null) {
            markService.insertMarkByStudentIdAndSubjectId(studentId, subjectId, date, mark);
        } else {
            markService.insertMarkByStudentIdAndSubjectId(studentId, subjectId, mark);
        }
    }

    @DeleteMapping("/api/mark/delete/{studentId}/{subjectId}")
    protected void delMarkBySubjectIdStudentIdAndDate(@PathVariable int studentId,
                                                      @PathVariable int subjectId,
                                                      @RequestParam Integer mark,
                                                      @RequestParam Date date) {
        markService.delMarkBySubjectIdStudentIdAndDate(studentId, subjectId, date, mark);
    }
}
