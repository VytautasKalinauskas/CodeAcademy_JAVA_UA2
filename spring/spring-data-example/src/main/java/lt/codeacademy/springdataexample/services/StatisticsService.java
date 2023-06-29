package lt.codeacademy.springdataexample.services;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.springdataexample.dto.StatisticsDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.repositories.ExamRepository;
import lt.codeacademy.springdataexample.repositories.UserExamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class StatisticsService {

    private final ExamRepository examRepository;
    private final UserExamRepository userExamRepository;

    public List<StatisticsDTO> getAllStatistics() {
        List<Exam> exams = this.examRepository.findAll();
        if (exams.isEmpty()) {
            throw new NoSuchElementException("No exams found");
        }
        List<StatisticsDTO> examStatistics = new ArrayList<>();
        for (Exam e : exams) {
            examStatistics.add(getExamStatistics(e));
        }
        return examStatistics;
    }

    private StatisticsDTO getExamStatistics(Exam exam) {
        if (exam == null) {
            throw new Error("No exam provided");
        }

        StatisticsDTO statisticsDTO = new StatisticsDTO();
        statisticsDTO.setExamName(exam.getTitle());
        statisticsDTO.setAverageScore(this.userExamRepository.getAverageScoreByExamId(exam.getId()));
        statisticsDTO.setSubmissionCount(this.userExamRepository.countByExam_Id(exam.getId()));
        return statisticsDTO;
    }
}
