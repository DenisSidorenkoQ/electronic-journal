package com.example.user.converter;

import com.example.user.dto.group.GroupRequest;
import com.example.user.dto.group.SaveGroupRequest;
import com.example.user.model.Group;
import org.mapstruct.Mapper;

@Mapper
public interface GroupConverter {
    Group fromDto(final SaveGroupRequest request);

    GroupRequest toDto(final Group group);
}
