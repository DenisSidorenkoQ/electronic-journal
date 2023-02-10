package com.example.user.controller;

import com.example.user.converter.GroupConverter;
import com.example.user.dto.group.GroupRequest;
import com.example.user.dto.group.SaveGroupRequest;
import com.example.user.facade.GroupFacade;
import com.example.user.model.Group;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class GroupController {
    private final GroupFacade groupFacade;
    private final GroupConverter converter;

    @PostMapping("/group")
    GroupRequest saveOrGet(@RequestBody SaveGroupRequest request) {
        Group group = converter.fromDto(request);

        return converter.toDto(groupFacade.saveOrGet(group));
    }

    @GetMapping("/group/{groupId}")
    ResponseEntity getById(@PathVariable Long groupId) {
        Optional<Group> findGroup = groupFacade.getById(groupId);

        return findGroup
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping("/group")
    ResponseEntity getByName(@RequestParam String groupName) {
        Optional<Group> findGroup = groupFacade.getByName(groupName);

        return findGroup
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }
}
