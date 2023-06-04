package eu.codeacademy.javaua2.generic.task2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeArrayPrinter<E> {

    public List<E> printArray(E[] elements) {
        return Arrays.stream(elements)
                .collect(Collectors.toList());
    }
}
