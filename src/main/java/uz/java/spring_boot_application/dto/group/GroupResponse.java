package uz.java.spring_boot_application.dto.group;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupResponse {
    Long id;
    String name;
    String groupNumber;
    Long facultyId;   // Ctrl + D qatorni duplicate qiladi
}
