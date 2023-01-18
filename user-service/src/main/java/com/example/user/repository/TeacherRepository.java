package com.example.user.repository;

import com.example.user.model.Teacher;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends Repository<Teacher, Long> {

    @Query("INSERT INTO teacher (user_id, department_id, fio) VALUES(:userId, :departmentId, :fio) " +
            "RETURNING id, user_id, department_id, fio")
    Teacher save(@Param("userId") final Long userId,
                          @Param("departmentId") final Long departmentId,
                          @Param("fio") final String fio);

    @Query("SELECT * FROM teacher WHERE user_id=:userId")
    Optional<Teacher> getByUserId(@Param("userId") final Long userId);

    @Query("SELECT * FROM teacher WHERE id=:teacherId")
    Optional<Teacher> getById(@Param("teacherId") Long teacherId);

    @Query("SELECT * FROM teacher WHERE fio=:fio")
    Optional<Teacher> getByFio(@Param("fio") String fio);
}
