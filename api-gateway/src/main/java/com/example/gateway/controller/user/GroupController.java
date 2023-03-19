package com.example.gateway.controller.user;

import com.example.gateway.client.UserClient;
import com.example.gateway.dto.group.GroupResponse;
import com.example.gateway.dto.group.SaveGroupRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@EnableMethodSecurity
public class GroupController {
    private final UserClient userClient;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/groups")
    GroupResponse saveOrGet(@RequestBody SaveGroupRequest request) {
        return userClient.saveOrGetGroup(request);
    }

    @PreAuthorize("hasRole('STUDENT') or hasRole('TEACHER')")
    @GetMapping("/group/{groupId}")
    ResponseEntity<GroupResponse> getById(@PathVariable Long groupId) {
        return userClient.getGroupById(groupId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/groups")
    List<GroupResponse> getGroupList() {
        return userClient.getGroupList();
    }
}
