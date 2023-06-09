package eu.codeacademy.javaua2.diexample.dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InternalMarksDao implements MarksDao {

    @Override
    public List<Integer> getMarks() {
        return List.of(5, 8, 10, 10, 7, 6, 8);
    }
}
