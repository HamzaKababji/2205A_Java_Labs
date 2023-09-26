package Q2L2;

import Q1L1.TestingExecutionTime; // Import the TestingExecutionTime class from a different package

import java.util.Scanner;

public class WorkingWithArrays {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        TestingExecutionTime q1 = new TestingExecutionTime(); // Create an instance of the TestingExecutionTime class
        q1.myHeader(1); // Call the myHeader method to display lab information

        // Prompt the user to enter the array size
        System.out.print("Please Enter Array Size of Your Liking: ");
        int size = input.nextInt();
        double[] arr = new double[size]; // Create an array to store user-input values

        int i = 0;
        while (i < size) {
            // Prompt the user to enter values for the array
            System.out.printf("Please Enter Value %d: ", i + 1);
            arr[i] = input.nextInt();
            i++;
        }

        System.out.println("\nHere is the result: ");

        // Call the mma5MethodHamza method to process the array
        mma5MethodHamza(arr);

        q1.myFooter(1); // Call the myFooter method to display the lab completion footer
    }

    public static double[] mma5MethodHamza(double[] arr) {
        double max = arr[0];
        double min = arr[0];
        double sum = 0, count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 0) {
                max = Math.max(arr[i], max);
                min = Math.min(arr[i], min);

                sum = sum + arr[i];
                count++;
            }
        }

        if (count == 0) {
            // Handle the case where there are no numbers divisible by 5 in the array
            System.out.println("\nIn the array, there was no number 'divisible by 5' and hence the average remains 0.00");
            return null;
        }

        double avg = count > 0 ? sum / count : 0;

        // Display statistics about the array
        System.out.printf("Found %.0f out of %s numbers that are divisible by 5 %n", count, arr.length);
        System.out.printf("The max is %.2f %n", max);
        System.out.printf("The min is %.2f %n", min);
        System.out.printf("The average of the 'divisible by 5' numbers is %f %n", avg);
        System.out.printf("My student number is %d %n", 251276422);

        return arr; // Return the original array
    }
}
