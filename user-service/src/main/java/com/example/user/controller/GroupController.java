package com.example.user.controller;

import com.example.user.converter.GroupConverter;
import com.example.user.dto.admin.AdminResponse;
import com.example.user.dto.group.GroupRequest;
import com.example.user.dto.group.SaveGroupRequest;
import com.example.user.facade.GroupFacade;
import com.example.user.model.Admin;
import com.example.user.model.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
