package com.pewde.groupservice.feign;

import com.pewde.groupservice.request.FeignCreatePostRequest;
import com.pewde.groupservice.response.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(
        name = "ProfileClient",
        url = "${services.profile.url}"
)
public interface ProfileClient {

    @PostMapping("/post/create")
    PostResponse createPost(@RequestHeader Map<String, String> headers, @RequestBody FeignCreatePostRequest request);

}
