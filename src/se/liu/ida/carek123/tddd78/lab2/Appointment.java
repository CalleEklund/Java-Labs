package se.liu.ida.carek123.tddd78.lab2;

public class Appointment
{
    private String subject;
    private Date date;
    private TimeSpan timespan;

    public Appointment(final String subject, final Date date, final TimeSpan timespan) {
	this.subject = subject;
	this.date = date;
	this.timespan = timespan;
    }

    public String getSubject() {
	return subject;
    }

    public Date getDate() {
	return date;
    }

    public TimeSpan getTimespan() {
	return timespan;
    }

    @Override public String toString() {
	return "Appointment (subject-date-timespan): " + subject + "-" + date + "-" + timespan;
    }
}
