package uz.java.spring_boot_application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.java.spring_boot_application.dto.student.StudentRequest;
import uz.java.spring_boot_application.dto.student.StudentResponse;
import uz.java.spring_boot_application.entities.Student;
import uz.java.spring_boot_application.mapper.StudentMapper;
import uz.java.spring_boot_application.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentResponse> getAll() {
        return studentRepository.findAll().stream().map(
                studentMapper::toResponse
        ).toList();
    }

    public StudentResponse getOne(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("student not found")
        );
        return studentMapper.toResponse(student);
    }


    public Long create(StudentRequest request) {
        Student entity = studentMapper.toEntity(request);
        Student save = studentRepository.save(entity);
        return save.getId();
    }
}
