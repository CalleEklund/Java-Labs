package se.liu.ida.carek123.tddd78.tetris;

public class Poly
{
    private SquareType[][] poly;
    private int x, y;

    public Poly(final SquareType[][] poly) {
	this.poly = poly;
	this.x = 0;
	this.y = 0;
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public void setX(int x) {
	this.x = x;
    }

    public void setY(int y) {
	this.y = y;
    }

    public SquareType getPoly(int x, int y) {
	return poly[x][y];
    }

    public int getHeight() {
	return poly[0].length;
    }

    public int getWidth() {
	return poly.length;
    }

    public Poly rotate(boolean right) {

	Poly newPoly = new Poly(new SquareType[poly.length][poly.length]);

	for (int r = 0; r < poly.length; r++) {
	    for (int c = 0; c < poly.length; c++) {
		if (right) {
		    newPoly.poly[c][poly.length - 1 - r] = this.poly[r][c];
		} else {
		    newPoly.poly[poly.length - 1 - c][r] = this.poly[r][c];

		}
	    }
	}

	return newPoly;


    }


}
