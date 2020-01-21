package se.liu.ida.carek123.tddd78.lab2;

import java.time.LocalDate;
import java.time.Period;

public class Person
{
    private String name;
    private LocalDate birthDay;

    public Person(final String name, final LocalDate birthDay) {
	this.name = name;
	this.birthDay = birthDay;
    }

    public int getAge(){
        return Period.between(birthDay,LocalDate.now()).getYears();
    }


    @Override public String toString() {
	return name + " " + getAge();
    }

    public static void main(String[] args) {
	Person a = new Person("Calle",LocalDate.of(2000,10,15));
	Person b = new Person("Emma",LocalDate.of(2004,4,30));

	System.out.println(a.toString());
	System.out.println(b.toString());
    }
}
