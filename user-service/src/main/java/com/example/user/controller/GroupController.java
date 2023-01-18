package com.example.user.controller;

import com.example.user.converter.GroupConverter;
import com.example.user.dto.group.GetGroupByNameRequest;
import com.example.user.dto.group.GroupRequest;
import com.example.user.dto.group.SaveGroupRequest;
import com.example.user.facade.GroupFacade;
import com.example.user.model.Group;
import com.example.user.model.Teacher;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupFacade groupFacade;
    private final GroupConverter converter;

    @PostMapping
    GroupRequest saveOrGet(@RequestBody SaveGroupRequest request) {
        Group group = converter.fromDto(request);

        return converter.toDto(groupFacade.saveOrGet(group));
    }

    @GetMapping("{groupId}")
    ResponseEntity getById(@PathVariable Long groupId) {
        Optional<Group> findGroup = groupFacade.getById(groupId);

        return findGroup
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping
    ResponseEntity getByName(@RequestBody GetGroupByNameRequest request) {
        Optional<Group> findGroup = groupFacade.getByName(request.getName());

        return findGroup
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }
}
