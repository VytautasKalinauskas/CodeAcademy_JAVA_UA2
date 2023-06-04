package service;


import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorServiceTest {


    private static CalculatorService calculatorService;

    @BeforeAll
    static void setUp() {
        System.out.println("Setting up");
        calculatorService = new CalculatorService();
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Tear down");
    }


    @Test
    void findMaxValueTest() {

        System.out.println("findMaxValueTest");

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(9,6,333,5,0,-1,44));

        Integer maxNumber = calculatorService.findMaxValue(numbers);

        assertEquals(maxNumber, 333);

    }

    @Test
    void findMaxValueTestWithEmptyArrayList() {

        System.out.println("findMaxValueTestWithEmptyArrayList");

        ArrayList<Integer> numbers = new ArrayList<>();

        Integer maxNumber = calculatorService.findMaxValue(numbers);

        assertNull(maxNumber);

    }

    @Test
    void findMaxValueTestWithNull() {

        System.out.println("findMaxValueTestWithNull");

        Integer maxNumber = calculatorService.findMaxValue(null);

        assertNull(maxNumber);

    }

    @Test
    void findMaxValueTestContainingNullValuesInArrayList() {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(6,9,20,22,null,17,5));

        Integer maxNumber = calculatorService.findMaxValue(numbers);

        assertEquals(maxNumber, 22);

    }

    @Test
    void calculateSumOperationTest() {

        Integer sum = calculatorService.calculate(10,6, '+');

        assertEquals(sum, 16);

    }

    @Test
    void calculateSubtractOperationTest() {

        Integer sum = calculatorService.calculate(10,6, '-');

        assertEquals(sum, 4);

    }

    @Test
    void calculateSubtractMultiplyTest() {

        Integer sum = calculatorService.calculate(10,6, '*');

        assertEquals(sum, 60);

    }

    @Test
    void calculateSubtractDivideTest() {

        Integer sum = calculatorService.calculate(10,6, '/');

        assertEquals(sum, 1);

    }

    @Test
    void calculateIllegalOperationTest() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate(10,6,'.');
        });

        assertEquals(exception.getMessage(), "Illegal operation .");

    }


    @Test
    void calculateSubtractDivideByZeroTest() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate(10,0,'/');
        });

        assertEquals(exception.getMessage(), "Cannot divide by zero");

    }


    @Test
    void fibonacciSequenceFirstElementTest() {
        Integer number = calculatorService.fibonacciSequence(1);
        assertEquals(number, 1);

    }

    @Test
    void fibonacciSequenceSecondElementTest() {
        CalculatorService calculatorService = new CalculatorService();
        Integer number = calculatorService.fibonacciSequence(2);

        assertEquals(number, 1);

    }

    @Test
    void fibonacciSequenceNegativeElementTest() {
        CalculatorService calculatorService = new CalculatorService();
        Integer number = calculatorService.fibonacciSequence(-100);

        assertEquals(number, -1);

    }

    @Test
    void fibonacciSequenceSeventhElementTest() {
        CalculatorService calculatorService = new CalculatorService();
        Integer number = calculatorService.fibonacciSequence(7);

        assertEquals(number, 13);
    }

    @Test
    void fibonacciSequenceTwelfthElementTest() {
        CalculatorService calculatorService = new CalculatorService();
        Integer number = calculatorService.fibonacciSequence(12);

        assertEquals(number, 144);
    }


    @Test
    void solveQuadraticEquationNoAnswersTest() {
        CalculatorService calculatorService = new CalculatorService();
        Pair<Double, Double> answer = calculatorService.solveQuadraticEquation(5,6,3);

        assertNull(answer.getLeft());
        assertNull(answer.getRight());
    }

    @Test
    void solveQuadraticEquationOneAnswerTest() {
        CalculatorService calculatorService = new CalculatorService();
        Pair<Double, Double> answer = calculatorService.solveQuadraticEquation(1,4,4);

        assertEquals(answer.getLeft(), -2.0);
        assertNull(answer.getRight());
    }

    @Test
    void solveQuadraticEquationTwoAnswersTest() {
        CalculatorService calculatorService = new CalculatorService();
        Pair<Double, Double> answer = calculatorService.solveQuadraticEquation(1,7,6);

        assertEquals(answer.getLeft(), -1.0);
        assertEquals(answer.getRight(), -6.0);
    }

    @Test
    void findSecondHighestNumberThreeNumbersTest() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2,4,3));
        Integer number = calculatorService.findSecondHighestNumber(numbers);

        assertEquals(number, 3);
    }

    @Test
    void findSecondHighestNumberTwoNumbersTest() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2,3));
        Integer number = calculatorService.findSecondHighestNumber(numbers);

        assertEquals(number, 2);
    }

    @Test
    void findSecondHighestNumberLessThanTwoNumbersTest() {

        ArrayList<Integer> numbers = new ArrayList<>();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.findSecondHighestNumberVadimas(numbers);
        });

        assertEquals(exception.getMessage(), "At least 2 numbers has to be present");

    }

    @Test
    void findSecondHighestNumberLessThanTwoNumbersTestKarolis() {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(-10,-100,10));

        Integer number = calculatorService.findSecondHighestNumberKarolis(numbers);

        assertEquals(number, -10);

    }



    @Test
    void findSecondHighestNumberLessThanTwoNumbersTestVadimas() {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(-10));

        Integer number = calculatorService.findSecondHighestNumberKarolis(numbers);

        assertEquals(number, -10);

    }


}
