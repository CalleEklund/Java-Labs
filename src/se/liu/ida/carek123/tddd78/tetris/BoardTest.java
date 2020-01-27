package se.liu.ida.carek123.tddd78.tetris;

public class BoardTest
{
    public static void main(String[] args) {


	Board b = new Board(5, 5);
	//för att ändra startpos för polyn så ändra x o y i poly klassen
	Poly falling = TetrominoMaker.getPoly(4);
	b.setFalling(falling);
	System.out.println(BoardToTextConverter.convertToText(b));

    }
}
