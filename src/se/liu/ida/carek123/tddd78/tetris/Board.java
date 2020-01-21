package se.liu.ida.carek123.tddd78.tetris;

import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width, heigth;
    private Random rnd;

    public Board(final int width, final int heigth) {
	this.width = width;
	this.heigth = heigth;
	this.squares = new SquareType[heigth][width];
	rnd = new Random();
    }

    public SquareType getSquareType(int x, int y) {
	return squares[y][x];
    }

    public int getWidth() {
	return width;
    }

    public int getHeigth() {
	return heigth;
    }

    public SquareType[][] insertRandomST() {
	SquareType[][] randomBoard = null;
	for (int i = 0; i < this.width; i++) {
	    for (int j = 0; j < this.heigth; j++) {
		squares[i][j] = SquareType.values()[rnd.nextInt(SquareType.values().length)];
	    }
	}
	return squares;
    }

    public static void main(String[] args) {
	Board b = new Board(5, 5);
	System.out.println(b.squares[6][0]);
    }
}
