package com.example.gateway.controller.user;

import com.example.gateway.client.UserClient;
import com.example.gateway.dto.group.GroupResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class GroupController {
    private final UserClient userClient;

    @GetMapping("/group/{groupId}")
    ResponseEntity<GroupResponse> getById(@PathVariable Long groupId) {
        return userClient.getGroupById(groupId);
    }

    @GetMapping("/groups")
    List<GroupResponse> getGroupList() {
        return userClient.getGroupList();
    }
}
