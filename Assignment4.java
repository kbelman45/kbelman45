package m;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;
/**
 * Glaycon Cezarotto 
 * Object Programming 
 * Purpose: This program is designed to read integer values 
 * from a text file and organize them into a two-dimensional jagged array.
 * My file path for the data and/or run configuration argument is C:\Users\maski\eclipse-workspace\JavaProjects\src\m\assignment4Data.txt
 */
public class Assignment4 {

    /**
     * Returns the number of lines in the specified text file.
     *
     * @param filename The path to the file.
     * @return The number of lines in the file.
     * @throws IOException If an I/O error occurs opening the file.
     */
    public static int getNoLines(String filename) throws IOException {
        try (Stream<String> fileStream = Files.lines(Paths.get(filename))) {
            return (int) fileStream.count();
        }
    }

    /**
     * Creates a two-dimensional array from a file, with each row in the file becoming a row in the array.
     *
     * @param filename The path to the file.
     * @return A jagged array containing the file's contents.
     * @throws IOException If an I/O error occurs reading the file.
     */
    public static int[][] create2DArray(String filename) throws IOException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            int[][] data = new int[getNoLines(filename)][];
            int row = 0;
            while (scanner.hasNextLine()) {
                String[] numbers = scanner.nextLine().trim().split("\\s+");
                data[row] = new int[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    data[row][i] = Integer.parseInt(numbers[i]);
                }
                row++;
            }
            return data;
        }
    }

    /**
     * Finds the index of the longest row in a two-dimensional array.
     *
     * @param array The array to search.
     * @return The index of the longest row.
     */
    public static int findLongestRow(int[][] array) {
        int maxLength = 0;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length > maxLength) {
                maxLength = array[i].length;
                index = i;
            }
        }
        return index;
    }

    /**
     * Finds the maximum value in a specific row of a two-dimensional array.
     *
     * @param array The array to search.
     * @param row The index of the row.
     * @return The maximum value in the row.
     */
    public static int findMaxInRow(int[][] array, int row) {
        int max = array[row][0];
        for (int val : array[row]) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    /**
     * Finds the maximum value in a two-dimensional array.
     *
     * @param array The array to search.
     * @return The maximum value in the array.
     */
    public static int findMax(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int val : row) {
                if (val > max) {
                    max = val;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please enter the path to your data file:");
        //this will allow the user to enter their pathing for the data file
        // As an a example mine is C:\Users\maski\eclipse-workspace\JavaProjects\src\m\assignment4Data.txt 
        String filename = inputScanner.nextLine();
        try {
            System.out.println("Number of lines in the file = " + getNoLines(filename));
            int[][] arr = create2DArray(filename);
            int longestRow = findLongestRow(arr);
            System.out.println("Longest row in the file is: " + (longestRow + 1) + " ,with length of: " + arr[longestRow].length);
            System.out.println("Max value in first row = " + findMaxInRow(arr, 0));
            System.out.println("Max value in file = " + findMax(arr));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
