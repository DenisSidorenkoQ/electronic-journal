package com.example.user.service;

import com.example.user.model.Group;
import com.example.user.repository.GroupRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public Group save(final Group group) {
        return groupRepository.save(group);
    }

    public Optional<Group> getByName(final String name) {
        return groupRepository.getByName(name);
    }

    public Optional<Group> getById(final Long groupId) {
        return groupRepository.getById(groupId);
    }

    public List<Group> getGroupList() {
        return groupRepository.getGroupList();
    }
}
