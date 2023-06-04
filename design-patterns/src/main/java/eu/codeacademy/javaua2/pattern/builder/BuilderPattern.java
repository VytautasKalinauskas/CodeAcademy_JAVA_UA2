package eu.codeacademy.javaua2.pattern.builder;

import eu.codeacademy.javaua2.model.Person;

public class BuilderPattern {

    public Person createPerson(String name, String surname) {
        return Person.builder()
                .name(name)
                .surname(surname)
                .build();
    }
}
