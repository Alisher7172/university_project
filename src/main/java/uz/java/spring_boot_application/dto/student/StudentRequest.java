package uz.java.spring_boot_application.dto.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    @NotNull(message = "age.must.not.be.null")
    @NotBlank(message = "age.must.not.be.blank")
    private Integer age;
    private String gender;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
