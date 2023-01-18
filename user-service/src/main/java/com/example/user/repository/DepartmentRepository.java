package com.example.user.repository;

import com.example.user.model.Admin;
import com.example.user.model.Department;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends Repository<Department, Long> {

    @Query("SELECT * FROM department WHERE name=:name")
    Optional<Department> getDepartmentByName(@Param("name") final String name);

    @Query("INSERT INTO department(name) VALUES(:name) RETURNING id, name")
    Department save(@Param("name") final String name);

    @Query("SELECT * FROM department WHERE id=:departmentId")
    Optional<Department> getById(@Param("departmentId") final Long departmentId);
}
