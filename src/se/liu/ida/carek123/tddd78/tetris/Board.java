package se.liu.ida.carek123.tddd78.tetris;

import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width, height;
    private Random rnd;
    //sätt som standard case 0
    private Poly falling = null;


    public Board(final int width, final int height) {
	this.width = width;
	this.height = height;
	this.squares = new SquareType[height][width];
	rnd = new Random();

	for (int i = 0; i < height; i++) {
	    for (int j = 0; j < width; j++) {
		squares[i][j] = SquareType.E;
	    }
	}
    }

    public SquareType getSquareType(int x, int y) {
	return squares[y][x];
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public Poly getFalling() {
	return falling;
    }

    public SquareType[][] insertRandomST() {
	for (int i = 0; i < this.height; i++) {
	    for (int j = 0; j < this.width; j++) {
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

	if(startX<=sizeX && sizeX<endX && startY<=sizeY && sizeY<endY){
	    if(falling.getPoly(sizeX,sizeY) == SquareType.E){
	        return squares[x][y];
	    }else{
	        return falling.getPoly(sizeX,sizeY);
	    }
	}else{
	    return squares[x][y];
	}
    }

    public void setFalling(Poly falling) {
	this.falling = falling;
    }
}

