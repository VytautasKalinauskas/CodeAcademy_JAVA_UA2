package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.entities.UserExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserExamRepository extends JpaRepository<UserExam, Long> {

    @Query("SELECT AVG(score) FROM UserExam WHERE exam.id = :examId")
    Double getAverageScoreByExamId(Long examId);
}
