package uz.java.spring_boot_application.dto.user;

public record TeacherFilter(
        Integer page,
        Integer limit,
        String sortBy,
        Double salary,
        Long subjectId,
        Long facultyId) {
}
