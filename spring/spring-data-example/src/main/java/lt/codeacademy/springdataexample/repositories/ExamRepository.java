package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.entities.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    Page<Exam> findAllByDifficulty(Integer difficulty, Pageable pageable);

    Boolean existsByTitle(String title);

}
