package se.liu.ida.carek123.tddd78.lab3;

import se.liu.ida.carek123.tddd78.lab2.Person;

import java.time.LocalDate;

public class TestQS
{
    public static void main(String[] args) {
	Stack s = new Stack();
	s.push(new Person("calle", LocalDate.of(2000, 10, 15)));
	s.push(new Person("emma", LocalDate.of(2004, 4, 30)));
	s.push(new Person("fredrik", LocalDate.of(1968, 6, 29)));

	while (!s.isEmpty()) {
	    System.out.println(s.pop());
	}

	Queue q = new Queue();
	q.enqueue(new Person("calle", LocalDate.of(2000, 10, 15)));
	q.enqueue(new Person("emma", LocalDate.of(2004, 4, 30)));
	q.enqueue(new Person("fredrik", LocalDate.of(1968, 6, 29)));

	while(!q.isEmpty()){
	    System.out.println(q.dequeue());
	}
    }
}
