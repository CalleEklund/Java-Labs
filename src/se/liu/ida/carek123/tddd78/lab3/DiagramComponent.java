package se.liu.ida.carek123.tddd78.lab3;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DiagramComponent extends JComponent
{
    private ArrayList shapes;

    public DiagramComponent() {
	this.shapes = new ArrayList();
    }

    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);

	// Senare ska vi rita upp alla former här!
    }
    public void addShape(Shape s){
        shapes.add(s);
    }
}
