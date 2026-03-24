package uz.java.spring_boot_application.dto.user;

public record TeacherFilter(Integer limit,
                            Integer page,
                            String sortBy,
                            Double salary,
                            Long subjectId,
                            Long facultyId) {
}
