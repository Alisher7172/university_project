package uz.java.spring_boot_application.dto.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.java.spring_boot_application.dto.BaseFilter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectFilter extends BaseFilter {
    private String name;

    public SubjectFilter(Integer page, Integer limit, String sortBy, String name) {
        super(page, limit, sortBy);
        this.name = name;
    }
}
