package uz.java.spring_boot_application.dto.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequest {
    private Long subjectId;
    private String subjectName;
    private String description;
}
