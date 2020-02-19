package se.liu.ida.carek123.tddd78.tetris;

import javax.swing.*;
import java.awt.*;

public class HighScore extends JPanel
{
    private JLabel score;
    private String name;
    private int points;

    public HighScore(final String name) {
	this.name = name;
	this.points = 0;
	score = new JLabel(this.name + "\n" + this.points);
	score.setFont(TetrisViewer.font);
	score.setOpaque(true);
	score.setBackground(Color.RED);
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
