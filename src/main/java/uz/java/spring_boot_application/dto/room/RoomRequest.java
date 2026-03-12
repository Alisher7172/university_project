package uz.java.spring_boot_application.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.java.spring_boot_application.entities.Group;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequest {
    private String name;
    private String roomNumber;
    private Long groupId;
}
