package uz.java.spring_boot_application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.java.spring_boot_application.dto.faculty.FacultyFilter;
import uz.java.spring_boot_application.dto.faculty.FacultyRequest;
import uz.java.spring_boot_application.dto.faculty.FacultyResponse;
import uz.java.spring_boot_application.entities.Faculty;
import uz.java.spring_boot_application.entities.University;
import uz.java.spring_boot_application.exception.GenericNotFoundException;
import uz.java.spring_boot_application.mapper.FacultyMapper;
import uz.java.spring_boot_application.repository.FacultyRepository;
import uz.java.spring_boot_application.repository.UniversityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final UniversityRepository universityRepository;
    private final FacultyMapper mapper;

    public List<FacultyResponse> getAll(FacultyFilter filter) {
        int page = filter.page() != null ? filter.page() : 0;
        int limit = filter.limit() != null ? filter.limit() : 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                limit,
                Sort.by(filter.sortBy() != null ? filter.sortBy() : "id").ascending()
        );
        Page<Faculty> allCustom = null;
        if (filter.name() == null)
             allCustom = facultyRepository.findAllCustom(pageRequest);
        else
            allCustom = facultyRepository.findAllCustomByName(filter.name(), pageRequest);
        return allCustom.getContent().stream().map(mapper::toResponse).toList();
    }

    public FacultyResponse getOne(Long id) {
        Faculty faculty = facultyRepository.findById(id).orElseThrow(() ->
                new GenericNotFoundException("faculty.not.found")
        );
        return mapper.toResponse(faculty);
    }

    public Long create(FacultyRequest request) {
        universityRepository.findById(request.getUniversityId()).orElseThrow(
                () -> new GenericNotFoundException("university.not.found")
        );
        Faculty faculty = mapper.toEntity(request);
        facultyRepository.save(faculty);
        return faculty.getId();
    }

    public Long update(Long id, FacultyRequest request) {
        var faculty = facultyRepository.findById(id).orElseThrow(
                () -> new GenericNotFoundException("faculty.not.found")
        );
        mapper.updateFromRequest(request, faculty);
        if (request.getUniversityId() != null) {
            University university = universityRepository.findById(request.getUniversityId()).orElseThrow(
                    () -> new GenericNotFoundException("university.not.found")
            );
            faculty.setUniversity(university);
        }
        facultyRepository.save(faculty);
        return id;
    }

    public Boolean delete(Long id) {
        var faculty = facultyRepository.findById(id).orElse(null);
        if (faculty == null)
            throw new GenericNotFoundException("faculty.not.found");
        // CTRL + alt + L bossa kodni style ini taxlab beradi Intellij
        // CTRL + alt + O keraksiz import va code lani tozalaydi
        faculty.markAsDeleted();
        facultyRepository.save(faculty);
        return true;
    }
}
