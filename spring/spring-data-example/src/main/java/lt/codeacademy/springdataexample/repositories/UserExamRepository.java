package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.entities.UserExam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExamRepository extends JpaRepository<UserExam, Long> {
}
