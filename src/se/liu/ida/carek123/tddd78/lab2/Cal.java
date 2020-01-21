package se.liu.ida.carek123.tddd78.lab2;

import java.util.ArrayList;
import java.util.List;

public class Cal
{
    private List<Appointment> appointments;

    public Cal() {
	this.appointments = new ArrayList<>();
    }

    public void show() {
	for (Appointment appointment : appointments) {
	    System.out.println(appointment.toString());
	}
    }

    public void book(int year, String month, int day, int startHour, int startMinute, int endHour, int endMinute,
		     String subject)
    {
	if (year > 1970 && 0 <= startHour && startHour <= 23 && 0 <= endHour && endHour <= 23 &&
	    day == Month.getMonthDays(month) && Month.getMonthDays(month) != -1) {
	    Month m = new Month(month, Month.getMonthDays(month), day);
	    Date d = new Date(year, day, m);

	    TimePoint startTime = new TimePoint(startHour, startMinute);
	    TimePoint endTime = new TimePoint(endHour, endMinute);

	    TimeSpan ts = new TimeSpan(startTime, endTime);

	    Appointment app = new Appointment(subject, d, ts);
	    appointments.add(app);

	}
    }

    public static void main(String[] args) {
        Cal c = new Cal();
        c.book(2000,"october",15,15,30,16,30,"Birth");
        c.book(2004,"april",30,8,30,10,30,"hello");
    	c.book(2020,"december",31,22,0,23,0,"new year");

    	c.show();
    }
}
