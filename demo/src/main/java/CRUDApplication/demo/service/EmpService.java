package CRUDApplication.demo.service;

import java.util.List;

// import CRUDApplication.demo.dto.EmployeeShifts;
import CRUDApplication.demo.entity.Employee;
public interface EmpService {
    public List<Employee> getAllEmployee();
    public List<Employee> getAllShiftById(int userId);
    public Employee getEmployeeById(int id);
    public String addEmployee(Employee emp);
    public String updateEmployee(Employee emp);
    public String deleteEmployee(int id) throws Exception;

}
