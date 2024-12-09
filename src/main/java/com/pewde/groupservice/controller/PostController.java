package com.pewde.groupservice.controller;

import com.pewde.groupservice.request.CreatePostRequest;
import com.pewde.groupservice.request.DeletePostRequest;
import com.pewde.groupservice.request.EditPostRequest;
import com.pewde.groupservice.response.PostResponse;
import com.pewde.groupservice.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "PostController", description = "Все операции, связанные с постами в группе")
@Validated
@RestController
@RequestMapping("/api/group/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Operation(summary = "Создание поста в группе")
    @PostMapping("/create")
    public PostResponse createPost(@RequestBody @Valid CreatePostRequest request,
                                   @RequestHeader("Authorization") String token){
        return postService.createPost(request, token);
    }

    @Operation(summary = "Редактирование поста в группе")
    @PutMapping("/edit")
    public PostResponse editPost(@RequestBody @Valid EditPostRequest request,
                                 @RequestHeader("Authorization") String token){
        return postService.editPost(request, token);
    }

    @Operation(summary = "Удаление поста в группе")
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deletePost(@RequestBody DeletePostRequest request,
                                                 @RequestHeader("Authorization") String token){
        return postService.deletePost(request, token);
    }

}
