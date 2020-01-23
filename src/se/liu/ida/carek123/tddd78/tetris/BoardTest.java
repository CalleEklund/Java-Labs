package se.liu.ida.carek123.tddd78.tetris;

public class BoardTest
{
    public static void main(String[] args) {
	Board b = new Board(6,5);
	//b.insertRandomST();
	BoardToTextConverter bttc = new BoardToTextConverter();
	Poly falling = TetrominoMaker.getPoly(5);
	b.setFalling(falling);
	System.out.println(bttc.convertToText(b));

    }
}
