package eu.codeacademy.javaua2.generic.inheritence.task1;

import lombok.Builder;

public interface Tree {

    String has();

    default String get() {
        return this.getClass().getSimpleName() + " " + has();
    }
}
