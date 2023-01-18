package com.example.user.facade;

import com.example.user.model.Group;
import com.example.user.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GroupFacade {
    private final GroupService groupService;


    public Group saveOrGet(final Group group) {
        return groupService.getByName(group.getName())
                .orElseGet(() -> groupService.save(group));
    }
}
