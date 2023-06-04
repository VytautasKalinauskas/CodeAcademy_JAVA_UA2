package eu.codeacademy.javaua2.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {
    private final String name;
    private final String surname;
}
