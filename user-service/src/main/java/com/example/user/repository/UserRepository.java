package com.example.user.repository;

import com.example.user.model.User;
import com.example.user.model.UserAndRole;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends Repository<User, Long> {

    @Query("INSERT INTO users (login, password, role_id) VALUES(:login, :password, :roleId) " +
            "RETURNING id, login, password, role_id")
    User save(@Param("login") final String login,
              @Param("password") final String password,
              @Param("roleId") final Integer roleId);

    @Query("SELECT * FROM users WHERE login=:login")
    Optional<User> getByLogin(@Param("login") final String login);

    @Query("SELECT users.id, users.login, users.password, r.name FROM users " +
            "JOIN role r on r.id = users.role_id " +
            "WHERE users.id=:userId")
    Optional<UserAndRole> getByUserId(@Param("userId") final Long userId);

    @Query("SELECT users.id, users.login, users.password, r.name FROM users " +
            "JOIN role r on r.id = users.role_id " +
            "WHERE login=:login AND password=:password")
    Optional<UserAndRole> getByCredentials(@Param("login") String login, @Param("password") String password);
}
