package se.liu.ida.carek123.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    private Board b;
    private final static int FONT_SIZE = 16;
    private Timer clockTimer;

    public TetrisViewer(final Board b) {
	this.b = b;
	clockTimer = new Timer(700, null);

	clockTimer.setCoalesce(true);
	clockTimer.start();

    }

    public void show() {
	JFrame frame = new JFrame("Tetris");
	JTextArea textarea = new JTextArea(b.getHeight(), b.getWidth());
	TetrisComponent tc = new TetrisComponent(b);


	final InputMap in = tc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	in.put(KeyStroke.getKeyStroke("LEFT"), "moveleft");
	in.put(KeyStroke.getKeyStroke("RIGHT"), "moveright");

	in.put(KeyStroke.getKeyStroke("UP"), "rotateRight");
	in.put(KeyStroke.getKeyStroke("DOWN"), "rotateLeft");



	final ActionMap act = tc.getActionMap();
	act.put("moveleft", b.moveLeft);
	act.put("moveright", b.moveRight);

	act.put("rotateRight", b.rotateRight);
	act.put("rotateLeft", b.rotateLeft);




	final Action doOneStep = new AbstractAction()
	{
	    @Override public void actionPerformed(ActionEvent e) {
		//System.out.println(b.isGameOver());
		if (!b.isGameOver()) {
		    b.addBoardListeners(tc);
		    b.tick();
		}else{
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
	Board brade = new Board(18, 10);

	TetrisViewer tv = new TetrisViewer(brade);
	tv.show();

    }
}