package se.liu.ida.carek123.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;


public class StartScreen extends JComponent
{


    ImageIcon startIcon = new ImageIcon(ClassLoader.getSystemResource("pic.jpg"));

    public void paintComponent(final Graphics g) {
	final Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	final AffineTransform old = g2d.getTransform();

	final AffineTransform at = AffineTransform.getScaleInstance(1, 1);

	at.translate(10, 10);

	//at.scale(0.5, 0.5);

	g2d.setTransform(at);

	startIcon.paintIcon(this, g, 0, 0);

	g2d.setTransform(old);
    }

    @Override public Dimension getPreferredSize() {
	return new Dimension(400, 400);
    }

    public static void main(String[] args) {
	final JFrame frame = new JFrame("Graphics2D Test");
	frame.setLayout(new GridLayout(1, 1));
	StartScreen screen = new StartScreen();

	frame.add(screen);
	//frame.setSize(300, 300);
	//frame.setSize(screen.getSize());
	frame.pack();
	frame.setVisible(true);
    }


}
