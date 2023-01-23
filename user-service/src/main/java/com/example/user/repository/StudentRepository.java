package com.example.user.repository;

import com.example.user.model.Student;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends Repository<Student, Long> {

    @Query("SELECT * FROM student WHERE fio=:fio")
    Optional<Student> getByFio(@Param("fio") final String fio);

    @Query("INSERT INTO student(user_id, group_id, fio, sex) VALUES(:userId, :groupId, :fio, :sex) RETURNING id, user_id, group_id, fio, sex")
    Student save(@Param("userId") final Long userId, @Param("groupId") final Long groupId,
                 @Param("fio") final String fio, @Param("sex") final Character sex);

    @Query("SELECT * FROM student WHERE id=:studentId")
    Optional<Student> getById(@Param("studentId") Long studentId);
}
