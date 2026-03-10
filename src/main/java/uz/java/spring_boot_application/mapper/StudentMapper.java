package uz.java.spring_boot_application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.java.spring_boot_application.dto.student.StudentRequest;
import uz.java.spring_boot_application.dto.student.StudentResponse;
import uz.java.spring_boot_application.entities.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "group.id", target = "groupId")
    StudentResponse toResponse(Student student);

    Student toEntity(StudentRequest request);
}
