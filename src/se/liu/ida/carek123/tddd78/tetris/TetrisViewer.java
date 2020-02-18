package se.liu.ida.carek123.tddd78.tetris;

import net.miginfocom.swt.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TetrisViewer
{
    private Board b;
    private final static int WIDTH = 18;
    private final static int HEIGHT = 10;
    private final static Font font = new Font("Monospaced", Font.PLAIN, 20);
    private StartScreen sscreen;

    private Timer clockTimer;

    private JFrame frame;
    private JTextArea textarea;
    private TetrisComponent tc;
    private JLabel score;
    public TetrisViewer(final Board b) {
	this.b = b;
	clockTimer = new Timer(100, null);


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

    public void initLoad() throws InterruptedException {

	sscreen = new StartScreen();
	score = new JLabel("Score: \n"+500);
	score.setFont(font);
	score.setOpaque(true);
	score.setBackground(Color.RED);

	textarea.setFont(font);


//	frame.add(sscreen);
//	System.out.println("image loaded");
//	frame.setSize(500, 380);
//	frame.setVisible(true);
//
//	Thread.sleep(5000);
//	frame.dispose();
//	sscreen.setVisible(false);



	frame.setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();

	gbc.fill = GridBagConstraints.HORIZONTAL;

	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.gridheight = 2;
	frame.add(tc, gbc);


	gbc.gridx++;
	gbc.gridheight = 1;
	gbc.insets = new Insets(20,50,0,50);
	gbc.fill = GridBagConstraints.BOTH;
	frame.add(score,gbc);



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