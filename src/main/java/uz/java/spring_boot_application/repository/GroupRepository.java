package uz.java.spring_boot_application.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.java.spring_boot_application.entities.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Long> {
    @Query("""
        SELECT t FROM Group t
        WHERE (:name IS NULL OR t.name = :name)
          AND (:facultyId IS NULL OR t.faculty.id = :facultyId)
          AND (:groupNumber IS NULL OR t.groupNumber= :groupNumber)
        """)
    Page<Group> findAllCustom(String name, String groupNumber, Long facultyId, Pageable pageable);
}
