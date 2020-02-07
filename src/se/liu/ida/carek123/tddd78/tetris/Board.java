package se.liu.ida.carek123.tddd78.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width, height;
    private Random rnd;
    //sätt som standard case 0
    private Poly falling;
    private List<BoardListener> boardListeners;


    public Board(final int width, final int height) {
	this.width = width;
	this.height = height;
	this.squares = new SquareType[height][width];
	this.boardListeners = new ArrayList<>();

	rnd = new Random();

	for (int i = 0; i < height; i++) {
	    for (int j = 0; j < width; j++) {
		if ((i <= height && j < 2) || (i < 2 && j <= width) || (i >= (height - 2) && j < width) ||
		    (i < height && j >= (width - 2))) {
		    squares[i][j] = SquareType.OUTSIDE;
		} else {
		    squares[i][j] = SquareType.E;
		}
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

    public void setFalling(Poly falling) {
	this.falling = falling;
	notifyListeners();
    }

    public void addBoardListeners(BoardListener bl) {
	boardListeners.add(bl);
    }

    private void notifyListeners() {
	for (BoardListener bl : boardListeners) {
	    bl.BoardChanged();
	}
    }

    public SquareType[][] insertRandomST() {
	for (int i = 0; i < this.height; i++) {
	    for (int j = 0; j < this.width; j++) {
		squares[i][j] = SquareType.values()[rnd.nextInt(SquareType.values().length)];
	    }
	}
	notifyListeners();
	return squares;
    }

    public SquareType getSquareAt(int x, int y) {
	int startX = 0;
	int startY = 0;

	int sizeX;
	int sizeY;
	int endX;
	int endY;

	if (falling == null) {
	    sizeX = x;
	    sizeY = y;
	    endX = 0;
	    endY = 0;
	} else {
	    sizeX = x - falling.getX();
	    sizeY = y - falling.getY();

	    endX = falling.getWidth();
	    endY = falling.getHeight();
	}
	if (startX <= sizeX && sizeX < endX && startY <= sizeY && sizeY < endY) {
	    if (falling.getPoly(sizeX, sizeY) == SquareType.E) {
		return squares[x][y];
	    } else {
		return falling.getPoly(sizeX, sizeY);
	    }
	} else {
	    return squares[x][y];
	}
    }

    public boolean hasCollision() {
	for (int i = 0; i < falling.getHeight(); i++) {
	    for (int j = 0; j < falling.getHeight(); j++) {
		if (falling.getPoly(i,j) != SquareType.E && getSquareType(falling.getY()+i, falling.getX()+j) == SquareType.OUTSIDE) {
		    return true;
		}
	    }
	}
	return false;
    }

    public void tick() {
	if (falling != null) {
	    falling.setY(falling.getY() + 1);
	    notifyListeners();
	} else {
	    int randInd = rnd.nextInt(TetrominoMaker.getNumberOfTypes() - 1);
	    Poly newPoly = TetrominoMaker.getPoly(0);
	    setFalling(newPoly);
	}

    }

    Action moveLeft = new AbstractAction()
    {
	public void actionPerformed(ActionEvent e) {
	    //System.out.println("LEFT");
	    falling.setX(falling.getX() - 1);
	    notifyListeners();
	}

    };

    final Action moveRight = new AbstractAction()
    {
	public void actionPerformed(ActionEvent e) {
	    //System.out.println("RIGHT");
	    falling.setX(falling.getX() + 1);
	    notifyListeners();
	}
    };

}