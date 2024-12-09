package com.pewde.groupservice.controller;

import com.pewde.groupservice.entity.Group;
import com.pewde.groupservice.request.CreateGroupRequest;
import com.pewde.groupservice.request.CreatePostRequest;
import com.pewde.groupservice.response.PostResponse;
import com.pewde.groupservice.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "GroupController", description = "Все операции связанные с группами")
@Validated
@RestController
@RequestMapping("/api/group/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Operation(summary = "Получение группы по уникальному идентификатору")
    @GetMapping("{id}")
    public Group getGroupById(@PathVariable int id){
        return groupService.getGroupById(id);
    }

    @Operation(summary = "Получение списка всех групп в системе")
    @GetMapping("/groups")
    public List<Group> getAllGroups(){
        return groupService.getAllGroups();
    }

    @Operation(summary = "Операция создания группы")
    @PostMapping("/create")
    public Group createGroup(@RequestBody @Valid CreateGroupRequest request,
                             @RequestHeader("Authorization") String token){
        return groupService.createGroup(request, token);
    }

    @Operation(summary = "Создание поста в группе")
    @PostMapping("/post/create")
    public PostResponse createPost(@RequestBody @Valid CreatePostRequest request,
                                   @RequestHeader("Authorization") String token){
        return groupService.createPost(request, token);
    }

}
