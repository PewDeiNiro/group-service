package com.pewde.groupservice.service;

import com.pewde.groupservice.entity.Group;
import com.pewde.groupservice.entity.User;
import com.pewde.groupservice.entity.Wall;
import com.pewde.groupservice.enums.WallType;
import com.pewde.groupservice.exception.GroupDoesNotExistsException;
import com.pewde.groupservice.exception.UserDoesNotExistsException;
import com.pewde.groupservice.feign.ProfileClient;
import com.pewde.groupservice.mapper.GroupMapper;
import com.pewde.groupservice.mapper.RequestMapper;
import com.pewde.groupservice.repository.GroupRepository;
import com.pewde.groupservice.repository.UserRepository;
import com.pewde.groupservice.request.CreateGroupRequest;
import com.pewde.groupservice.request.CreatePostRequest;
import com.pewde.groupservice.request.FeignCreatePostRequest;
import com.pewde.groupservice.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupMapper groupMapper;


    public Group getGroupById(int id){
        return groupRepository.findById(id).orElseThrow(GroupDoesNotExistsException::new);
    }

    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    public Group createGroup(CreateGroupRequest request, String token){
        User user = userRepository.findById(request.getUserId()).orElseThrow(UserDoesNotExistsException::new);
//        AuthService.checkAuth(user, token);
        Wall wall = new Wall();
        wall.setType(WallType.GROUP_WALL);
        Group group = groupMapper.mapCreateGroupRequestToGroup(request);
        group.getAdmins().add(user);
        group.getSubscribers().add(user);
        group.setCreator(user);
        group.setWall(wall);
        return groupRepository.saveAndFlush(group);
    }



}
