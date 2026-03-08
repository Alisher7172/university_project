package uz.java.spring_boot_application.dto.subject;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectResponse {
    private String subjectName;
    private String description;
}
