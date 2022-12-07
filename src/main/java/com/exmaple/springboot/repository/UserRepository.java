package com.exmaple.springboot.repository;

import com.exmaple.springboot.model.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends Repository<User, Long> {
    @Query("select * from \"user\" where login=:login")
    User getUserByLogin(@Param("login") String login);

    @Query("select password from \"user\" where login = :login")
    Optional<String> getUserHashedPassword(@Param("login") String login);

    @Query("insert into \"user\" (login, password, role) values (:login, :password, :role)")
    @Modifying
    boolean insertNewUser(@Param("login") String login, @Param("password") String password, @Param("role") String role);
}
