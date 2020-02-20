package se.liu.ida.carek123.tddd78.tetris;

import javax.swing.*;

public class HighScore extends JPanel
{
    private String name;
    private int points;

    public HighScore(final String name, final int points) {
	this.name = name;
	this.points = points;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public int getPoints() {
	return points;
    }

    public void setPoints(final int points) {
	this.points = points;
    }
}
