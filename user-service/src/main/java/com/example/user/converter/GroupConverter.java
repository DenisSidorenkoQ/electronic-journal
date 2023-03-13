package com.example.user.converter;

import com.example.user.dto.group.GroupResponse;
import com.example.user.dto.group.SaveGroupRequest;
import com.example.user.model.Group;
import org.mapstruct.Mapper;

@Mapper
public interface GroupConverter {
    Group fromDto(final SaveGroupRequest request);

    GroupResponse toDto(final Group group);
}
