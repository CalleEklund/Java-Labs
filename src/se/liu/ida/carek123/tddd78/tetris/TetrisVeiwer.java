package se.liu.ida.carek123.tddd78.tetris;

import javax.swing.*;
import java.awt.*;

public class TetrisVeiwer
{
    private Board b;

    public TetrisVeiwer(final Board b) {
	this.b = b;
    }

    public void show() {
        JFrame frame = new JFrame("Tetris");
        JTextArea textarea = new JTextArea(b.getHeigth(), b.getWidth());
    	frame.setLayout(new BorderLayout());
    	frame.add(textarea, BorderLayout.CENTER);
	textarea.setFont(new Font("Monospaced", Font.PLAIN, 20));
    	frame.pack();
    	frame.setVisible(true);

    }

    public static void main(String[] args) {
        Board brade = new Board(10,10);
	System.out.println(brade.toString());
	TetrisVeiwer tv = new TetrisVeiwer(brade);
	tv.show();
    }
}