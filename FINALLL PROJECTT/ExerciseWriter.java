package a9;

import java.io.*;
import java.util.List;

public class ExerciseWriter {
    public static boolean writeToFile(String filename, List<Exercise> exercises) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Exercise exercise : exercises) {
                writer.write(exercise.toString() + "\n");
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void tabulateSummary(List<Exercise> exercises) {
        System.out.println(String.format("%-20s%-25s%-15s%10s", "Type", "Name", "Date", "Calories Burned"));
        for (Exercise exercise : exercises) {
            System.out.println(exercise.toSummaryString());
        }
    }
}
