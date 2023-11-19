package LE6Q2;

import java.util.Collections;
import java.util.Vector;

public class Hamza_SortNameAndGrade {

    public static void main(String[] args) {
        // Display header information for the lab exercise
        myHeader(6, 2);

        String[] firstNameArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny",
                "Draco", "Dean", "Fred"};
        String[] lastNameArray = {"Granger", "Weasley", "Potter", "Lovegood",
                "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grades = {(int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26)};

        // Declare and instantiate a vector
        Vector<StudentGrade> studentGrades = new Vector<>();

        // Add values to the vector
        for (int i = 0; i < firstNameArray.length; i++) {
            studentGrades.add(new StudentGrade(firstNameArray[i], lastNameArray[i], grades[i]));
        }

        // Print the unsorted array
        System.out.print("The unsorted array..... \n");
        for (StudentGrade student : studentGrades) {
            System.out.println("  " + student);
        }

        System.out.println();

        // Sort the array using Collections.sort
        Collections.sort(studentGrades);

        // Print out sorted grades
        System.out.print("The array sorted by grades.....\n");
        for (StudentGrade student : studentGrades) {
            System.out.println("  " + student);
        }

        // Create a second array
        StudentGrade[] secondArray = new StudentGrade[firstNameArray.length];

        // Copy values to the second array
        studentGrades.copyInto(secondArray);

        // Sort the second array using the insertion sort method based on first names
        sortArray(secondArray, 1);

        // Print the sorted array based on first names
        System.out.println();
        printSortedArray(secondArray, "First Name");

        // Sort the array based on last names
        sortArray(secondArray, 2);

        // Print the sorted array based on last names
        System.out.println();
        printSortedArray(secondArray, "Last Name");

        // Display the completion message for the lab exercise
        myFooter(6, 2);
    }

    // Method used to sort array based on first or last names, similar to insertion sort method
    public static void sortArray(StudentGrade[] array, int nameKey) {
        if (nameKey == 1) {
            // Sorting by first name
            for (int i = 1; i < array.length; i++) {
                StudentGrade firstNameKey = array[i];
                int j = i - 1;
                // Shift elements greater than firstNameKey to the right
                while (j >= 0 && array[j].getFirstName().compareTo(firstNameKey.getFirstName()) > 0) {
                    array[j + 1] = array[j];
                    j--;
                }
                // Place firstNameKey in the correct position
                array[j + 1] = firstNameKey;
            }
        } else if (nameKey == 2) {
            // Sorting by last name
            for (int i = 1; i < array.length; i++) {
                StudentGrade lastNameKey = array[i];
                int j = i - 1;
                // Shift elements greater than lastNameKey to the right
                while (j >= 0 && array[j].getLastName().compareTo(lastNameKey.getLastName()) > 0) {
                    array[j + 1] = array[j];
                    j--;
                }
                // Place lastNameKey in the correct position
                array[j + 1] = lastNameKey;
            }
        }
    }

    // Method to print out the array using foreach loop
    public static void printSortedArray(StudentGrade[] array, String title) {
        System.out.println("Sorted by " + title + "..........");
        for (StudentGrade student : array) {
            System.out.println("  " + student);
        }
    }

    // Function to display the lab exercise header
    public static void myHeader(int labNum, int q) {
        // Display information about the lab exercise
        System.out.println("=======================================================");
        System.out.println("Lab Exercise: " + labNum + "." + q);
        System.out.println("Prepared By: Hamza Elkababji");
        System.out.println("Student Number: 251276422");
        System.out.println("Goal of this Exercise: Demonstrate our understanding of Stack and Queue data structures");
        System.out.println("=======================================================");
        System.out.println("");
    }

    // Function to display the lab exercise footer
    public static void myFooter(int labNum, int q) {
        // Display the completion message for the lab exercise
        System.out.println("");
        System.out.println("=======================================================");
        System.out.println("Completion of Lab Exercise " + labNum + "." + q + " is successful!");
        System.out.println("Signing off - Hamza Elkababji");
        System.out.println("=======================================================");
    }

    // Method used to call on nanoTime
    public static long nanoTime() {
        return System.nanoTime();
    }
}
