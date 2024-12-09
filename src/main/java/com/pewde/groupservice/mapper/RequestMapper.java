package com.pewde.groupservice.mapper;

import com.pewde.groupservice.request.CreatePostRequest;
import com.pewde.groupservice.request.FeignCreatePostRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RequestMapper {

    FeignCreatePostRequest mapCreatePostRequest(CreatePostRequest request);

}
