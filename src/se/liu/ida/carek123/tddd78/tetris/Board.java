package se.liu.ida.carek123.tddd78.tetris;

import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width, heigth;
    private Random rnd;
    private Poly falling;

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

    public SquareType getSquareAt(int x, int y) {
	int startX = 0;
	int startY = 0;

	int sizeX = x-falling.getX();
	int sizeY = y-falling.getY();

	int endX = falling.getWidth();
	int endY = falling.getHeight();

	if(0<=sizeX && sizeX<endX && 0<=sizeY && sizeY<endY){

	}
	    //kolla om tilen är empty om den är det så returnera boardtilen
	    //annars returnera squaretypen


    }

    public static void main(String[] args) {
	Board b = new Board(5, 5);
	System.out.println(b.squares[6][0]);
    }
}
