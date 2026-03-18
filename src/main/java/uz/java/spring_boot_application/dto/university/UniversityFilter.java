package uz.java.spring_boot_application.dto.university;

public record UniversityFilter(
        String phone, String name, Integer page, Integer limit, String sortBy
) {
}
