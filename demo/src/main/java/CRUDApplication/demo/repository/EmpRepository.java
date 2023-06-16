package CRUDApplication.demo.repository;

import CRUDApplication.demo.dto.EmployeeShifts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import CRUDApplication.demo.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer> {
//    @Query("select e FROM employee e where userid = ?")
    List<Employee> findAllByUserId(Integer userId);
}
