package uz.java.spring_boot_application.dto.group;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupRequest {
    @NotNull(message = "group.name.must.not.be.null")
    @NotBlank(message = "group.name.must.not.be.blank")
    private String name;
    private String groupNumber;
    @NotNull(message = "faculty.id.must.not.be.null")
    private Long facultyId;
}
