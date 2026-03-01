package uz.java.spring_boot_application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.java.spring_boot_application.dto.university.UniversityRequest;
import uz.java.spring_boot_application.dto.university.UniversityResponse;
import uz.java.spring_boot_application.entities.University;
import uz.java.spring_boot_application.mapper.UniversityMapper;
import uz.java.spring_boot_application.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final UniversityRepository universityRepository;
    private final UniversityMapper universityMapper;


    public List<UniversityResponse> getAll() {
        return universityRepository.findAllCustom()
                .stream().map(universityMapper::toResponse).toList();
    }

    public UniversityResponse getOne(Long id) {
        University university = universityRepository.findById(id).orElse(null);
        if (university == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "University not found");

        return universityMapper.toResponse(university);
    }

    public Long create(UniversityRequest request) {
        University university = universityMapper.toEntity(request);
        University response = universityRepository.save(university);// Alt + Enter bossa o`zgaruvchiga oladi
        return response.getId();
    }

    public Long update(Long universityId, UniversityRequest request) {
        Optional<University> optional = universityRepository.findById(universityId);
        if (!optional.isPresent())
            throw new RuntimeException("University not found");
        University university = optional.get();
        universityMapper.updateFromRequest(request, university);
        universityRepository.save(university);
        return universityId;
    }

    public Boolean delete(Long universityId) {
        // 1-usul
//        University university = universityRepository.findById(universityId).orElse(null);
        // 2-usul
//        University university = universityRepository.getReferenceById(universityId);
//        if (university == null)
//            throw new RuntimeException("university not found");
        // 3-usul
        University university = universityRepository.findById(universityId)
                .orElseThrow(() -> new RuntimeException("university not found"));
        // soft deleted boldi
        university.markAsDeleted();
        universityRepository.save(university);

        // hard deleted
//        universityRepository.delete(university);
        return true;
    }
}
