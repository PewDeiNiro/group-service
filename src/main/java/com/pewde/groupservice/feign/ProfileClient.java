package com.pewde.groupservice.feign;

import com.pewde.groupservice.request.DeletePostRequest;
import com.pewde.groupservice.request.EditPostRequest;
import com.pewde.groupservice.request.FeignCreatePostRequest;
import com.pewde.groupservice.response.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(
        name = "ProfileClient",
        url = "${services.profile.url}"
)
public interface ProfileClient {

    @PostMapping("/post/create")
    PostResponse createPost(@RequestHeader Map<String, String> headers, @RequestBody FeignCreatePostRequest request);

    @PutMapping("/post/edit")
    PostResponse editPost(@RequestHeader Map<String, String> headers, @RequestBody EditPostRequest request);

    @DeleteMapping("/post/delete")
    ResponseEntity<HttpStatus> deletePost(@RequestHeader Map<String, String> headers, @RequestBody DeletePostRequest request);

}
