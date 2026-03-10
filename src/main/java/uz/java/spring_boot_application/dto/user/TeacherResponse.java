package uz.java.spring_boot_application.dto.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherResponse {
    private Long id;
    private Double salary;
    private String qualification;
    private String experience;
    private Long subjectId;
    private Long facultyId;
    private UserResponse userResponse;

}
