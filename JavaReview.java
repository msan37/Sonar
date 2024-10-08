import java.io.*;
import java.util.*;

public class JavaReview {
    public static void main(String[] args) {
        try {
            FileWriter outputList = new FileWriter("phase1_output.txt"); // FileWriter write results/ output to a file
            File source = new File("phase1_fall2024.txt"); // input file
            Scanner input = new Scanner(source); // Scanner read the csv (.txt) file
            boolean isFirstLine = true; // first line being written
            while (input.hasNextLine()) { // Read each line
                String space = input.nextLine().trim(); // Remove whitespace
                if (!space.isEmpty()) { // Only process non-empty lines
                    if (!isFirstLine) {
                        outputList.write("\n"); // Write a new line before appending the next processed line
                    }
                    outputList.write(readln(space)); // Process and write line
                    isFirstLine = false; // Set flag to false after the first line is written
                }
            }
            outputList.close(); // Close output and input files
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + e.getMessage()); // file not found
        } catch (IOException e) {
            System.out.println("Input or output error: " + e.getMessage()); // I/O error
        }
    }

    public static String readln(String line) {
        ArrayList<String> data = new ArrayList<>(); // Initialize an output list
        String[] values = line.split(","); // Split line on commas (i.e., line.split(",")) to get an array of values

        for (String value : values) { // For each line in the file
            value = value.trim(); // Remove whitespace
            if (Integer(value)) {
                data.add("Integer"); // If it is an integer, add "Integer" to the output list
            } else if (Float(value)) {
                data.add("Float"); // If it is a float, add "Float" to the output list
            } else {
                data.add("String"); // Else, assume it’s a string. Add "String" to the output list
            }
        }
        return String.join(", ", data); // Generate an output string using String.join() and your output list
    }

    private static boolean Integer(String value) { //Check for Integer
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean Float(String value) { //Check for float
        try {
            Float.parseFloat(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
} // Original was 80 lines...