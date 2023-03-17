package com.example.gateway.controller.user;

import com.example.gateway.client.UserClient;
import com.example.gateway.dto.group.GroupResponse;
import com.example.gateway.dto.group.SaveGroupRequest;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class GroupController {
    private final UserClient userClient;

    @PostMapping("/groups")
    GroupResponse saveOrGet(@RequestBody SaveGroupRequest request) {
        return userClient.saveOrGetGroup(request);
    }

    @GetMapping("/group/{groupId}")
    ResponseEntity<GroupResponse> getById(@PathVariable Long groupId) {
        return userClient.getGroupById(groupId);
    }

    @GetMapping("/groups")
    List<GroupResponse> getGroupList() {
        return userClient.getGroupList();
    }
}
