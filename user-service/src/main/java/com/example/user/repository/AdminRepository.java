package com.example.user.repository;

import com.example.user.model.Admin;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends Repository<Admin, Long> {

    Admin save(final Admin admin);

    @Query("SELECT * FROM admin where user_id=:userId")
    Optional<Admin> getAdminByUserId(@Param("userId") final Long userId);

}
