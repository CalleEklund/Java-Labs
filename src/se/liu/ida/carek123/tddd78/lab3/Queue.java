package se.liu.ida.carek123.tddd78.lab3;

import se.liu.ida.carek123.tddd78.lab2.Person;

import java.util.ArrayList;
import java.util.List;


public class Queue extends ListManipulator
{
    private List<Person> elements;

    public Queue() {
	this.elements = new ArrayList<Person>();
    }

    public void enqueue(Person p) {
	elements.add(elements.size(),p);
    }

    public Person dequeue() {
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
