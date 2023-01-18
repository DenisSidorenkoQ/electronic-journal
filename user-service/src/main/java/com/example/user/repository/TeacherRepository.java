package com.example.user.repository;

import com.example.user.model.Teacher;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends Repository<Teacher, Long> {

    @Query("INSERT INTO teacher (user_id, department_id, fio) VALUES(:userId, :departmentId, :fio) " +
            "RETURNING id, user_id, department_id, fio")
    Optional<Teacher> save(@Param("userId") final Long userId,
                          @Param("departmentId") final Long departmentId,
                          @Param("fio") final String fio);
}
