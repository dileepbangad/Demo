package CRUDApplication.demo.service.impl;

import CRUDApplication.demo.dto.EmployeeShifts;
import CRUDApplication.demo.entity.Employee;
import CRUDApplication.demo.repository.EmpRepository;
import CRUDApplication.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.lang.String;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepository empRepository;


    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>) empRepository.findAll();
    }

    @Override
    public List<Employee> getAllShiftById(int userId){

        return empRepository.findAllByUserId(userId);
    }
    @Override
    public Employee getEmployeeById(int id) {
        return empRepository.findById(id).orElse(null);
    }

    @Override
    public String addEmployee(Employee emp)
    {
        empRepository.save(emp);
        return "employee added Successfully";
    }

    @Override
    public String updateEmployee(Employee emp) {
        Employee emp1 = empRepository.findById(emp.getId()).orElse(null);
        emp1.setUserId(emp.getUserId());
        emp1.setStageId(emp.getStageId());
        emp1.setShiftType(emp.getShiftType());
        emp1.setsDate(emp.getsDate());
        emp1.seteDate(emp.geteDate());
        empRepository.save(emp1);
        return "Details Updated Successfully";
    }

    @Override
    public String deleteEmployee(int id) throws Exception {
        Employee deleteEmp = null;
            deleteEmp = empRepository.findById(id).orElse(null);
            if(deleteEmp==null){
                throw new Exception("employee not exist");
            }else {
                empRepository.deleteById(id);
            }
        return "Employee Removed"+id;
    }
}
