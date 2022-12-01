package com.exmaple.springboot.repository;

import com.exmaple.springboot.model.Teacher;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends Repository<Teacher, Long> {
    @Query("select teacher_id, fio, department_id from teacher where department_id=:departmentId")
    List<Teacher> getTeachers(@Param("departmentId") int departmentId);
}
