package eu.codeacademy.javaua2.generic.methodgeneric;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintArrayGenericExample {

    public <E> List<E> printArray(E[] elements) {
        return Arrays.stream(elements)
                .collect(Collectors.toList());
    }
}
