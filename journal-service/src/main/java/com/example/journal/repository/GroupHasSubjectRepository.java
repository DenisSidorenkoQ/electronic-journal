package com.example.journal.repository;

import com.example.journal.model.GroupHasSubject;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface GroupHasSubjectRepository extends Repository<GroupHasSubject, Long> {

    GroupHasSubject save(final GroupHasSubject groupHasSubject);

    @Query("SELECT * FROM group_has_subject WHERE teacher_id=:teacherId")
    List<GroupHasSubject> getByTeacherId(@Param("teacherId") Long teacherId);
}
