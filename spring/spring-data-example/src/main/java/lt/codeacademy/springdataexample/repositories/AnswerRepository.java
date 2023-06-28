package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.entities.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Page<Answer> findByQuestion_TextStartsWithIgnoreCaseOrQuestion_TextStartsWithIgnoreCaseOrQuestion_TextStartsWithIgnoreCase(@NonNull String text, @Nullable String text1, @Nullable String text2, Pageable pageable);

    @Query(value = "SELECT * FROM answer WHERE is_correct = :isCorrect", nativeQuery = true)
    List<Answer> getAnswersByIsCorrect(@Param("isCorrect") Boolean isCorrect);

    @Query(value = "SELECT a FROM Answer a WHERE a.isCorrect = :isCorrect")
    List<Answer> getAnswersByIsCorrectHql(@Param("isCorrect") Boolean isCorrect);

    List<Answer> findAllByIsCorrect(Boolean isCorrect);

}
