package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
