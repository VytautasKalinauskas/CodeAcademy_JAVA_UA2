package eu.codeacademy.javaua2.generic.model;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Person {
    private final String name;
    private final String surname;
}
