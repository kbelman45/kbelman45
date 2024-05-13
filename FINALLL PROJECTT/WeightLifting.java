package a9;

import java.text.ParseException;

public class WeightLifting extends Exercise {
    private double amountLifted;  // in pounds

    public WeightLifting(String name, String dateStr, int duration, double amountLifted) throws ParseException {
        super(name, dateStr, duration);
        this.amountLifted = amountLifted;
    }


    @Override
    public String getType() {
        return "Weightlifting";
    }

    @Override
    public double getCaloriesBurned() {
        return (amountLifted / duration) * 50;
    }

    @Override
    public String toStringCustomInfo() {
        return String.format("Name: %s, Date: %s, Duration: %d minutes, Weight Lifted: %.2f lbs, Calories Burned: %.2f calories",
                             getName(), getDateAsString(), (int) getDuration(), amountLifted, getCaloriesBurned());
    }


}
