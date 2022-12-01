package com.exmaple.springboot.repository;

import com.exmaple.springboot.model.Mark;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface MarkRepository extends Repository<Mark, Long> {
    @Query("select m.number, m.date from student " +
            "join \"group\" g on g.group_id = student.group_id " +
            "join group_has_subject ghs on g.group_id = ghs.group_id " +
            "join subject s on s.subject_id = ghs.subject_id " +
            "join mark m on student.student_id = m.student_id " +
            "where s.subject_id = :subjectId and m.student_id = :studentId")
    List<Mark> getMarkByStudentIdAndSubjectId(@Param("studentId") int studentId, @Param("subjectId") int subjectId);

    @Query("insert into mark (student_id, subject_id, date, number) " +
            "values (:studentId, :subjectId, :date, :number)")
    @Modifying
    void insertMarkByStudentIdAndSubjectId(@Param("studentId") int studentId,
                                           @Param("subjectId") int subjectId,
                                           @Param("date") Date date,
                                           @Param("number") int number);

    @Query("delete from mark where student_id=:studentId and subject_id=:subjectId and date=:date and number=:number")
    @Modifying
    void delMarkBySubjectIdStudentIdAndDate(@Param("studentId") int studentId,
                                            @Param("subjectId") int subjectId,
                                            @Param("date") Date date,
                                            @Param("number") int number);
}
