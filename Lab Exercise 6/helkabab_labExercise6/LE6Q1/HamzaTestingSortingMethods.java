package LE6Q1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class HamzaTestingSortingMethods {
    public static <T extends Comparable<? super T>> long selectionSort(T[] a){

        long startTime = nanoTime();
        // Iterate through the array to sort it using Selection Sort algorithm
        for (int i = 0; i < a.length - 1; i++) {
            // Find the index of the minimum element in the unsorted portion
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                // Compare elements and update the index of the minimum element
                if (a[j].compareTo(a[minIndex]) < 0) {
                    minIndex = j;
                }
            }
    
            // Swap the minimum element with the first element of the unsorted part
            T temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
        long endTime = nanoTime();
        // Return the time taken for the sort
        return endTime - startTime;
    }
    


    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {
        // Record the start time
        long startTime = nanoTime();
    
        // Iterate through the array to sort it using Bubble Sort algorithm
        for (int i = 1; i < a.length; i++) {
            // Iterate through the unsorted part of the array
            for (int j = 0; j < a.length - i; j++) {
                // Compare adjacent elements and swap if necessary
                if (a[j].compareTo(a[j + 1]) > 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    
        // Record the end time
        long endTime = nanoTime();
    
        // Return the time taken for the sort
        return endTime - startTime;
    }
    

    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {
        // Record the start time
        long startTime = nanoTime();
    
        // Iterate through each element in the array
        for (int i = 1; i < a.length; i++) {
            // Store the current element to be inserted
            T key = a[i];
            // Initialize the index to the left of the current element
            int j = i - 1;
    
            // Move elements greater than the key to the right
            // until finding the correct position for the key
            while (j >= 0 && a[j].compareTo(key) > 0) {
                // Shift elements to the right
                a[j + 1] = a[j];
                // Move left in the sorted part of the array
                j--;
            }
    
            // Insert the key at its correct position
            a[j + 1] = key;
        }
    
        // Record the end time
        long endTime = nanoTime();
    
        // Return the time taken for the sort
        return endTime - startTime;
    }
    
    

    public static <T extends Comparable<? super T>> long mergeSort(T[] a) {
        long startTime = nanoTime();

        int n = a.length;
        if (n < 2){
            long endTime = nanoTime();
            return endTime - startTime; // array is trivially sorted
        }

        // divide
        int mid = n / 2;
        T[] S1 = Arrays.copyOfRange(a, 0, mid); // copy of first half
        T[] S2 = Arrays.copyOfRange(a, mid, n); // copy of second half

        // conquer (with recursion)
        mergeSort(S1); // sort copy of the first half
        mergeSort(S2); // sort copy of the second half

        // merge sorted halves back into the original
        int i = 0, j = 0;
        while (i + j < a.length) {
            if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) <= 0))
                a[i + j] = S1[i++]; // copy ith element of S1 and increment i
            else
                a[i + j] = S2[j++]; // copy jth element of S2 and increment j
        }

        long endTime = nanoTime();
        return endTime - startTime;
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] S, int a, int b) {
        if (a >= b) {
            return; // At most one element in the subrange
        }

        T p = S[b]; // Pivot is the last element
        int l = a; // Left pointer
        int r = b - 1; // Right pointer

        while (l <= r) {
            while (l <= r && S[l].compareTo(p) <= 0) {
                l++; // Find an element larger than the pivot
            }

            while (l <= r && S[r].compareTo(p) >= 0) {
                r--; // Find an element smaller than the pivot
            }

            if (l < r) {
                // Swap elements if pointers haven't crossed
                T temp = S[l];
                S[l] = S[r];
                S[r] = temp;

                l++;
                r--;
            }
        }

        // Put the pivot in its final place
        T temp = S[l];
        S[l] = S[b];
        S[b] = temp;

        // Recursive calls
        quickSort(S, a, l - 1);
        quickSort(S, l + 1, b);
    }

    public static long bucketSort(Integer[] a, int first, int last, int maxDigits){

        long startTime = nanoTime();

        Vector<Integer>[] bucket = new Vector[10];
        //instantiate each bucket;
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i < maxDigits; i++) {
            //clear the Vector buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }
            //Placing a[index] at end of bucket[digit]
            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(a[index], i);
                bucket[digit].add(a[index]);
            }
            //placing all the buckets back into the array
            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }
        long endTime = nanoTime();
        return endTime - startTime;
    }
    public static Integer findDigit(int number, int i) {
        // Initialize the target digit to 0
        int target = 0;

        // Iterate through each digit up to the specified position
        for (int k = 0; k <= i; k++) {
            // Extract the rightmost digit
            target = number % 10;
            // Remove the rightmost digit from the number
            number = number / 10;
        }

        // Return the extracted digit
        return target;
    }

    public static void main(String[] args){
        // Create header
        myHeader(6, 1);

        // Declare and instantiate Integer arrays
        Integer[] sz = new Integer[50000];
        Integer[] backup = new Integer[50000];

        // Populate the arrays with random values between 13 and 93
        for (int i = 0; i < sz.length; i++){
            int randomValue = (int)(Math.random() * (81) + 13 );
            sz[i] = randomValue;
        }

        // Copy the main array onto the backup array
        System.arraycopy(sz, 0, backup, 0, sz.length);

        // Create list and instantiate with the main array
        List<Integer> list = Arrays.asList(sz);


        // Print out the unsorted list
        //System.out.println("The unsorted list: " + list);

        // While also checking how long it takes using nanoTime, sort the array using collections.sort
        long startTime = nanoTime();
        Collections.sort(list);
        long endTime = nanoTime();

        // Print out the sorted list, as well as how long it took to sort using the specified method
        System.out.printf("Collections sorting time: %.2f milliseconds\n", (double)(endTime - startTime)*Math.pow(10,-6));
        //System.out.println("The sorted list using Collections' sort method: " + list);

        // Put the array back to its intially unsorted status
        System.arraycopy(backup, 0, sz, 0, backup.length);

        System.out.println();
        // Print out the unsorted list
        //System.out.println("The unsorted list: " + list);

        // While also checking how long it takes using nanoTime, sort the array using selection sort
        startTime = nanoTime();
        selectionSort(sz);
        endTime = nanoTime();

        // Print out the sorted list, as well as how long it took to sort using the specified method
        System.out.printf("Selection sort sorting time: %.2f milliseconds \n", (double)(endTime - startTime)*Math.pow(10,-6));
        //System.out.println("The sorted list using selection sort method: " + list);

        // Put the array back to its intially unsorted status
        System.arraycopy(backup, 0, sz, 0, backup.length);


        System.out.println();
        // Print out the unsorted list
        //System.out.println("The unsorted list: " + list);

        // While also checking how long it takes using nanoTime, sort the array using bubble sort
        startTime = nanoTime();
        bubbleSort(sz);
        endTime = nanoTime();

        // Print out the sorted array, as well as how long it took to sort using the specified method
        System.out.printf("Bubble sort sorting time: %.2f milliseconds \n", (double)(endTime - startTime)*Math.pow(10,-6));
        //System.out.println("The sorted list using bubble sort method: " + list);

        // Put the array back to its intially unsorted status
        System.arraycopy(backup, 0, sz, 0, backup.length);

        System.out.println();
        //System.out.println("The unsorted list: " + list);

        // While also checking how long it takes using nanoTime, sort the array using insertion sort
        startTime = nanoTime();
        insertionSort(sz);
        endTime = nanoTime();

        // Print out the sorted array, as well as how long it took to sort using the specified method
        System.out.printf("Insertion sort sorting time: %.2f milliseconds\n", (double)(endTime - startTime)*Math.pow(10,-6));
        //System.out.println("The sorted list using insertion sort method: " + list);

        // Put the array back to its intially unsorted status
        System.arraycopy(backup, 0, sz, 0, backup.length);

        System.out.println();
        //System.out.println("The unsorted list: " + list);

        // While also checking how long it takes using nanoTime, sort the array using merge sort
        startTime = nanoTime();
        mergeSort(sz);
        endTime = nanoTime();

        // Print out the sorted array, as well as how long it took to sort using the specified method
        System.out.printf("Merge sort sorting time: %.2f milliseconds \n", (double)(endTime - startTime)*Math.pow(10,-6));
        //System.out.println("The sorted list using merge sort method: " + list);

        // Put the array back to its intially unsorted status
        System.arraycopy(backup, 0, sz, 0, backup.length);

        System.out.println();
        //System.out.println("The unsorted list: " + list);

        // While also checking how long it takes using nanoTime, sort the array using quick sort
        startTime = nanoTime();
        quickSort(sz, 0, sz.length -1);
        endTime = nanoTime();

        // Print out the sorted array, as well as how long it took to sort using the specified method
        System.out.printf("Quick sort sorting time: %.2f milliseconds \n", (double)(endTime - startTime)*Math.pow(10,-6));
        //System.out.println("The sorted list using quick sort method: " + list);

        // Put the array back to its intially unsorted status
        System.arraycopy(backup, 0, sz, 0, backup.length);


        System.out.println();
        //System.out.println("The unsorted list: " + list);

        // While also checking how long it takes using nanoTime, sort the array using bucket sort
        startTime = nanoTime();
        bucketSort(sz, 0, sz.length - 1,  2);
        endTime = nanoTime();

        // Print out the sorted array, as well as how long it took to sort using the specified method
        System.out.printf("Bucket sort sorting time: %.2f milliseconds\n", (double)(endTime - startTime)*Math.pow(10,-6));
        //System.out.println("The sorted list using bucket sort method: " + list);

        // Put the array back to its intially unsorted status
        System.arraycopy(backup, 0, sz, 0, backup.length);

        // Print out footer
        myFooter(6, 1);
    }

    public static void myHeader(int labNum, int q) {
        // Display information about the lab exercise.
        System.out.println("=======================================================");
        System.out.println("Lab Exercise: " + labNum+"."+q);
        System.out.println("Prepared By: Hamza Elkababji");
        System.out.println("Student Number: 251276422");
        System.out.println("Goal of this Exercise: Demonstrate our understanding of Stack and Queue data structures");
        System.out.println("=======================================================");
        System.out.println("");
    }

        // Function to display the lab exercise footer
        public static void myFooter(int labNum, int q) {
            // Display the completion message for the lab exercise.
            System.out.println("");
            System.out.println("=======================================================");
            System.out.println("Completion of Lab Exercise " + labNum+"."+q + " is successful!");
            System.out.println("Signing off - Hamza Elkababji");
            System.out.println("=======================================================");
        }

    public static long nanoTime(){

        return System.nanoTime();
    }
}