package se.liu.ida.carek123.tddd78.tetris;

public class BoardToTextConverter
{
    public static String convertToText(Board b) {
	StringBuilder tb = new StringBuilder();
	for (int i = 0; i < b.getHeight(); i++) {
	    for (int j = 0; j < b.getWidth(); j++) {

		switch (b.getSquareAt(i, j)) {
		    case E:
			tb.append("-");
			break;
		    case I:
			tb.append("I");
			break;
		    case O:
			tb.append("O");
			break;
		    case T:
			tb.append("T");
			break;
		    case S:
			tb.append("S");
			break;
		    case Z:
			tb.append("Z");
			break;
		    case J:
			tb.append("J");
			break;
		    case L:
			tb.append("L");
			break;
		    case OUTSIDE:
		        tb.append("D");
		        break;
		    default:
			tb.append("#");
			break;

		}
	    }
	    tb.append("\n");
	}
	return tb.toString();
    }

}
