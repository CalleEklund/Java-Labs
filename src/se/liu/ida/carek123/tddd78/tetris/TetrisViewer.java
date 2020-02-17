package se.liu.ida.carek123.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    private Board b;
    private final static int FONT_SIZE = 16;
    private final static int WIDTH = 10;
    private final static int HEIGHT = 18;

    private Timer clockTimer;

    public TetrisViewer(final Board b) {
	this.b = b;
	clockTimer = new Timer(100, null);

	clockTimer.setCoalesce(true);
	clockTimer.start();

    }

    public void show() {
	JFrame frame = new JFrame("Tetris");
	JTextArea textarea = new JTextArea(b.getHeight(), b.getWidth());
	TetrisComponent tc = new TetrisComponent(b);


	final Action doOneStep = new AbstractAction()
	{
	    @Override public void actionPerformed(ActionEvent e) {
		if (!b.isGameOver()) {
		    b.addBoardListeners(tc);
		    b.tick();


		} else {
		    clockTimer.stop();
		}

	    }
	};

	clockTimer.addActionListener(doOneStep);

	frame.setLayout(new BorderLayout());
	frame.add(tc, BorderLayout.CENTER);
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	textarea.setFont(new Font("Monospaced", Font.PLAIN, FONT_SIZE));
	frame.pack();
	frame.setVisible(true);


    }

    public static void main(String[] args) {
	Board brade = new Board(WIDTH, HEIGHT);

	TetrisViewer tv = new TetrisViewer(brade);
	tv.show();

    }
}