package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
