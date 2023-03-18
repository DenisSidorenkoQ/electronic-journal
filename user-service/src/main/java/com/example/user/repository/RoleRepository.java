package com.example.user.repository;

import com.example.user.model.Role;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends Repository<Role, Long> {
    Role save(final Role role);

    @Query("SELECT * FROM role")
    List<Role> getRoleList();

    @Query("SELECT * FROM role WHERE id=:roleId")
    Role getRoleById(@Param("roleId") Long roleId);
}
