package eu.codeacademy.javaua2.generic;

import eu.codeacademy.javaua2.generic.task1.ListBox;

import java.util.List;

public class ElementListBox<E> implements ListBox<E> {

    private List<E> elements;

    public ElementListBox(List<E> elements) {
        this.elements = elements;
    }

    @Override
    public void addElements(E[] values) {
        this.elements.addAll(List.of(values));
    }

    @Override
    public void addElement(E value) {
        this.elements.add(value);
    }

    @Override
    public List<E> getElements() {
        return this.elements;
    }
}
