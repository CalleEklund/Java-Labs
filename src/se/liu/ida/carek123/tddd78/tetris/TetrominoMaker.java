package se.liu.ida.carek123.tddd78.tetris;

public class TetrominoMaker
{
    public int getNumberOfTypes() {
	return SquareType.values().length;
    }

    public Poly getPoly(int n) {
	Poly p;
	SquareType[][] sq;
	if (n <= 0 || n >= 8) {
	    throw new IllegalArgumentException("invalid index:" + n);
	} else {
	    switch (n) {
		case 1:
		    sq = new SquareType[4][4];

		    sq[0][0] = SquareType.E;
		    sq[0][1] = SquareType.E;
		    sq[0][2] = SquareType.E;
		    sq[0][3] = SquareType.E;

		    sq[1][0] = SquareType.I;
		    sq[1][1] = SquareType.I;
		    sq[1][2] = SquareType.I;
		    sq[1][3] = SquareType.I;

		    sq[2][0] = SquareType.E;
		    sq[2][1] = SquareType.E;
		    sq[2][2] = SquareType.E;
		    sq[2][3] = SquareType.E;

		    sq[3][0] = SquareType.E;
		    sq[3][1] = SquareType.E;
		    sq[3][2] = SquareType.E;
		    sq[3][3] = SquareType.E;
		    p = new Poly(sq);
		    return p;

		case 2:
		    sq = new SquareType[3][3];
		    sq[0][0] = SquareType.J;
		    sq[0][1] = SquareType.E;
		    sq[0][2] = SquareType.E;

		    sq[1][0] = SquareType.J;
		    sq[1][1] = SquareType.J;
		    sq[1][2] = SquareType.J;

		    sq[2][0] = SquareType.E;
		    sq[2][1] = SquareType.E;
		    sq[2][2] = SquareType.E;

		    p = new Poly(sq);
		    return p;


		case 3:
		    sq = new SquareType[3][3];
		    sq[0][0] = SquareType.E;
		    sq[0][1] = SquareType.E;
		    sq[0][2] = SquareType.J;

		    sq[1][0] = SquareType.J;
		    sq[1][1] = SquareType.J;
		    sq[1][2] = SquareType.J;

		    sq[2][0] = SquareType.E;
		    sq[2][1] = SquareType.E;
		    sq[2][2] = SquareType.E;
		    p = new Poly(sq);
		    return p;
		case 4:
		    sq = new SquareType[2][2];
		    sq[0][0] = SquareType.O;
		    sq[0][1] = SquareType.O;
		    sq[1][0] = SquareType.O;
		    sq[1][1] = SquareType.O;
		    p = new Poly(sq);
		    return p;
		case 5:
		    sq = new SquareType[3][3];
		    sq[0][0] = SquareType.E;
		    sq[0][1] = SquareType.S;
		    sq[0][2] = SquareType.S;

		    sq[1][0] = SquareType.S;
		    sq[1][1] = SquareType.S;
		    sq[1][2] = SquareType.E;

		    sq[2][0] = SquareType.E;
		    sq[2][1] = SquareType.E;
		    sq[2][2] = SquareType.E;
		    p = new Poly(sq);
		    return p;
		case 6:
		    sq = new SquareType[3][3];
		    sq[0][0] = SquareType.E;
		    sq[0][1] = SquareType.T;
		    sq[0][2] = SquareType.E;

		    sq[1][0] = SquareType.T;
		    sq[1][1] = SquareType.T;
		    sq[1][2] = SquareType.T;

		    sq[2][0] = SquareType.E;
		    sq[2][1] = SquareType.E;
		    sq[2][2] = SquareType.E;
		    p = new Poly(sq);
		    return p;
		case 7:
		    sq = new SquareType[3][3];
		    sq[0][0] = SquareType.Z;
		    sq[0][1] = SquareType.Z;
		    sq[0][2] = SquareType.E;

		    sq[1][0] = SquareType.E;
		    sq[1][1] = SquareType.Z;
		    sq[1][2] = SquareType.Z;

		    sq[2][0] = SquareType.E;
		    sq[2][1] = SquareType.E;
		    sq[2][2] = SquareType.E;
		    p = new Poly(sq);
		    return p;
	    }
	    return null;
	}
    }
}
