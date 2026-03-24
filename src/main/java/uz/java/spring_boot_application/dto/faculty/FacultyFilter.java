package uz.java.spring_boot_application.dto.faculty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.java.spring_boot_application.dto.BaseFilter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyFilter extends BaseFilter {
    private String name;
    private Long universityId;

    public FacultyFilter(Integer page, Integer limit, String sortBy, String name, Long universityId) {
        super(page, limit, sortBy);
        this.name = name;
        this.universityId = universityId;
    }
}
