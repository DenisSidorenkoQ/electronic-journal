package com.example.user.repository;

import com.example.user.model.Department;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends Repository<Department, Long> {

    @Query("SELECT * FROM department WHERE name=:name")
    Optional<Department> getByName(@Param("name") final String name);

    Department save(final Department department);

    @Query("SELECT * FROM department WHERE id=:departmentId")
    Optional<Department> getById(@Param("departmentId") final Long departmentId);
}
