package com.example.journal.repository;

import com.example.journal.model.KnowledgeTestType;
import com.example.journal.model.Lesson;
import org.springframework.data.repository.Repository;

public interface LessonRepository extends Repository<KnowledgeTestType, Long> {

    Lesson save(final Lesson lesson);
}
