package se.liu.ida.carek123.tddd78.tetris;

import java.util.Random;

public enum SquareType
{
    E,I,O,T,S,Z,J,L;

    public static void main(String[] args) {
        Random rnd = new Random();
        for (int i = 0; i <=25 ; i++) {
            System.out.println("Random sqauretype: "+SquareType.values()[rnd.nextInt(SquareType.values().length)]);
        }
    }


}
