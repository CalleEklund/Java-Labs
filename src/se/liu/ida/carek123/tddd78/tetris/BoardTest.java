package se.liu.ida.carek123.tddd78.tetris;

public class BoardTest
{
    public static void main(String[] args) {
	Board b = new Board(5,5);
	b.insertRandomST();
	BoardToTextConverter bttc = new BoardToTextConverter();
	System.out.println(bttc.convertToText(b));
    }
}
