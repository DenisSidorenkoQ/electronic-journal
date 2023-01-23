package com.example.user.repository;

import com.example.user.model.Teacher;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends Repository<Teacher, Long> {

    Teacher save(final Teacher teacher);

    @Query("SELECT * FROM teacher WHERE user_id=:userId")
    Optional<Teacher> getByUserId(@Param("userId") final Long userId);

    @Query("SELECT * FROM teacher WHERE id=:teacherId")
    Optional<Teacher> getById(@Param("teacherId") Long teacherId);

    @Query("SELECT * FROM teacher WHERE fio=:fio")
    Optional<Teacher> getByFio(@Param("fio") String fio);
}
