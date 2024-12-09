package com.pewde.groupservice.mapper;

import com.pewde.groupservice.entity.Group;
import com.pewde.groupservice.request.CreateGroupRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroupMapper {

    Group mapCreateGroupRequestToGroup(CreateGroupRequest request);

}
