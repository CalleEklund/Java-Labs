package se.liu.ida.carek123.tddd78.lab1;

import javax.swing.*;

public class Exercise2
{
    public static int sumFor(int min, int max){
	int sum = 0;
	for (int i = min; i <= max; i++) {
	    sum += i;
	}
       return sum;
    }
    public static int sumWhile(int min, int max){
        int sum = 0;
	while(max >= min){
	    sum += max;
	    max--;
	}

        return sum;
    }
    public static void main(String[] args) {
	int min = 10;
	int max = 15;



	String choice = JOptionPane.showInputDialog("Choose while or for loop");
	switch(choice){
	    case "while":
		int res2 = sumWhile(min,max);
		System.out.println("res while loop: "+res2);
		break;
	    case "for":
		int res1 = sumFor(min,max);
		System.out.println("res for loop: "+res1);
		break;

	    default:
		System.out.println("You did not choose a valid choice");

	}
    }
}
