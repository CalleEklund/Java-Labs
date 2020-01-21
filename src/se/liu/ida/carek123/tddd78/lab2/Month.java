package se.liu.ida.carek123.tddd78.lab2;

public class Month
{
    private String name;
    private int number, days;

    public Month(final String name, final int number, final int days) {
	this.name = name;
	this.number = number;
	this.days = days;
    }

    public String getName() {
	return name;
    }

    public int getNumber() {
	return number;
    }

    public int getDays() {
	return days;
    }

    public static int getMonthNumber(String name) {
	switch (name) {
	    case "january":
		return 1;
	    case "february":
		return 2;
	    case "mars":
		return 3;
	    case "april":
		return 4;
	    case "may":
		return 5;
	    case "june":
		return 6;
	    case "july":
		return 7;
	    case "august":
		return 8;
	    case "september":
		return 9;
	    case "october":
		return 10;
	    case "november":
		return 11;
	    case "december":
		return 12;
	    default:
		return -1;

	}
    }

    public static int getMonthDays(String name) {
	name = name.toLowerCase();
	switch (name) {
	    case "april":
	    case "june":
	    case "september":
	    case "november":
		return 30;
	    case "january":
	    case "mars":
	    case "may":
	    case "july":
	    case "august":
	    case "october":
	    case "december":
		return 31;
	    case "february":
		return 28;
	    default:
		return -1;

	}
    }

    @Override public String toString() {
	return Integer.toString(Month.getMonthNumber(name));
    }
}
