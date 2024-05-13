package a9;

import java.text.ParseException;

public class RunWalk extends Exercise {
    private double distance;  // in miles

    public RunWalk(String name, String dateStr, int duration, double distance) throws ParseException {
        super(name, dateStr, duration);
        this.distance = distance;
    }


    @Override
    public String getType() {
        return "Run/Walk";
    }

    @Override
    public double getCaloriesBurned() {
        return (distance / duration) * 9000;
    }

    @Override
    public String toStringCustomInfo() {
        return String.format("Name: %s, Date: %s, Duration: %d minutes, Distance: %.2f miles, Calories Burned: %.2f calories",
                             getName(), getDateAsString(), (int) getDuration(), distance, getCaloriesBurned());
    }


}
