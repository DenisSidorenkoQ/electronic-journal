package com.example.user.facade;

import com.example.user.model.Group;
import com.example.user.service.GroupService;
import java.util.List;
import java.util.Optional;
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

    public Optional<Group> getById(final Long groupId) {
        return groupService.getById(groupId);
    }

    public Optional<Group> getByName(String name) {
        return groupService.getByName(name);
    }

    public List<Group> getGroupList() {
        return groupService.getGroupList();
    }
}
