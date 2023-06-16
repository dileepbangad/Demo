package CRUDApplication.demo.controller;


import CRUDApplication.demo.entity.User;
import CRUDApplication.demo.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addnew")
    public ResponseEntity<Object> addNewUser(@RequestBody User user){
        String msg = "";
        try{
            msg = userService.addNewUser(user);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> addNewUser(@RequestBody Map<String,Object> objectMap){
        String email = objectMap.get("email").toString();
        String password = objectMap.get("password").toString();
        User user;
        try{
             user = userService.getUserByEmail(email);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(user.getPassword().equals(password)){
            Map<String,Object> map = new HashMap<>();
            map.put("Name",user.getUserName());
            map.put("email",user.getUserEmail());
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        return new ResponseEntity<>("Credentials not match", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
