package se.liu.ida.carek123.tddd78.lab3;

import java.awt.*;
import java.util.ArrayList;

public class TestShapes
{
    public static void main(String[] args) {
	final ArrayList<Shape> shapes = new ArrayList<Shape>();

	Circle c1 = new Circle(3, 3, 2, Color.GREEN);
	Circle c2 = new Circle(1, 2, 5, Color.RED);
	Rectangle r1 = new Rectangle(4, 2, 7, 8, Color.BLUE);
	Text t1 =  new Text(2,2,16, Color.BLACK,"testtext");
	shapes.add(c1);
	shapes.add(c2);
	shapes.add(r1);
	shapes.add(t1);

	/*for (Shape shape : shapes) {
	    shape.draw();
	    //System.out.println(shape.getX() + " " + shape.getY());
	}*/
    }
}
