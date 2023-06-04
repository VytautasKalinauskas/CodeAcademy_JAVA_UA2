package eu.codeacademy.javaua2.generic.task1;

import eu.codeacademy.javaua2.generic.ElementListBox;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListBoxTest {

    @Test
    void addElementsWhenInitialListEmpty() {
        String[] values = new String[2];
        values[0] = "a";
        values[1] = "b";

        ElementListBox<String> stringListBox = new ElementListBox<String>(new ArrayList<>());
        stringListBox.addElements(values);

        List<String> stringList = stringListBox.getElements();
        assertEquals(2, stringList.size());
        assertEquals("a", stringList.get(0));
        assertEquals("b", stringList.get(1));
    }

    @Test
    void addElementsWhenInitialListNotEmpty() {
        String[] values = new String[2];
        values[0] = "a";
        values[1] = "b";

        List<String> initial = new ArrayList<>(Arrays.asList("Vienas", "Du"));
        ElementListBox<String> stringListBox = new ElementListBox<String>(initial);
        stringListBox.addElements(values);

        List<String> stringList = stringListBox.getElements();
        assertEquals(4, stringList.size());
        assertEquals("Vienas", stringList.get(0));
        assertEquals("Du", stringList.get(1));
        assertEquals("a", stringList.get(2));
        assertEquals("b", stringList.get(3));
    }

    @Test
    void addElementWhenInitialListIsEmpty() {
        ElementListBox<String> stringListBox = new ElementListBox<String>(new ArrayList<>());
        stringListBox.addElement("a");

        List<String> stringList = stringListBox.getElements();
        assertEquals(1, stringList.size());
        assertEquals("a", stringList.get(0));
    }

    @Test
    void addElementWhenInitialListIsNotEmpty() {
        List<String> initial = new ArrayList<>(Arrays.asList("Vienas", "Du"));
        ElementListBox<String> stringListBox = new ElementListBox<String>(initial);
        stringListBox.addElement("a");

        List<String> stringList = stringListBox.getElements();
        assertEquals(3, stringList.size());
        assertEquals("Vienas", stringList.get(0));
        assertEquals("Du", stringList.get(1));
        assertEquals("a", stringList.get(2));
    }
}
