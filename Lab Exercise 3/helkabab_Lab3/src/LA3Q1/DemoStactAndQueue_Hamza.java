package LA3Q1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoStactAndQueue_Hamza {
    public static Scanner input = new Scanner(System.in); 

    // Method to demonstrate stack operations using a HamzaArray.
    public static void stackDemo(HamzaArray stackArr) {
        System.out.printf("\nYou have an empty stack: %s\n", stackArr.toString());

        char choice = 'a';

        do {
            try {
                // Display the stack operation menu and prompt for choice.
                System.out.printf("\nStack Operation Menu:\na: Push\nb: Pop\nc: Exit\nEnter Your Choice: ");
                choice = input.next().charAt(0);
                input.nextLine();

                if (choice != 'a' && choice != 'b' && choice != 'c') {
                    throw new InputMismatchException();
                }

                switch (choice) {
                    case 'a':
                        System.out.printf("Let's push a data item into the stack...\nEnter year: ");
                        int yr = input.nextInt();
                        input.nextLine();

                        System.out.printf("Enter name: ");
                        String name = input.nextLine();

                        Pair<Integer, String> newElement = new Pair(yr, name);
                        stackArr.addAtLastIndex(newElement);

                        System.out.printf("The current stack: %s\n", stackArr);

                        break;

                    case 'b':
                        System.out.printf("Let's pop a data item...\n");

                        if (stackArr.getSize() != 0) {
                            // Remove and display the last element from the stack.
                            System.out.printf("%s is removed! The current stack: %s\n",
                                    stackArr.removeFromLastIndex(), stackArr);
                        } else {
                            System.out.printf("FYI: The Stack is empty!\n");
                        }

                        break;

                    case 'c':
                        System.out.println("Ending stack demo! Goodbye!\n");
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.printf("Invalid choice!\n");
            }
        } while (choice != 'c');
    }

    // Method to demonstrate queue operations using a HamzaArray.
    public static void queueDemo(HamzaArray queueArr) {
        System.out.printf("\nYou have an empty queue: %s\n", queueArr);

        char choice = 'a';

        do {
            try {
                // Display the queue operation menu and prompt for choice.
                System.out.printf("\nQueue Operation Menu:\na: Enqueue\nb: Dequeue\nc: Exit\nEnter Your Choice: ");
                choice = input.next().charAt(0);
                input.nextLine();

                if (choice != 'a' && choice != 'b' && choice != 'c') {
                    throw new InputMismatchException();
                }

                switch (choice) {
                    case 'a':
                        System.out.printf("Let's enqueue a data item in the queue...\nEnter year: ");
                        int yr = input.nextInt();
                        input.nextLine();

                        System.out.printf("Enter name: ");
                        input.nextLine(); // Clear the newline character left by previous nextInt()
                        String name = input.nextLine();

                        Pair<Integer, String> newElement = new Pair(yr, name);
                        queueArr.addAtLastIndex(newElement);

                        System.out.printf("The current queue: %s\n", queueArr);

                        break;

                    case 'b':
                        System.out.printf("Let's dequeue a data item...\n");

                        if (queueArr.getSize() != 0) {
                            // Remove and display the first element from the queue.
                            System.out.printf("%s is removed! The current queue: %s\n",
                                    queueArr.removeFromFirstIndex(), queueArr);
                        } else {
                            System.out.printf("FYI: The queue is empty!\n");
                        }

                        break;

                    case 'c':
                        System.out.println("Ending Queue demo! Goodbye!\n");
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.printf("Invalid choice!\n");
            }
        } while (choice != 'c');
    }

    public static void main(String[] args) {
        myHeader(3);
        System.out.printf("This code performs a demo for Stack and Queue:\n\n");
        HamzaArray arr;
        int choice = 1;
        do {
            try {
                // Display the main demo menu and prompt for choice.
                System.out.printf("Main Demo-Menu:\n\t1: Stack\n\t2: Queue\n\t3: Exit\n\tEnter your choice: ");
                choice = input.nextInt();

                if (choice != 1 && choice != 2 && choice != 3) {
                    throw new Exception();
                }

                switch (choice) {
                    case 1:
                        arr = new HamzaArray();
                        stackDemo(arr);
                        break;

                    case 2:
                        arr = new HamzaArray();
                        queueDemo(arr);
                        break;
                }

            } catch (Exception ex) {
                System.out.printf("Invalid choice!\n\n");
                input.nextLine();
            }
        } while (choice != 3);

        System.out.printf("Goodbye!\n\n");
        myFooter(3);
    }
        // Function to display the lab exercise header
        public static void myHeader(int labNum) {
            // Display information about the lab exercise.
            System.out.println("=======================================================");
            System.out.println("Lab Exercise: " + labNum);
            System.out.println("Prepared By: Hamza Elkababji");
            System.out.println("Student Number: 251276422");
            System.out.println("Goal of this Exercise: Demonstrate our understanding of Stack and Queue data structures");
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
