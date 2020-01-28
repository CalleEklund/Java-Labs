package se.liu.ida.carek123.tddd78.tetris;

public class BoardTest
{
    public static void main(String[] args) {


	Board b = new Board(5, 10);
	//för att ändra startpos för polyn så ändra x o y i poly klassen
	//b.insertRandomST();

	Poly falling = TetrominoMaker.getPoly(1);
	b.setFalling(falling);
	//b.insertRandomST();
	System.out.println(BoardToTextConverter.convertToText(b));

    }
}
