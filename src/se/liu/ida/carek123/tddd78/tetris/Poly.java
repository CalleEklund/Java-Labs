package se.liu.ida.carek123.tddd78.tetris;

public class Poly {
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

    public SquareType getPoly(int x, int y) {
        return poly[x][y];
    }

    public int getHeight() {
        return poly[0].length;
    }

    public int getWidth() {
        return poly.length;
    }

}
