package com.example.journal.repository;

import com.example.journal.model.GroupHasSubject;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface GroupHasSubjectRepository extends Repository<GroupHasSubject, Long> {

    GroupHasSubject save(final GroupHasSubject groupHasSubject);
}
