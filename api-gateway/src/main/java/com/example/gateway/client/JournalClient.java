package com.example.gateway.client;

import com.example.gateway.dto.journal.JournalResponse;
import com.example.gateway.dto.lesson.GetLessonByGroupIdAndSubjectIdResponse;
import com.example.gateway.dto.lesson.LessonResponse;
import com.example.gateway.dto.lesson.SaveLessonRequest;
import com.example.gateway.dto.mark.MarkResponse;
import com.example.gateway.dto.mark.SaveOrUpdateMarkRequest;
import com.example.gateway.dto.mark.SubjectAvgMarkResponse;
import com.example.gateway.dto.study_pass.SaveStudyPassRequest;
import com.example.gateway.dto.study_pass.StudyPassResponse;
import com.example.gateway.dto.subject.*;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "journal", url = "${services.journal.url}/api/v1")
public interface JournalClient {
//SubjectController
    @PostMapping("subjects")
    SubjectResponse saveOrGetSubject(@RequestBody SaveSubjectRequest request);

    @GetMapping("teacher/{teacherId}/subjects")
    List<GroupHasSubjectResponse> getTeacherSubjects(@PathVariable("teacherId") Long teacherId);

    @GetMapping("teacher/{teacherId}/group/{groupId}/subjects")
    List<SubjectResponse> getSubjectsByTeacherIdAndGroupId(@PathVariable("teacherId") Long teacherId,
                                                           @PathVariable("groupId") Long groupId);

    //groupController
    @PostMapping("group/subjects")
    GroupHasSubjectResponse addSubjectToTheGroup(@RequestBody AddSubjectToTheGroupRequest request);

    @GetMapping("group/{groupId}/subjects")
    List<SubjectResponse> getGroupSubjects(@PathVariable("groupId") Long groupId);

    //lessonController
    @PostMapping("lessons")
    LessonResponse saveLesson(@RequestBody SaveLessonRequest request);

    @GetMapping("lessons")
    List<GetLessonByGroupIdAndSubjectIdResponse> getAllLessonsByGroupIdAndSubjectId(
            @RequestParam("groupId") final Long groupId,
            @RequestParam("subjectId") final Long subjectId
    );

    //MarkController
    @PostMapping("marks")
    MarkResponse upsertMark(@RequestBody @Validated SaveOrUpdateMarkRequest request);

    @GetMapping("group/{groupId}/subject/{subjectId}/marks")
    List<MarkResponse> getMarksBySubjectIdAndGroupId(@PathVariable("groupId") Long groupId, @PathVariable("subjectId") Long subjectId);

    @GetMapping("student/{studentId}/subjects/marks/avg")
    List<SubjectAvgMarkResponse> getAvgStudentMarks(@PathVariable("studentId") Long studentId);

    //PassController

    @PostMapping("study-pass")
    StudyPassResponse upsertStudyPass(@RequestBody SaveStudyPassRequest request);

    @GetMapping("group/{groupId}/subject/{subjectId}/pass")
    List<StudyPassResponse> getBySubjectIdAndGroupId(@PathVariable("groupId") Long groupId, @PathVariable("subjectId") Long subjectId);

    //JournalController
    @GetMapping("group/{groupId}/journals")
    ResponseEntity<JournalResponse> getJournalByGroupId(@PathVariable("groupId") final Long groupId);

}
