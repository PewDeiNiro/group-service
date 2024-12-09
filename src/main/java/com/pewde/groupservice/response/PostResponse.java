package com.pewde.groupservice.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pewde.groupservice.entity.Wall;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

    private int id;

    private String text;

    private String type;

    private Date createdAt;

    private Wall wall;

}
