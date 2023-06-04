package eu.codeacademy.javaua2.diexample.service;

import eu.codeacademy.javaua2.diexample.dao.MarksDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GradeInternalService {

    private final MarksDao marksDao;

    public GradeInternalService(@Qualifier("externalMarksDao") MarksDao marksDao) {
        this.marksDao = marksDao;
    }

    public Double avarageGrade () {
        Double sum = 0.0;

        for (Integer grade: marksDao.getMarks()) {
            sum += grade;
        }

        return sum / marksDao.getMarks().size();
    }
}
