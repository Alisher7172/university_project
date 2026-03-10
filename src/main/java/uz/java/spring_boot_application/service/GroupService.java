package uz.java.spring_boot_application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.java.spring_boot_application.dto.group.GroupRequest;
import uz.java.spring_boot_application.dto.group.GroupResponse;
import uz.java.spring_boot_application.entities.Group;
import uz.java.spring_boot_application.exception.GenericNotFoundException;
import uz.java.spring_boot_application.mapper.GroupMapper;
import uz.java.spring_boot_application.repository.FacultyRepository;
import uz.java.spring_boot_application.repository.GroupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final FacultyRepository facultyRepository;

    public List<GroupResponse> getAll() {
        List<Group> all = groupRepository.findAll();
        return all.stream().map(groupMapper::toResponse).toList();
    }

    public GroupResponse getOne(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(
                () -> new GenericNotFoundException("Group not found")
        );
        return groupMapper.toResponse(group);
    }

    public Long create(GroupRequest request) {
        facultyRepository.findById(request.getFacultyId()).orElseThrow(
                () -> new GenericNotFoundException("Faculty not found")
        );
        Group group = groupMapper.toEntity(request);
        Group save = groupRepository.save(group);
        return save.getId();
    }

    public Boolean update(Long id, GroupRequest request) {
        Group group = groupRepository.findById(id).orElseThrow(
                () -> new GenericNotFoundException("Group not found")
        );
        groupMapper.updateFromRequest(request, group);
        groupRepository.save(group);
        return true;
    }

    public Boolean delete(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(
                () -> new GenericNotFoundException("Group not found")
        );
        group.markAsDeleted();
        groupRepository.save(group);
        return true;
    }
}
