package eu.codeacademy.javaua2.innerclass.annonimus;

public class AnnonimClassExample {

    public void init() {
        this.doMath((first, second) -> first + second);
        this.doMath((a, b) -> a - b);
    }

    private void doMath(TwoDigits twoDigits) {
        System.out.println(twoDigits.withTwoDigits(2, 5));
    }
}
