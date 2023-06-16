package CRUDApplication.demo.controller;


// import CRUDApplication.demo.dto.EmployeeShifts;
import CRUDApplication.demo.entity.Employee;
import CRUDApplication.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/all-users")
    public ResponseEntity<Object> getAllEmployee(){
        List<Employee> emp = null;
        try{
            emp = empService.getAllEmployee();
            return new ResponseEntity<>(emp,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/all-shift/{userId}")
        public ResponseEntity<Object> getAllShiftById(@PathVariable int userId){
            List<Employee> emp = null;
            try{
                emp = empService.getAllShiftById(userId);
                return new ResponseEntity<>(emp,HttpStatus.OK);
            }catch (Exception ex){
                return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable int id){
        Employee emp = null;
        try{
            emp = empService.getEmployeeById(id);
            return new ResponseEntity<>(emp,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add-emp")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee emp){
        String msg=null;
        try{
            msg = empService.addEmployee(emp);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee emp){
        String msg=null;
        try{
            msg = empService.updateEmployee(emp);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable int id){
        String msg = null;
        try{
            msg = empService.deleteEmployee(id);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
