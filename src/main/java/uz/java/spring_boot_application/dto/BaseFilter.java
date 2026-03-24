package uz.java.spring_boot_application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseFilter {
    private Integer page;
    private Integer limit;
    private String sortBy;
}
