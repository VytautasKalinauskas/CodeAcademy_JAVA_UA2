package eu.codeacademy.javaua2.diexample.dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExternalMarksDao implements MarksDao {

    @Override
    public List<Integer> getMarks() {
        return List.of(10, 10, 10, 10, 2);
    }
}
