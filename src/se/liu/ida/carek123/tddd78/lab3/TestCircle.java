package se.liu.ida.carek123.tddd78.lab3;

import java.awt.*;
import java.util.ArrayList;

public class TestCircle
{
    public static void main(String[] args) {
	final ArrayList<Circle> circles = new ArrayList<Circle>();

	Circle c1 = new Circle(3, 3, 2, Color.GREEN);
	Circle c2 = new Circle(1, 2, 5, Color.RED);
	Circle c3 = new Circle(4, 2, 7, Color.BLUE);

	circles.add(c1);
	circles.add(c2);
	circles.add(c3);

	for (Circle circle : circles) {
	    System.out.println(circle);
	}
    }
}
