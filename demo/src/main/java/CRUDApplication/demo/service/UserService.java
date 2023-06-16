package CRUDApplication.demo.service;


import CRUDApplication.demo.entity.User;
import CRUDApplication.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public String addNewUser(User user) {
        userRepository.save(user);
        return "User Added Sucessfully";
    }

    public User getUserByEmail(String email) {
        return  userRepository.getUserByEmail(email);
    }
}
