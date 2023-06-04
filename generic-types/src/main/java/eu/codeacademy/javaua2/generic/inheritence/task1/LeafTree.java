package eu.codeacademy.javaua2.generic.inheritence.task1;

import lombok.Builder;

@Builder
public class LeafTree implements Tree {
    @Override
    public String has() {
        return "turi lapus";
    }
}
