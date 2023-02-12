package com.example.gateway.client;

import com.example.gateway.dto.student.SaveStudentRequest;
import com.example.gateway.dto.student.StudentResponse;
import com.example.gateway.dto.subject.*;
import com.example.gateway.dto.user.GetUserByCredentialsRequest;
import com.example.gateway.dto.user.SaveUserRequest;
import com.example.gateway.dto.user.SaveUserResponse;
import com.example.gateway.dto.user.UserResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "journal", url = "${services.journal.url}/api/v1")
public interface JournalClient {
//SubjectController
    @PostMapping("subject")
    SubjectResponse saveOrGetSubject(@RequestBody SaveSubjectRequest request);

    @GetMapping("subject/{subjectId}")
    ResponseEntity<SubjectResponse> getSubjectById(@PathVariable("subjectId") final Long subjectId);

    @GetMapping("subject")
    ResponseEntity<SubjectResponse> getSubjectByName(@RequestBody final GetSubjectByNameRequest request);

    @PostMapping("group/subject")
    GroupHasSubjectResponse addSubjectToTheGroup(@RequestBody AddSubjectToTheGroupRequest request);

    @GetMapping("group/{groupId}/subjects")
    List<SubjectResponse> getGroupSubjects(@PathVariable("groupId") Long groupId);
}
