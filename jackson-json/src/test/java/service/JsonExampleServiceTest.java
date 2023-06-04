package service;

import eu.codeacademy.javaua2.model.Car;
import eu.codeacademy.javaua2.model.Person;
import eu.codeacademy.javaua2.service.JsonExampleService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonExampleServiceTest {

    private static JsonExampleService jsonExampleService;

    @BeforeAll
    static void setUp() {
        jsonExampleService = new JsonExampleService();
    }

    @Test
    void basicDeserializationFromResourcesExampleTest() {

        Car car = jsonExampleService.basicDeserializationFromResourcesExample();

        assertEquals(car.getName(), "Audi");

    }


}
