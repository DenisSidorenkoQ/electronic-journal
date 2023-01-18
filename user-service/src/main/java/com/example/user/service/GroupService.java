package com.example.user.service;

import com.example.user.model.Group;
import com.example.user.repository.GroupRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public Group save(Group group) {
        return groupRepository.save(group.getName());
    }

    public Optional<Group> getByName(String name) {
        return groupRepository.getByName(name);
    }
}
