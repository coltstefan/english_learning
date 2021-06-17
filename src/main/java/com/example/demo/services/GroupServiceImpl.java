package com.example.demo.services;

import com.example.demo.domain.Company;
import com.example.demo.domain.Group;
import com.example.demo.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    @Override
    public Group save(Group g) {
        return groupRepository.save(g);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findALL();
    }

    @Override
    public List<Group> findGroupsByCompany(Company c) {
        return groupRepository.findGroupsByCompany(c);
    }

    @Override
    public Group findGroupById(Long id) {
        return groupRepository.findGroupById(id);
    }
}
