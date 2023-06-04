package eu.codeacademy.javaua2.generic.mapgeneric;

import eu.codeacademy.javaua2.generic.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapGenericTest {

    @Test
    void get() {
        var result = new MapGeneric<String, Integer>().get(10);
        assertEquals(10, result);
    }

    @Test
    void getAsStringResult() {
        var result1 = new MapGeneric<String, Integer>().getAsStringResult(10);
        assertEquals("10(modified)", result1);
    }

    @Test
    void getAsString() {
        var result1 = new MapGeneric<String, Integer>().getAsString("Labas");
        assertEquals("Labas", result1);

        var result2 = new MapGeneric<Person, Integer>().getAsString(
                Person.builder()
                        .name("Petras")
                        .surname("Petraitis")
                        .build()
        );
        assertEquals("Person(name=Petras, surname=Petraitis)", result2);
    }
}
