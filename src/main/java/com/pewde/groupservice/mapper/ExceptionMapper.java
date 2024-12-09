package com.pewde.groupservice.mapper;

import com.pewde.groupservice.exception.HttpException;
import com.pewde.groupservice.response.ExceptionResponse;
import feign.FeignException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExceptionMapper {

    @Mapping(target = "message", expression = "java(exception.getMessage())")
    ExceptionResponse mapExceptionToExceptionResponse(HttpException exception);

    @Mapping(target = "message", expression = "java(exception.getLocalizedMessage())")
    @Mapping(target = "code", expression = "java(org.springframework.http.HttpStatus.BAD_REQUEST.value())")
    @Mapping(target = "status", expression = "java(org.springframework.http.HttpStatus.BAD_REQUEST)")
    ExceptionResponse mapFeignExceptionToExceptionResponse(FeignException exception);

}
