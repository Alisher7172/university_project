package uz.java.spring_boot_application.dto.room;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.java.spring_boot_application.entities.Group;

@Getter
@Setter
@Builder
public class RoomResponse {
    private String name;
    private String roomNumber;
    private Group group;
}
