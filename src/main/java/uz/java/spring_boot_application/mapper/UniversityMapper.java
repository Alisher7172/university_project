package uz.java.spring_boot_application.mapper;

import org.mapstruct.*;
import uz.java.spring_boot_application.dto.university.UniversityRequest;
import uz.java.spring_boot_application.dto.university.UniversityResponse;
import uz.java.spring_boot_application.entities.University;

@Mapper(componentModel = "spring")
public interface UniversityMapper {

    @Mapping(source = "phone", target = "phoneNumber")
    UniversityResponse toResponse(University university);

    University toEntity(UniversityRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromRequest(UniversityRequest request, @MappingTarget University university);

    // source ga qavs ichidagi object
    // target ga nimaga ogirayotgan objectimiz
}
