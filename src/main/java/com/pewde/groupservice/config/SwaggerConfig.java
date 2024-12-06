package com.pewde.groupservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Group Service",
                description = "Все операции связанные с группами в EMSN",
                version = "1.0.0"
        )
)
public class SwaggerConfig {
}
