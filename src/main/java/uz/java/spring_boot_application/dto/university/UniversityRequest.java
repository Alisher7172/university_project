package uz.java.spring_boot_application.dto.university;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniversityRequest {
    @NotNull(message = "name.must.not.be.null")
    @NotBlank(message = "name.must.not.be.blank")
     String name;
     String address;
     String phone;
     String email;
     String logo;
     String website;
     List<String> attachmentUrls;
}
