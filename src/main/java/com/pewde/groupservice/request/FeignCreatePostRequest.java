package com.pewde.groupservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeignCreatePostRequest {

    private int userId;

    private int wallId;

    private String text;

}
