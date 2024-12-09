package com.pewde.groupservice.service;

import com.pewde.groupservice.entity.Group;
import com.pewde.groupservice.exception.GroupDoesNotExistsException;
import com.pewde.groupservice.feign.ProfileClient;
import com.pewde.groupservice.mapper.RequestMapper;
import com.pewde.groupservice.repository.GroupRepository;
import com.pewde.groupservice.request.CreatePostRequest;
import com.pewde.groupservice.request.DeletePostRequest;
import com.pewde.groupservice.request.EditPostRequest;
import com.pewde.groupservice.request.FeignCreatePostRequest;
import com.pewde.groupservice.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PostService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private RequestMapper requestMapper;

    @Autowired
    private ProfileClient profileClient;

    public PostResponse createPost(CreatePostRequest request, String token){
        Group group = groupRepository.findById(request.getGroupId()).orElseThrow(GroupDoesNotExistsException::new);
        FeignCreatePostRequest feignRequest = requestMapper.mapCreatePostRequest(request);
        feignRequest.setWallId(group.getWall().getId());
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", token);
        return profileClient.createPost(headers, feignRequest);
    }

    public PostResponse editPost(EditPostRequest request, String token){
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", token);
        return profileClient.editPost(headers, request);
    }

    public ResponseEntity<HttpStatus> deletePost(DeletePostRequest request, String token){
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", token);
        return profileClient.deletePost(headers, request);
    }

}
