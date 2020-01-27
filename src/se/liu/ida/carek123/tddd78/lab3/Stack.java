package se.liu.ida.carek123.tddd78.lab3;

import se.liu.ida.carek123.tddd78.lab2.Person;

import java.util.ArrayList;
import java.util.List;


public class Stack extends ListManipulator
{
    private List<Person> elements;

    public Stack() {
	this.elements = new ArrayList<Person>();
    }

    public void push(Person p) {
	elements.add(0,p);
    }

    public Person pop() {
	return elements.remove(0);

    }

    @Override public int size() {
        return elements.size();
    }

    @Override public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override public boolean contains(final Object o) {
        return elements.contains(o);
    }

    @Override public void clear() {
        elements.clear();
    }
}
