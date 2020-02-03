package se.liu.ida.carek123.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    private Board b;

    public TetrisViewer(final Board b) {
        this.b = b;
    }

    public void show() {
        JFrame frame = new JFrame("Tetris");
        JTextArea textarea = new JTextArea(b.getHeight(),b.getWidth());
        TetrisComponent tc = new TetrisComponent(b);

        final Action doOneStep = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.insertRandomST();
                //textarea.setText(BoardToTextConverter.convertToText(b));
                tc.paintComponent(frame.getGraphics());
            }
        };


        final Timer clockTimer = new Timer(1000,doOneStep);
        clockTimer.setCoalesce(true);
        clockTimer.start();

        frame.setLayout(new BorderLayout());
        frame.add(tc,BorderLayout.CENTER);
        textarea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) throws InterruptedException {
        Board brade = new Board(8,15);
        Poly falling = TetrominoMaker.getPoly(5);

        brade.setFalling(falling);
        TetrisViewer tv = new TetrisViewer(brade);
        tv.show();

    }
}