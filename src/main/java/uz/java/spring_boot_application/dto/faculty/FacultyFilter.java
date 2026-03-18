package uz.java.spring_boot_application.dto.faculty;

public record FacultyFilter(Integer page,
                            Integer limit,
                            String sortBy,
                            String name) {
}
