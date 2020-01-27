package se.liu.ida.carek123.tddd78.lab1;

import javax.swing.*;

public class Exercise3
{
    private final static int TABELL = 5;

    public static void main(String[] args) {
	String input = JOptionPane.showInputDialog("Please input a value");
	int tabell;
	try {
	    tabell = Integer.parseInt(input);

	    for (int i = 0; i <= 12; i++) {
		System.out.println(i + " * " + tabell + " = " + (i * tabell));
	    }
	} catch (NumberFormatException e) {
	    System.out.println("Please input a number, error:" + e);
	}


    }
}
