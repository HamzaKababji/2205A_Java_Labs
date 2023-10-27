package Q_LE2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GenericsAndArrays_Hamza {
    public static void main(String[] args) {
        myHeader(2); // Call a custom method to display the header for the lab exercise.

        System.out.println("This program prints the names of the student leaders from year 2, 3, and 4.\n" +
                "To see the list of the students from a specific year, enter an integer between 2 and 4 when prompted.");

        // Create ArrayLists to store academic years and student names.
        ArrayList<Integer> yearList = new ArrayList<>(Arrays.asList(2, 3, 4, 3, 2, 2));
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList("Harry", "Lavender", "Ron", "Hermione", "Luna", "Vincent"));

        // Create an array of Pair objects to associate academic years with student names.
        Pair<Integer, String>[] pairList = new Pair[yearList.size()];

        char c = 'y'; // Initialize a character for user input.

        Scanner input = new Scanner(System.in);

        int x;

        // Populate the array of Pair objects with academic years and student names.
        for (int i = 0; i < yearList.size(); i++) {
            pairList[i] = new Pair<>(yearList.get(i), nameList.get(i));
        }

        do {
            try {
                System.out.print("Enter Academic Year (2, 3, or 4): "); // Prompt the user to enter a year.

                x = input.nextInt(); // Read the user's input as an integer.

                if (x > 4 || x < 2) {
                    throw new InputMismatchException(); // Throw an exception for invalid input.
                }

                // Create an ArrayList to store student names from the specified year.
                ArrayList<String> userAnswer = new ArrayList<>(0);
                for (Pair<Integer,String> element : pairList) {
                    // Iterate through the Pair objects and add matching names to the ArrayList.
                    if ((int) element.getKey() == x) {
                        userAnswer.add((String) element.getValue());
                    }
                }

                // Display the list of student names from the specified year.
                System.out.printf("Found %d leader(s) from year %d.\nHere is the list:\n%s\nDo you wish " +
                                "to continue? (Press y to continue or any other key to terminate): ",
                        userAnswer.size(), x, userAnswer);

                input.nextLine(); // Consume the newline character.
                c = input.next().charAt(0); // Read the user's decision to continue or terminate.

            } catch (InputMismatchException ex) {
                System.out.print("Incorrect input! "); // Handle invalid input.
                input.nextLine(); // Consume the newline character.
            }
        } while (c == 'y' || c == 'Y'); // Continue the loop as long as the user chooses to continue.

        myFooter(2); // Call a custom method to display the footer for the lab exercise.
    }

    // Function to display the lab exercise header
    public static void myHeader(int labNum) {
        // Display information about the lab exercise.
        System.out.println("=======================================================");
        System.out.println("Lab Exercise: " + labNum);
        System.out.println("Prepared By: Hamza Elkababji");
        System.out.println("Student Number: 251276422");
        System.out.println("Goal of this Exercise: To learn how to use Generic Type CLasses through a real life application");
        System.out.println("=======================================================");
        System.out.println("");
    }

    // Function to display the lab exercise footer
    public static void myFooter(int labNum) {
        // Display the completion message for the lab exercise.
        System.out.println("");
        System.out.println("=======================================================");
        System.out.println("Completion of Lab Exercise " + labNum + " is successful!");
        System.out.println("Signing off - Hamza");
        System.out.println("=======================================================");
    }
}
