package a9;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public abstract class Exercise implements Comparable<Exercise> {
    private String name;
    private Date date;
    protected double duration;
    private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    public Exercise(String name, String dateStr, double duration) throws ParseException {
        setName(name);
        setDate(dateStr); 
        setDuration(duration);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String dateStr) throws ParseException {
        try {
            this.date = df.parse(dateStr);
        } catch (ParseException ex) {
            throw new ParseException("Invalid date format", ex.getErrorOffset());
        }
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = Math.max(duration, 0); // make sure that the duration is not negative(works)
    }

    protected String getDateAsString() {
        return df.format(date);
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%.2f\t%s", name, getType(), getDateAsString(), duration, getCaloriesBurned());
    }

    public abstract String getType();
    public abstract double getCaloriesBurned();
    public abstract String toStringCustomInfo(); // make sure this method works

    @Override
    public int compareTo(Exercise other) {
        return this.date.compareTo(other.date);
    }

    public String toSummaryString() {
        return String.format("%-20s%-25s%-15s%10.2f", getType(), name, getDateAsString(), getCaloriesBurned());
    }
}

