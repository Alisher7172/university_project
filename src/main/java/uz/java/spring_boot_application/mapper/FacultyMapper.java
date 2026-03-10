package uz.java.spring_boot_application.mapper;

import org.mapstruct.*;
import uz.java.spring_boot_application.dto.faculty.FacultyRequest;
import uz.java.spring_boot_application.dto.faculty.FacultyResponse;
import uz.java.spring_boot_application.entities.Faculty;

@Mapper(componentModel = "spring", uses = {UniversityMapper.class})
public interface FacultyMapper {

    FacultyResponse toResponse(Faculty faculty);

    @Mapping(source = "universityId", target = "university.id")
    Faculty toEntity(FacultyRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromRequest(FacultyRequest request, @MappingTarget Faculty faculty);
}
