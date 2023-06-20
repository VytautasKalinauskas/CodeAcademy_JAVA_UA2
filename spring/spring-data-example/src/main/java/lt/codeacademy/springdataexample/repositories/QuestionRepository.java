package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
