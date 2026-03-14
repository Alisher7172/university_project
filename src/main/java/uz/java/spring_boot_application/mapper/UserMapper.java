package uz.java.spring_boot_application.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.java.spring_boot_application.dto.user.UserRequest;
import uz.java.spring_boot_application.dto.user.UserResponse;
import uz.java.spring_boot_application.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    public UserResponse toResponse(User user);

    User toEntity(UserRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromRequest(@MappingTarget User user, UserRequest request);
}
