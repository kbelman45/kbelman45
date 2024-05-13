package a9;

import java.text.ParseException;

public class RockClimbing extends Exercise {
    private double height;  // in feet
    private int repetitions;

    public RockClimbing(String name, String dateStr, int duration, double height, int repetitions) throws ParseException {
        super(name, dateStr, duration);
        this.height = height;
        this.repetitions = repetitions;
    }


    @Override
    public String getType() {
        return "Rock Climbing";
    }

    @Override
    public double getCaloriesBurned() {
        return (height * repetitions / duration) * 100;
    }

    @Override
    public String toStringCustomInfo() {
        return String.format("Name: %s, Date: %s, Duration: %d minutes, Wall Height: %.2f ft, Repetitions: %d, Calories Burned: %.2f calories",
                             getName(), getDateAsString(), (int) getDuration(), height, repetitions, getCaloriesBurned());
    }


}
