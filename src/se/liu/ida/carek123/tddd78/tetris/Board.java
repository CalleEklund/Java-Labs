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
    private boolean gameOver;


    public Board(final int width, final int height) {
	this.width = width;
	this.height = height;
	this.squares = new SquareType[height][width];
	this.boardListeners = new ArrayList<>();
	this.gameOver = false;

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

    public boolean isGameOver() {
	return gameOver;
    }

    public void setGameOver(final boolean gameOver) {
	this.gameOver = gameOver;
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
	if (falling != null) {
	    for (int i = 0; i < falling.getHeight(); i++) {
		for (int j = 0; j < falling.getHeight(); j++) {
		    if (falling.getPoly(i, j) != SquareType.E &&
			getSquareType(falling.getY() + j, falling.getX() + i) != SquareType.E) {
			return true;
		    }
		}
	    }
	}
	return false;
    }

    public void addPolyToBoard() {
	for (int i = 0; i < falling.getHeight(); i++) {
	    for (int j = 0; j < falling.getWidth(); j++) {
		if (falling.getPoly(i, j) != SquareType.E) {
		    squares[falling.getX() + i][falling.getY() + j] = falling.getPoly(i, j);
		}
	    }
	}
    }


    public void tick() {
	if (falling != null) {
	    falling.setY(falling.getY() + 1);

	    if (hasCollision() == true) {
		falling.setY(falling.getY() - 1);
		addPolyToBoard();
		setFalling(null);
	    }

	} else {
	    int randInd = rnd.nextInt(TetrominoMaker.getNumberOfTypes() - 1);
	    Poly newPoly = TetrominoMaker.getPoly(5);
	    setFalling(newPoly);
	    if (hasCollision() == true) {
		setFalling(null);
		setGameOver(true);
	    }


	}
	notifyListeners();
    }

    Action moveLeft = new AbstractAction()
    {
	public void actionPerformed(ActionEvent e) {
	    if (falling != null) {
		falling.setX(falling.getX() - 1);
		if (hasCollision() == true) {
		    falling.setX(falling.getX() + 1);
		}
		notifyListeners();
	    }

	}

    };

    Action moveRight = new AbstractAction()
    {
	public void actionPerformed(ActionEvent e) {
	    if (falling != null) {
		falling.setX(falling.getX() + 1);
		if (hasCollision() == true) {
		    falling.setX(falling.getX() - 1);
		}

		notifyListeners();
	    }
	}

    };

    Action rotateRight = new AbstractAction()
    {
	public void actionPerformed(ActionEvent e) {
	    if (falling != null) {
		Poly currentPoly = getFalling();
		Poly rotatedPoly = falling.rotateRight();
		rotatedPoly.setY(falling.getY());
		rotatedPoly.setX(falling.getX());
		setFalling(rotatedPoly);
		if (hasCollision()) {
		    setFalling(currentPoly);
		}

	    }


	}

    };
    Action rotateLeft = new AbstractAction()
    {
	public void actionPerformed(ActionEvent e) {
	    if (falling != null) {
		Poly currentPoly = getFalling();
		Poly rotatedPoly = falling.rotateRight();
		rotatedPoly.setY(falling.getY());
		rotatedPoly.setX(falling.getX());
		setFalling(rotatedPoly);
		if (hasCollision()) {
		    setFalling(currentPoly);
		}

	    }


	}

    };

}