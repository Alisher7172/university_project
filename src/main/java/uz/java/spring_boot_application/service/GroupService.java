package uz.java.spring_boot_application.service;

import org.springframework.stereotype.Service;
import uz.java.spring_boot_application.dto.group.GroupResponse;
import uz.java.spring_boot_application.entities.Group;
import uz.java.spring_boot_application.repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<GroupResponse> getAll() {
        List<Group> all = groupRepository.findAll();
        List<Group> allNotDeletedGroups = all.stream().filter(g -> !g.isDeleted()).toList();
        List<GroupResponse> response = new ArrayList<>();
        for (Group group : allNotDeletedGroups) {
            GroupResponse groupResponse = new GroupResponse();
            groupResponse.setId(group.getId());
            groupResponse.setName(group.getName());
            groupResponse.setGroupNumber(group.getGroupNumber());
            groupResponse.setFacultyId(group.getFaculty().getId());
            response.add(groupResponse);
        }
        return response;
    }
}
