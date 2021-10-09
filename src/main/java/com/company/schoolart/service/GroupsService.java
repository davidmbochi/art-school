package com.company.schoolart.service;

import com.company.schoolart.model.Group;

import java.util.List;

public interface GroupsService {
    List<Group> getAllGroups();
    Group findGroupById(int groupId);
    Group addGroup(Group group);
    Group updateGroupName(Group group);
}
