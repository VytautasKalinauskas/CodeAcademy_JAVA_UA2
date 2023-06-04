package eu.codeacademy.javaua2.generic.task1;

import eu.codeacademy.javaua2.generic.ElementListBox;
import eu.codeacademy.javaua2.generic.model.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonListBoxTest {

    @Test
    void addElementsWhenInitialListEmpty() {
        Person[] values = new Person[2];
        values[0] = Person.builder().name("Petras").surname("Petraitis").build();
        values[1] = Person.builder().name("Antanas").surname("Antanaitis").build();

        ElementListBox<Person> stringListBox = new ElementListBox<Person>(new ArrayList<>());
        stringListBox.addElements(values);

        List<Person> personList = stringListBox.getElements();
        assertEquals(2, personList.size());
        assertEquals(values[0].toString(), personList.get(0).toString());
        assertEquals(values[1].toString(), personList.get(1).toString());
    }

    @Test
    void addElementsWhenInitialListNotEmpty() {
        Person[] values = new Person[2];
        values[0] = Person.builder().name("Petras").surname("Petraitis").build();
        values[1] = Person.builder().name("Antanas").surname("Antanaitis").build();

        Person person1 = Person.builder().name("Zana").surname("Dark").build();
        List<Person> initial = new ArrayList<>(
                Arrays.asList(
                        person1
                )
        );
        ElementListBox<Person> stringListBox = new ElementListBox<Person>(initial);
        stringListBox.addElements(values);

        List<Person> personList = stringListBox.getElements();
        assertEquals(3, personList.size());
        assertEquals(person1.toString(), personList.get(0).toString());
        assertEquals(values[0].toString(), personList.get(1).toString());
        assertEquals(values[1].toString(), personList.get(2).toString());
    }

    @Test
    void addElementWhenInitialListIsEmpty() {
        ElementListBox<Person> stringListBox = new ElementListBox<Person>(new ArrayList<>());
        Person person1 = Person.builder().name("Zana").surname("Dark").build();
        stringListBox.addElement(person1);

        List<Person> personList = stringListBox.getElements();
        assertEquals(1, personList.size());
        assertEquals(person1.toString(), personList.get(0).toString());
    }

    @Test
    void addElementWhenInitialListIsNotEmpty() {
        List<Person> initial = new ArrayList<>(
                Arrays.asList(
                        Person.builder().name("Petras").surname("Petraitis").build()
                )
        );
        ElementListBox<Person> stringListBox = new ElementListBox<Person>(initial);
        Person person1 = Person.builder().name("Zana").surname("Dark").build();
        stringListBox.addElement(person1);

        List<Person> personList = stringListBox.getElements();
        assertEquals(2, personList.size());
        assertEquals(initial.get(0).toString(), personList.get(0).toString());
        assertEquals(person1.toString(), personList.get(1).toString());
    }
}
