package se.liu.ida.carek123.tddd78.lab3;

import java.awt.*;

public class Circle extends AbstractShape
{
    private int radius;

    public Circle(final int x, final int y, final int radius, final Color color) {
	super(x, y, color);
	this.radius = radius;
	if(radius<0){
	    throw new IllegalArgumentException("Negativ Radie!");
	}
    }

    public int getRadius() {
	return radius;
    }

    @Override public void draw(final Graphics g) {

        //System.out.println("Ritar: " + this);
	g.setColor(color);
	g.drawOval(x,y,radius,radius);
    }

    @Override public String toString() {
	return "x=" + getX() + ", y=" + getY() + ", radius=" + radius + ", color=" + getColor();
    }
}
