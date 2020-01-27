package se.liu.ida.carek123.tddd78.lab3;

import java.awt.*;

public abstract class AbstractShape implements Shape
{
    protected int x;
    protected int y;
    protected Color color;

    public AbstractShape(final int x, final int y, final Color color) {
	this.x = x;
	this.y = y;
	this.color = color;
    }

    @Override public int getX() {
	return x;
    }

    @Override public int getY() {
	return y;
    }

    @Override public Color getColor() {
	return color;
    }
}
