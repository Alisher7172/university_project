package uz.java.spring_boot_application.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.java.spring_boot_application.entities.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    //    @Query("select t from Faculty t where t.name=:name and t.deleted = false ") bunda @Param() ichida shu nom yoziladi
    @Query("select t from Faculty t where t.deleted = false ")
    Page<Faculty> findAllCustom(Pageable pageable);

    @Query("select t from Faculty t where t.name=?1 and t.deleted = false ")
    Page<Faculty> findAllCustomByName(String name, PageRequest pageRequest);
}
