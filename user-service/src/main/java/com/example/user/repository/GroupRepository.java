package com.example.user.repository;

import com.example.user.model.Group;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface GroupRepository extends Repository<Group, Long> {
    @Query("INSERT INTO \"group\"(name) VALUES(:name) RETURNING id, name")
    Group save(@Param("name") final String name);

    @Query("SELECT * FROM \"group\" WHERE name=:name")
    Optional<Group> getByName(@Param("name") final String name);

    @Query("SELECT * FROM \"group\" WHERE id=:groupId")
    Optional<Group> getById(@Param("groupId") final Long groupId);
}
