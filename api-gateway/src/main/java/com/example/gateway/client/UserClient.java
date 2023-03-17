package com.example.gateway.client;

import com.example.gateway.dto.admin.AdminResponse;
import com.example.gateway.dto.admin.SaveAdminRequest;
import com.example.gateway.dto.department.DepartmentResponse;
import com.example.gateway.dto.group.GroupResponse;
import com.example.gateway.dto.group.SaveGroupRequest;
import com.example.gateway.dto.role.RoleResponse;
import com.example.gateway.dto.student.SaveStudentRequest;
import com.example.gateway.dto.student.StudentResponse;
import com.example.gateway.dto.teacher.SaveTeacherRequest;
import com.example.gateway.dto.teacher.TeacherResponse;
import com.example.gateway.dto.user.GetUserByCredentialsRequest;
import com.example.gateway.dto.user.SaveUserRequest;
import com.example.gateway.dto.user.SaveUserResponse;
import com.example.gateway.dto.user.UserResponse;
import feign.Headers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user", url = "${services.user.url}/api/v1")
public interface UserClient {
//UserController
    @PostMapping("/user/credentials")
    Optional<UserResponse> getByCredentials(@RequestBody GetUserByCredentialsRequest request);

    @GetMapping("/user/{userId}")
    ResponseEntity<UserResponse> getById(@PathVariable("userId") final Long userId);

    @PostMapping("/users")
    ResponseEntity<SaveUserResponse> saveUser(@RequestBody SaveUserRequest request);

//StudentController
    @PostMapping("/students")
    StudentResponse saveOrGetStudent(@RequestBody SaveStudentRequest request);

    @GetMapping("/user/{userId}/students")
    ResponseEntity<StudentResponse> getStudentByUserId(@PathVariable("userId") final Long userId);

    @GetMapping("/student/{studentId}")
    ResponseEntity<StudentResponse> getStudentById(@PathVariable("studentId") Long studentId);

    @GetMapping("/group/{groupId}/students")
    List<StudentResponse> getAllStudentsByGroup(@PathVariable("groupId") Long groupId);


//Teacher
    @PostMapping("/teachers")
    TeacherResponse saveOrGetTeacher(@RequestBody SaveTeacherRequest request);

    @GetMapping("/user/{userId}/teachers")
    ResponseEntity<TeacherResponse> getTeacherByUserId(@PathVariable("userId") final Long userId);

//Group
    @PostMapping("/groups")
    GroupResponse saveOrGetGroup(@RequestBody SaveGroupRequest request);

    @GetMapping("/group/{groupId}")
    ResponseEntity<GroupResponse> getGroupById(@PathVariable("groupId") Long groupId);

    @GetMapping("/groups")
    List<GroupResponse> getGroupList();

//Role
    @GetMapping("/roles")
    List<RoleResponse> getRoleList();

    @GetMapping("/role/{roleId}")
    RoleResponse getRoleById(@PathVariable("roleId") Long roleId);


//Department
    @GetMapping("/departments")
    List<DepartmentResponse> getDepartmentList();

//Admin
    @PostMapping("/admins")
    AdminResponse saveOrGetAdmin(@RequestBody SaveAdminRequest request);
}
