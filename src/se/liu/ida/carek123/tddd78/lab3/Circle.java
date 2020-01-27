package se.liu.ida.carek123.tddd78.lab3;

import java.awt.Color;

public class Circle implements Shape
{
    private int x;
    private int y;
    private int radius;
    private Color color;

    public Circle(final int x, final int y, final int radius, final Color color) {
	this.x = x;
	this.y = y;
	this.radius = radius;
	this.color = color;
	if(radius<0){
	    throw new IllegalArgumentException("Negativ Radie!");
	}
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public int getRadius() {
	return radius;
    }

    public Color getColor() {
	return color;
    }

    @Override public void draw() {
	System.out.println("Ritar: " +this);
    }

    @Override public String toString() {
	return "x=" + x + ", y=" + y + ", radius=" + radius + ", color=" + color;
    }
}
