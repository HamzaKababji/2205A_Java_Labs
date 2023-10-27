package L4Q2;

import java.util.ArrayList;
import java.util.Collections;

public class DriverForStudentClass {
    public static void main(String[] args) {
        myHeader(new Student(), 4, 2);


        // We're using an ArrayList to store our Student objects.
        ArrayList<Student> myArrayList = new ArrayList<>();

        // Adding students to the ArrayList with their names and scores.
        myArrayList.add(new Student());
        myArrayList.add(new Student("Harry", "Potter", 75.5));
        myArrayList.add(new Student("Ronald", "Weasley", 86.0));
        myArrayList.add(new Student("Hermione", "Granger", 91.7));
        myArrayList.add(new Student("Parvati", "Patil", 93.75));

        System.out.println("The Score Card:");

        // Displaying the initial list of students.
        for (Student student : myArrayList) {
            System.out.println("\t" + student);
        }

        System.out.println();
        System.out.println("The sorted list in terms of score in descending order....");

        // Sorting the list in descending order based on scores.
        Collections.sort(myArrayList, Collections.reverseOrder());

        // Displaying the sorted list.
        for (Student student : myArrayList) {
            System.out.println("\t" + student);
        }

        System.out.println();
        System.out.println("The sorted list in terms of Last Names....");

        // Sorting the list based on last names.
        Collections.sort(myArrayList, new HelperClassCompareLastNames());

        // Displaying the list sorted by last names.
        for (Student student : myArrayList) {
            System.out.println("\t" + student);
        }

        System.out.println();
        System.out.println("The sorted list in terms of First Names....");

        // Sorting the list based on first names.
        Collections.sort(myArrayList, new HelperClassCompareFirstNames());

        // Displaying the list sorted by first names.
        for (Student student : myArrayList) {
            System.out.println("\t" + student);
        }

        myFooter(4, 2);
    }

        // Function to display the lab exercise header
        public static void myHeader(Student myInfo, int labE_number, int q_number) {
            // Display information about the lab exercise.
            System.out.println("=======================================================");
            System.out.println("Lab Exercise: " + labE_number+"-Q"+ q_number);
            System.out.printf("Prepared By: %s %s\n", myInfo.firstName, myInfo.lastName);
            System.out.println("Student Number: 251276422");
            System.out.println("Goal of this Exercise: Demonstrate our understanding of doubly linked lists in comparison to other types.");
            System.out.println("=======================================================");
            System.out.println("");
        }
    
        // Function to display the lab exercise footer
        public static void myFooter(int labE_number, int q_number) {
            // Display the completion message for the lab exercise.
            System.out.println("");
            System.out.println("=======================================================");
            System.out.println("Completion of Lab Exercise " + labE_number +"-Q"+ q_number + " is successful!");
            System.out.println("Signing off - Hamza");
            System.out.println("=======================================================");
        }
}

