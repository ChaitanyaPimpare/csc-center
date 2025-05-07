package  com.chaitanya.csc_center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.chaitanya.csc_center.model.User;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
