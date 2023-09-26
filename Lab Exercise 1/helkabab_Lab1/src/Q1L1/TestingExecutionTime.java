package Q1L1;

import java.util.Scanner;

public class TestingExecutionTime {

    // Declare a Scanner object for user input
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        long startTime = 0;
        long endTime = 0;

        // Display lab header information
        myHeader(1);

        // Prompt the user to enter an integer number
        System.out.print("Please Enter an Integer Number: ");
        int factorial = input.nextInt();

        // Ensure the entered number is non-negative
        while (factorial < 0) {
            System.out.println("Please Enter a New Number: ");
            factorial = input.nextInt();
        }

        // Measure the start time for iterative factorial calculation
        startTime = System.nanoTime();

        double ifv = 1; // Initialize the factorial value
        int counter = 1; // Initialize a counter for the loop

        // Calculate factorial iteratively using a while loop
        while (counter <= factorial) {
            ifv = ifv * counter; // Update the factorial value
            counter++; // Increment the counter
        }

        // Measure the end time for iterative calculation
        endTime = System.nanoTime();

        // Display the calculated factorial and execution time
        System.out.printf("Factorial(%d) is %.0e%n", factorial, ifv);
        System.out.printf("Time taken by iterative solution inside main: %.2e sec %n", (endTime - startTime) * Math.pow(10, -9));

        // Measure the start time for iterative method call
        startTime = System.nanoTime();

        // Calculate factorial using the iterativeMethodForFactorial function
        System.out.printf("Factorial(%d) with iterative method is %.0e%n", factorial, iterativeMethodForFactorial(factorial));

        // Measure the end time for iterative method call
        endTime = System.nanoTime();

        // Display the execution time for the iterative method
        System.out.printf("Time taken by iterative method call: %.2e sec %n", (endTime - startTime) * Math.pow(10, -9));

        // Measure the start time for recursive method call
        startTime = System.nanoTime();

        // Calculate factorial using the recursiveMethodForFactorial function
        System.out.printf("Factorial(%d) with recursive method is %.0e%n", factorial, recursiveMethodForFactorial(factorial));

        // Measure the end time for recursive method call
        endTime = System.nanoTime();

        // Display the execution time for the recursive method
        System.out.printf("Time taken by recursive method call: %.2e sec %n", (endTime - startTime) * Math.pow(10, -9));

        // Display the lab completion footer
        myFooter(1);
    }

    // Function to calculate factorial iteratively
    public static double iterativeMethodForFactorial(int x) {
        double ifv = 1; // Initialize the factorial value
        int i = 1; // Initialize a counter for the loop

        // Calculate factorial iteratively using a while loop
        while (i <= x) {
            ifv = ifv * i; // Update the factorial value
            i++; // Increment the counter
        }

        return ifv; // Return the calculated factorial
    }

    // Function to calculate factorial recursively
    public static double recursiveMethodForFactorial(int x) {
        if (x == 0) {
            return 1; // Base case: factorial of 0 is 1
        } else {
            // Recursive case: factorial of x is x multiplied by factorial of (x-1)
            return x * recursiveMethodForFactorial(x - 1);
        }
    }

    // Function to display the lab exercise header
    public static void myHeader(int labNum) {
        System.out.println("=======================================================");
        System.out.println("Lab Exercise: " + labNum);
        System.out.println("Prepared By: Hamza Elkababji");
        System.out.println("Student Number: 251276422");
        System.out.println("Goal of this Exercise: (Q1) We will check the execution time of our code by writing a program \nthat finds the factorial of a large number. \n(Q2) We will work with arrays to figure out how to find the \nmin, max, avg, and even the number of values entered by the user that are divisible by 5.");
        System.out.println("=======================================================");
        System.out.println("");
    }

    // Function to display the lab exercise footer
    public static void myFooter(int labNum) {
        System.out.println("");
        System.out.println("=======================================================");
        System.out.println("Completion of Lab Exercise " + labNum + " is successful!");
        System.out.println("Signing off - Hamza");
        System.out.println("=======================================================");
    }
}
