package com.example.user.repository;

import com.example.user.model.Student;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends Repository<Student, Long> {

    Student save(final Student student);

    @Query("SELECT * FROM student WHERE fio=:fio")
    Optional<Student> getByFio(@Param("fio") final String fio);

    @Query("SELECT * FROM student WHERE id=:studentId")
    Optional<Student> getById(@Param("studentId") final Long studentId);

    @Query("SELECT * FROM student WHERE user_id=:userId")
    Optional<Student> getByUserId(@Param("userId") final Long userId);
}
