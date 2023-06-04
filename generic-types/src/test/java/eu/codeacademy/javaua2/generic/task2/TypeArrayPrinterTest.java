package eu.codeacademy.javaua2.generic.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class TypeArrayPrinterTest {

    @Test
    void printArrayIntegers() {
        Integer[] ints = new Integer[]{1, 2, 3};
        List<Integer> result = new TypeArrayPrinter<Integer>().printArray(ints);

        Assertions.assertEquals(Arrays.toString(ints), Arrays.toString(result.toArray()));
    }

    @Test
    void printArrayStrings() {
        String[] strings = new String[]{"Code", "Academy", "World"};
        List<String> result = new TypeArrayPrinter<String>().printArray(strings);

        Assertions.assertEquals(Arrays.toString(strings), Arrays.toString(result.toArray()));
    }
}
