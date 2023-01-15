package com.example.user.repository;

import com.example.user.model.Admin;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends Repository<Admin, Long> {

    @Query("INSERT INTO admin(user_id, fio) VALUES(:userId, :fio) RETURNING id, user_id, fio")
    Admin save(@Param("userId") final Long userId,
              @Param("fio") final String fio);

    @Query("SELECT * FROM admin where user_id=:userId")
    Optional<Admin> getAdminByUserId(@Param("userId") final Long userId);

    @Query("SELECT * FROM admin where id=:adminId")
    Optional<Admin> getAdminById(@Param("adminId") final Long adminId);
}
