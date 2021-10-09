package com.company.schoolart.repository;

import com.company.schoolart.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    Group findGroupById(int groupId);
    Group findGroupByGroupName(String groupName);
}
