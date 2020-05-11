package pkg.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pkg.entity.People;

/**
 * Data access to People provided by spring-data-jpa
 */
public interface PeopleRepository extends JpaRepository<People, Integer> {
    
    @Query("SELECT e FROM People e "
         + "WHERE e.department.departmentDescription = :department "
         + "AND e.educationLevel = :eduLevel "
         + "AND e.position.payType = :payType")
    Collection<People> findByDeptEduPay(
            @Param("department") String department, 
            @Param("payType") String payType, 
            @Param("eduLevel") String educationLevel);
}