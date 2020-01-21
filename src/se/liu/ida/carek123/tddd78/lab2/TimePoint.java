package se.liu.ida.carek123.tddd78.lab2;

public class TimePoint
{
    private int hour,minute;

    public TimePoint(final int hour, final int minute) {
	this.hour = hour;
	this.minute = minute;
    }

    public int getHour() {
	return hour;
    }

    public int getMinute() {
	return minute;
    }

    public int compareTime(TimePoint other){
	if (hour < other.hour){
	    return 0;
	}else if (hour > other.hour){
	    return -1;
	}else{
	    if (minute < other.minute){
	        return 0;
	    }
	    else{
	        return -1;
	    }
	}
    }


    @Override public String toString() {
        return String.format("%02d:%02d",hour,minute);
    }
}
