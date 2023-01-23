package com.example.journal.repository;

import com.example.journal.model.Journal;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface JournalRepository extends Repository<Journal, Long> {
    @Query("SELECT * FROM journal WHERE group_id=:groupId")
    Optional<Journal> getByGroupId(@Param("groupId") final Long groupId);

    Journal save(Journal journal);
}
