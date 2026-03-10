package uz.java.spring_boot_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.java.spring_boot_application.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {


}

