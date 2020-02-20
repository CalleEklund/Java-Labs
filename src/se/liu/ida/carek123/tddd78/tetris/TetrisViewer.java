package se.liu.ida.carek123.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    private Board b;
    private final static int WIDTH = 10;
    private final static int HEIGHT = 18;
    public final static Font font = new Font("Monospaced", Font.PLAIN, 12);
    private StartScreen sscreen;

    private static int points;

    private Timer clockTimer;

    private JFrame frame;
    private JTextArea textarea;
    private TetrisComponent tc;

    static JLabel scorelbl;

    public TetrisViewer(final Board b) {
	this.b = b;
	clockTimer = new Timer(600, null);
	points = 0;

    }

    public static void setPoints(int points) {
	TetrisViewer.points = points;
    }

    public void show() throws InterruptedException {
	frame = new JFrame("Tetris");
	textarea = new JTextArea(b.getHeight(), b.getWidth());
	tc = new TetrisComponent(b);

	final JMenuBar bar = new JMenuBar();
	final JMenuItem jmi = new JMenuItem("Avsluta", 'A');

	bar.add(jmi);


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

	final Action menuexit = new AbstractAction()
	{
	    @Override public void actionPerformed(ActionEvent e) {
		int ans = JOptionPane.showConfirmDialog(frame, "Are you sure?", "", JOptionPane.YES_NO_OPTION);
		if (ans == 0) {
		    System.exit(0);
		}
	    }
	};

	clockTimer.addActionListener(doOneStep);

	jmi.addActionListener(menuexit);
	frame.setJMenuBar(bar);

	initLoad();

    }

    public String getPlayerName() {
	String input = JOptionPane.showInputDialog("Player name: ");
	return input;
    }

    public void initLoad() throws InterruptedException {
	frame.setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();

	sscreen = new StartScreen();
	textarea.setFont(font);

	frame.add(sscreen);
	System.out.println("image loaded");
	frame.setSize(470, 470);
	frame.setVisible(true);

	Thread.sleep(5000);
	frame.dispose();
	sscreen.setVisible(false);


	gbc.fill = GridBagConstraints.HORIZONTAL;

	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.gridheight = 2;
	frame.add(tc, gbc);


	gbc.gridx++;
	gbc.gridheight = 1;
	gbc.insets = new Insets(20, 5, 0, 50);
	gbc.fill = GridBagConstraints.BOTH;

	scorelbl = new JLabel("Score: \n" + points);
	scorelbl.setFont(font);
	frame.add(scorelbl, gbc);

	System.out.println("Tetris loaded");

	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	frame.pack();
	frame.setVisible(true);

	clockTimer.setCoalesce(true);
	clockTimer.start();

    }

    public static void main(String[] args) throws InterruptedException {
	Board brade = new Board(HEIGHT, WIDTH);

	TetrisViewer tv = new TetrisViewer(brade);
	tv.show();

    }
}