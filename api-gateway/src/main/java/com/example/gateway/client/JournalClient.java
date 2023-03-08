package com.example.gateway.client;

import com.example.gateway.dto.lesson.GetLessonByGroupIdAndSubjectIdResponse;
import com.example.gateway.dto.lesson.LessonResponse;
import com.example.gateway.dto.lesson.SaveLessonRequest;
import com.example.gateway.dto.mark.MarkResponse;
import com.example.gateway.dto.study_pass.StudyPassResponse;
import com.example.gateway.dto.subject.*;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "journal", url = "${services.journal.url}/api/v1")
public interface JournalClient {
//SubjectController
    @PostMapping("subject")
    SubjectResponse saveOrGetSubject(@RequestBody SaveSubjectRequest request);

    @GetMapping("subject/{subjectId}")
    ResponseEntity<SubjectResponse> getSubjectById(@PathVariable("subjectId") final Long subjectId);

    @GetMapping("subject")
    ResponseEntity<SubjectResponse> getSubjectByName(@RequestBody final GetSubjectByNameRequest request);

    //groupController
    @PostMapping("group/subject")
    GroupHasSubjectResponse addSubjectToTheGroup(@RequestBody AddSubjectToTheGroupRequest request);

    @GetMapping("group/{groupId}/subjects")
    List<SubjectResponse> getGroupSubjects(@PathVariable("groupId") Long groupId);

    //lessonController
    @PostMapping("lesson")
    LessonResponse saveOrGetLesson(@RequestBody SaveLessonRequest request);

    @GetMapping("lesson/{lessonId}")
    ResponseEntity getLessonById(@PathVariable("lessonId") final Long lessonId);

    @GetMapping("lessons")
    List<GetLessonByGroupIdAndSubjectIdResponse> getAllLessonsByGroupIdAndSubjectId(
            @RequestParam("groupId") final Long groupId,
            @RequestParam("subjectId") final Long subjectId
    );

    //MarkController
    @GetMapping("lesson/{lessonId}/marks")
    List<MarkResponse> getMarkByLessonId(@PathVariable("lessonId") Long lessonId);

    @GetMapping("group/{groupId}/subject/{subjectId}/marks")
    List<MarkResponse> getMarksBySubjectIdAndGroupId(@PathVariable("groupId") Long groupId, @PathVariable("subjectId") Long subjectId);

    //PassController

    @GetMapping("group/{groupId}/subject/{subjectId}/pass")
    List<StudyPassResponse> getBySubjectIdAndGroupId(@PathVariable("groupId") Long groupId, @PathVariable("subjectId") Long subjectId);
}
