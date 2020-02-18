package se.liu.ida.carek123.tddd78.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width, height, frameHeight, frameWidth;
    private Random rnd;
    private Poly falling;
    private List<BoardListener> boardListeners;
    private boolean gameOver;


    public Board(final int height, final int width) {
	this.width = width;
	this.height = height;
	this.frameWidth = width + 4;
	this.frameHeight = height + 4;
	this.squares = new SquareType[frameHeight][frameWidth];
	this.boardListeners = new ArrayList<>();
	this.gameOver = false;
	rnd = new Random();

	for (int i = 0; i < frameHeight; i++) {
	    for (int j = 0; j < frameWidth; j++) {
		if (j < 2 || i > height + 1 || i < 2 || j > width + 1) {
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
		checkRow();
		setFalling(null);
	    }

	} else {
	    int randInd = rnd.nextInt(TetrominoMaker.getNumberOfTypes() - 1);
	    Poly newPoly = TetrominoMaker.getPoly(3);
	    setFalling(newPoly);

	    falling.setX(height / 2);
	    if (hasCollision() == true) {
		setFalling(null);
		setGameOver(true);
	    }


	}
	notifyListeners();
    }

    public void checkRow() {
	int numClearedLines = 0;
	boolean fullRow;

	for (int i = frameHeight - 2; i > 2; i--) {
	    fullRow = true;
	    for (int j = 2; j < frameWidth - 2; j++) {
		if (squares[j][i] == SquareType.E) {
		    fullRow = false;
		    break;
		}
	    }
	    if (fullRow) {
		System.out.println("full rad");
		deleteRow(i);
		i += 1;
		numClearedLines += 1;
	    }

	}
    }

    public void deleteRow(int index) {
	for (int j = index-1; j > 0; j--) {

	    for (int i = 2; i < frameWidth-2; i++) {
		squares[i][j+1] = squares[i][j];
	    }
	}
    }

    Action moveLeft = new AbstractAction()
    {
	public void actionPerformed(ActionEvent e) {

	    if (falling != null) {
		falling.setX(falling.getX() - 1);
		if (hasCollision() == true) {
		    falling.setX(falling.getX() + 1);
		}
	    }
	    notifyListeners();

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
		Poly rotatedPoly = falling.rotate(true);
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
		Poly rotatedPoly = falling.rotate(false);
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