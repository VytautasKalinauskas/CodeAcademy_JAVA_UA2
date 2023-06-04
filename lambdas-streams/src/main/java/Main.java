import model.CodeAcademyI;
import model.Gender;
import model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main (String[] args) {
        System.out.println("HEY");


        CodeAcademyI codeAcademyI = new CodeAcademyI() {
            @Override
            public void study(Integer time) {
                System.out.println("Time" + time);
            }

            @Override
            public void haveBreak(Integer time) {
                System.out.println("Break" + time);
            }
        };

        CodeAcademyFunctional codeAcademyFunctional = new CodeAcademyFunctional() {
            @Override
            public String method(String word) {
                return word.toUpperCase();
            }
        };

        CodeAcademyFunctional codeAcademyFunctionalLambda = (word) -> {
           return word.toUpperCase();
        };

        CodeAcademyTwoParametersI codeAcademyTwoParametersI = (word1, word2) -> System.out.println(word1 + word2);

        codeAcademyTwoParametersI.print("1", "2");

        String zalgiris1 = codeAcademyFunctional.method("zalgiris");
        String zalgiris2 = codeAcademyFunctionalLambda.method("zalgiris");

        Consumer<String> print = x -> System.out.println(x);
        print.accept("Zalgiris laimes");

        Consumer<Integer> square = (x) -> System.out.println(x*x);
        square.accept(5);

        Supplier<String> randomUUID = () -> UUID.randomUUID().toString();
        System.out.println(randomUUID.get());

        Predicate<Integer> isBiggerThanFive = (number) -> number > 5;
        System.out.println(isBiggerThanFive.test(10));

        Function<Integer, Integer> doubleNumber = (number) -> number * 2;
        Integer number = doubleNumber.apply(10);

        Student student = new Student("Vytautas", "Kalinauskas", 2, Gender.MALE);

        Consumer<Student> printStudentName = (student1) -> System.out.println(student1.getName());
        printStudentName.accept(student);

        Supplier<Student> createStudent = () -> new Student("Mindaugas", "Birutis", 3, Gender.FEMALE);
        Student mindaugas = createStudent.get();

        List<Student> group = new ArrayList<>(Arrays.asList(mindaugas, student));
        Map<Gender, List<Student>> maps = group.stream().collect(Collectors.groupingBy(student1 -> student1.getGender()));

        Predicate<Student> isHigherThan2ndCourse = (student2) -> student2.getCourse() > 2;
        System.out.println("Is Vytautas course higher than 2? " + isHigherThan2ndCourse.test(student));

        List<Integer> numbers = new ArrayList<>(Arrays.asList(6,9,10,4,4,15,90,3));
        ArrayList<Integer> numbersHigherThanFive = numbersHigherThanFive(numbers);

        List<String> list = new ArrayList<>();
        list.stream()
                .map((text) -> text.toUpperCase());

            numbers =
                numbers
                .stream()
                .filter((tempNumber) -> tempNumber > 5)
                .filter((tempNumber) -> tempNumber / 2 == 0)
                .collect(Collectors.toList());

        List<String> words = new ArrayList<>(Arrays.asList("Zalgiris", "Saule", "Alus", "Sestadienis", "Pienas", "Duona", "Duona"));

        Student goodStudent = new Student("Petras", "Grazulis", 3, Gender.MALE);
        Student badStudent = new Student("Karolis", "Blogietis", 4, Gender.MALE);
        Student intermediateStudent = new Student("Romas", "Vidurinis", 2, Gender.MALE);
        List<Student> studentGroup = new ArrayList<>(Arrays.asList(goodStudent, badStudent, intermediateStudent, intermediateStudent));


        /* map with strings example */
         words
                 .stream()
                 .map(word -> word.toUpperCase())
                 .forEach(word -> System.out.println(word));

         /* map with objects example */
         studentGroup
                 .stream()
                 .map(student1 -> student1.getName() + " " + student1.getSurname())
                 .forEach(student1 -> System.out.println(student1));

         List<Integer> studentsCourses = studentGroup
                 .stream()
                 .map(student1 -> student1.getCourse())
                 .collect(Collectors.toList());

         /* filter example with Strings */
         words
                 .stream()
                 .filter(word -> word.length() > 5)
                 .forEach(word -> System.out.println(word));

         /* filter example with objects */
        studentGroup
                .stream()
                .filter(student1 -> student1.getCourse() > 3)
                .forEach(student1 -> System.out.println(student1.getName() + " " + student1.getCourse()));


        /* peek example with Strings */
        words
                .stream()
                .filter(word -> word.length() > 5)
                .peek(word -> System.out.println("PEEK:" + word))
                .filter(word -> word.length() % 2 == 0)
                .forEach(word -> System.out.println(word));

        /* sorted example with Strings */
        words
                .stream()
                .sorted()
                .forEach(word -> System.out.println(word));

        /* sorted example with objects */
        studentGroup
                .stream()
                .sorted(Comparator.comparing(Student::getCourse))
                .forEach(student1 -> System.out.println(student1.getName() + " " + student1.getCourse()));

        /* sorted reversed example with objects */
        studentGroup
                .stream()
                .sorted(Comparator.comparing(Student::getCourse).reversed())
                .forEach(student1 -> System.out.println(student1.getName() + " " + student1.getCourse()));

        /* distinct example with Strings */
        words
                .stream()
                .distinct()
                .forEach(word -> System.out.println(word));

        /* distinct example with objects */
        studentGroup
                .stream()
                .distinct()
                .forEach(student1 -> System.out.println(student1.getName() + " " + student1.getCourse()));

        /* any match example with strings */
        Boolean hasWordStartingWithS = words
                .stream()
                .anyMatch(word -> word.startsWith("S"));
        System.out.println(hasWordStartingWithS);

        Boolean allWordsLongerThanFour = words
                .stream()
                .allMatch(word -> word.length() > 4);
        System.out.println(allWordsLongerThanFour);

        /* count example with strings */
        Long wordsEndingWithA = words
                .stream()
                .filter(word -> word.endsWith("a"))
                .count();
        System.out.println(wordsEndingWithA);

















    }


    static ArrayList<Integer> numbersHigherThanFive(List<Integer> numbers) {

        ArrayList<Integer> numbersHigherThanFive = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > 5) {
                numbersHigherThanFive.add(numbers.get(i));
            }
        }
        return numbersHigherThanFive;
    }


}
