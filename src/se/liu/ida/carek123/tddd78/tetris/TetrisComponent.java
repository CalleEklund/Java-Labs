package se.liu.ida.carek123.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class TetrisComponent extends JComponent implements BoardListener {
    private final static int SQUARE_SIZE = 30;
    private Board b;
    private EnumMap<SquareType, Color> STColor;
    public TetrisComponent(Board b) {
        this.b = b;
        this.STColor = new EnumMap<>(SquareType.class);

        STColor.put(SquareType.I,Color.CYAN);
        STColor.put(SquareType.J,Color.BLUE);
        STColor.put(SquareType.L,Color.ORANGE);
        STColor.put(SquareType.O,Color.YELLOW);
        STColor.put(SquareType.S,Color.GREEN);
        STColor.put(SquareType.T,Color.MAGENTA);
        STColor.put(SquareType.Z,Color.RED);
        STColor.put(SquareType.E,Color.DARK_GRAY);
        STColor.put(SquareType.OUTSIDE,Color.PINK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < b.getHeight(); i++) {
            for (int j = 0; j < b.getWidth(); j++) {
                g2d.setColor(STColor.get(b.getSquareAt(i,j)));
                g2d.fillRect(i*SQUARE_SIZE,j*SQUARE_SIZE,SQUARE_SIZE,SQUARE_SIZE);
                g2d.setColor(Color.WHITE);
                g2d.drawRect(i*SQUARE_SIZE,j*SQUARE_SIZE,SQUARE_SIZE,SQUARE_SIZE);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new Dimension(this.b.getHeight()*SQUARE_SIZE, this.b.getWidth()*SQUARE_SIZE);
    }

    public static void main(String[] args) {
        //Dimension test = getPreferredSize();
        //System.out.println(test.height+" "+test.width);
    }

    @Override
    public void BoardChanged() {
        repaint();
    }

}