package com.company.schoolart.service;

import com.company.schoolart.model.Group;
import com.company.schoolart.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupsService {
    private final GroupRepository groupRepository;

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group findGroupById(int groupId) {
        return groupRepository.findGroupById(groupId);
    }

    @Override
    public Group addGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group updateGroupName(Group group) {
        return groupRepository.save(group);
    }
}
