package se.liu.ida.carek123.tddd78.tetris;

import javax.swing.*;
import java.awt.*;

public class TetrisViewer
{
    private Board b;

    public TetrisViewer(final Board b) {
	this.b = b;
    }

    public void show() {
        JFrame frame = new JFrame("Tetris");
        JTextArea textarea = new JTextArea(b.getHeight(),b.getWidth());
        textarea.setText(BoardToTextConverter.convertToText(b));
        frame.setLayout(new BorderLayout());
        frame.add(textarea,BorderLayout.CENTER);
        textarea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Board brade = new Board(8,15);
        Poly falling = TetrominoMaker.getPoly(5);

        brade.setFalling(falling);
        TetrisViewer tv = new TetrisViewer(brade);
        tv.show();
    }
}