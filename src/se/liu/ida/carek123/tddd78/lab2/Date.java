package se.liu.ida.carek123.tddd78.lab2;

public class Date
{
    private int year, day;
    private Month month;

    public Date(final int year, final int day, final Month month) {
	this.year = year;
	this.day = day;
	this.month = month;
    }

    public int getYear() {
	return year;
    }

    public int getDay() {
	return day;
    }

    public Month getMonth() {
	return month;
    }

    @Override public String toString() {
	return "("+ year + "-" + day + "-" + month.toString()+")";
    }
}
