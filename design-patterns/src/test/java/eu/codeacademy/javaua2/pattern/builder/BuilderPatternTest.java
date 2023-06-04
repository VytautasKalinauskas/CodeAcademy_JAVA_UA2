package eu.codeacademy.javaua2.pattern.builder;

import eu.codeacademy.javaua2.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderPatternTest {

    @Test
    void createPersonSouldReturnNotChangedValues() {
        // given
        var builderPattern = new BuilderPattern();

        // when
        var result = builderPattern.createPerson("Petras", "Petraitis");

        // then
        assertEquals("Petras", result.getName());
        assertEquals("Petraitis", result.getSurname());
    }
}
