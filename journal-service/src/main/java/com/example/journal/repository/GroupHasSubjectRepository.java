package com.example.journal.repository;

import com.example.journal.model.GroupHasSubject;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface GroupHasSubjectRepository extends Repository<GroupHasSubject, Long> {

    @Query("INSERT INTO group_has_subject(group_id, teacher_id, subject_id) VALUES(:groupId, :teacherId, :subjectId) RETURNING group_id, teacher_id, subject_id")
    GroupHasSubject save(@Param("groupId") Long groupId, @Param("teacherId") Long teacherId, @Param("subjectId") Long subjectId);
}
