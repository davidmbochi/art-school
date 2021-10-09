package com.company.schoolart.controller;

import com.company.schoolart.model.Group;
import com.company.schoolart.service.GroupsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/group")
public class GroupController {

    private final GroupsService groupsService;

    //Get all groups
    @GetMapping("/find/all")
    List<Group> findAllGroups(){
        return groupsService.getAllGroups();
    }

    //Get a group with  a given id
    @GetMapping("/find/{id}")
    Group findGroupById(@PathVariable("id") int id){
        return groupsService.findGroupById(id);
    }

    //add a group successfully and
    //add a group that has the same name as an existing group.
    //The operation should fail with a proper error status code
    @PostMapping("/add")
    Group addGroup(@RequestBody Group group){
        return groupsService.addGroup(group);
    }

    //update the name of a group
    @PutMapping("/update/{id}")
    Group updateGroupName(@RequestBody Group group, @PathVariable("id") int id){
        Group painting = groupsService.findGroupById(id);
        painting.setGroupName(group.getGroupName());
        return groupsService.updateGroupName(painting);
    }

}
