package se.liu.ida.carek123.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    private Board b;
    private final static int FONT_SIZE = 16;

    public TetrisViewer(final Board b) {
	this.b = b;
    }

    public void show() {
	JFrame frame = new JFrame("Tetris");
	JTextArea textarea = new JTextArea(b.getHeight(), b.getWidth());
	TetrisComponent tc = new TetrisComponent(b);



	final InputMap in = tc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	in.put(KeyStroke.getKeyStroke("LEFT"), "moveleft");
	in.put(KeyStroke.getKeyStroke("RIGHT"), "moveright");

	final ActionMap act = tc.getActionMap();
	act.put("moveleft", b.moveLeft);
	act.put("moveright", b.moveRight);

	final Action doOneStep = new AbstractAction()
	{
	    @Override public void actionPerformed(ActionEvent e) {
		b.addBoardListeners(tc);
		b.tick();
	    }
	};


	final Timer clockTimer = new Timer(70, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
	frame.setLayout(new BorderLayout());
	frame.add(tc, BorderLayout.CENTER);
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	textarea.setFont(new Font("Monospaced", Font.PLAIN, FONT_SIZE));
	frame.pack();
	frame.setVisible(true);


    }

    public static void main(String[] args) {
	Board brade = new Board(17, 10);

	TetrisViewer tv = new TetrisViewer(brade);
	tv.show();

    }
}