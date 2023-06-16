package CRUDApplication.demo.repository;

import CRUDApplication.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(nativeQuery = true,value = "select * from users where user_email=?1")
    User getUserByEmail(String email);
}
