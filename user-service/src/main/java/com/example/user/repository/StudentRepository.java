package com.example.user.repository;

import com.example.user.model.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends Repository<Student, Long> {

    Student save(final Student student);

    @Query("SELECT * FROM student WHERE user_id=:userId")
    Optional<Student> getByUserId(@Param("userId") final Long userId);

    @Query("SELECT * FROM student WHERE student.group_id=:groupId")
    List<Student> getAllStudentsByGroup(@Param("groupId") Long groupId);
}
