package se.liu.ida.carek123.tddd78.tetris;

public class BoardToTextConverter
{
    public static String convertToText(Board b) {
	StringBuilder textBoard = new StringBuilder();
	for (int i = 0; i < b.getWidth(); i++) {
	    for (int j = 0; j < b.getHeight(); j++) {
		if (b.getSquareAt(i, j) == b.getFalling().getPoly(i, j)) {
		    textBoard.append(b.getFalling().getPoly(i, j));
		} else {
		    textBoard.append(b.getSquareType(i, j));
		}
	    }
	    textBoard.append("\n");
	}
	return textBoard.toString();
    }

}
