package uz.java.spring_boot_application.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.java.spring_boot_application.entities.University;

public interface UniversityRepository extends JpaRepository<University, Long> {
    //    @Query(value = "select * from universities u where u.is_deleted = false ", nativeQuery = true) -> bu ozimizni postgresql dagi query
    @Query("select t from University t where t.name ilike '%' || :name || '%' and t.phone" +
            " ilike '%' || :phone || '%' and t.deleted = false ")
    // bu HQL(Hibernate Query Language)
    Page<University> findAllCustom(@Param("name") String name,
                                   @Param("phone") String phone,
                                   Pageable pageable);
}
