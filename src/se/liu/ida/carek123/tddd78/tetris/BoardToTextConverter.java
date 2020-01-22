package se.liu.ida.carek123.tddd78.tetris;

public class BoardToTextConverter
{
    public String convertToText(Board b) {
	StringBuilder textBoard = new StringBuilder();
	for (int i = 0; i < b.getWidth(); i++) {
	    for (int j = 0; j < b.getHeigth(); j++) {
		textBoard.append(b.getSquareType(i, j));

	    }
	    textBoard.append("\n");
	}
	return textBoard.toString();
    }

}
