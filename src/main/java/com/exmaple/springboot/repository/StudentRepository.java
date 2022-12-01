package com.exmaple.springboot.repository;

import com.exmaple.springboot.model.Student;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends Repository<Student, Long> {
    @Query("select student_id, user_id, student.group_id, fio, sex from student " +
            "join \"group\" g on g.group_id = student.group_id " +
            "where student.group_id = :groupId")
    List<Student> getStudentsByGroupIdAndSubjectId(@Param("groupId") int groupId);
}
