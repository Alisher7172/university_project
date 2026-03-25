package uz.java.spring_boot_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.java.spring_boot_application.entities.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByCode(String code);
}
