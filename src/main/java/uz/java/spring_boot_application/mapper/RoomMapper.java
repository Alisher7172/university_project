package uz.java.spring_boot_application.mapper;

import org.mapstruct.*;
import uz.java.spring_boot_application.dto.room.RoomRequest;
import uz.java.spring_boot_application.dto.room.RoomResponse;
import uz.java.spring_boot_application.entities.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomResponse toResponse(Room room);

    @Mapping(target = "group.id", source="groupId")
    Room toEntity(RoomRequest roomRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromRequest(RoomRequest roomRequest, @MappingTarget Room room);
}
