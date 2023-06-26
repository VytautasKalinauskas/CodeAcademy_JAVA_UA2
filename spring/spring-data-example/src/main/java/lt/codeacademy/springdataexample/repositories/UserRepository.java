package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
