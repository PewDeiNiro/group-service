package com.pewde.groupservice.request;

import com.pewde.groupservice.enums.GroupType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGroupRequest {

    @Schema(description = "Уникальный идентификатор пользователя")
    private int userId;

    @NotEmpty
    @Schema(description = "Название группы")
    private String title;

    @Schema(description = "Описание группы", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String description;

    @NotNull
    @Schema(description = "Тип группы", example = "OPEN")
    private GroupType type;

}
