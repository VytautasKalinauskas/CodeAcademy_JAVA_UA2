package eu.codeacademy.javaua2.generic.classgeneric;

public class ClassGenericExample {

    public void init() {
        Box<Integer> box = new Box<>();
        box.setObject(10);

        Integer number = box.getObject();  // all ok
        System.out.println(number);

        Box<String> stringBox = new Box<>();
        stringBox.setObject("Labas");

        String text = stringBox.getObject();  // all ok
        System.out.println(text);

        Integer number2 = box.getObject();  // all ok
        System.out.println(number2);
    }
}
