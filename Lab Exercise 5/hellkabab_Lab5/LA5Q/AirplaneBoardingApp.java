package LA5Q;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AirplaneBoardingApp {

    public static void main(String[] args) {
        /*  Used a Queue LinkedList to simulate a real plane assuming it is First in First out,
        where it allows the first people that enter to leave first, basically assuming the plane
        gets filled from the front to the back, and gets emptied from the front to the back.*/
        Queue<Passenger> passengerQueue = new LinkedList<>();

        Scanner input = new Scanner(System.in); // Making a new scanner object to take in user input.

        /* Made variables to use as conditions for if else statements to make sure the user finds it
        easy to know which part to do first by checking whether these values have been filled out or
        not, if not the user would have to go back and fill it out, ultimately making it more user friendly. */
        String fromDestination = null;
        String toDestination = null;
        boolean planeArrived = false;

        boolean case1AndCase2IsDone = false; // Variable made to not allow the user to use as a condition so the user cannot go back and add a passenger once the plane has arrived.

        int choice; // Used to keep track of the user's input throughout the application.

        myHeader(5); // Call myHeader method to print out the header created in lab 3.
        System.out.println("Airplane Boarding and Disembarking Application");
        System.out.println("----------------------------------------");

        // Infinite loop so the options for the switch case keep occurring until the user goes to trigger option 4 which will exit out of the entire code.
        while (true) {
            // Switch Case options displayed to the user.
            System.out.println("\n1. Set departure and arrival destinations");
            System.out.println("2. Add a passenger for boarding");
            System.out.println("3. Confirm boarding");
            System.out.println("4. Start disembarking process");
            System.out.print("\nEnter your choice: ");

            /* I have made a lot of try catch statements all throughout this code to make it as user friendly as possible.
            They all work in the same way, where it tries an entire piece of code from  a user, and if they enter an
            incorrect type of variable such as a string for an int choice, it will display an error message and prompt
            them to input it again until they do it correctly*/
            try {
                choice = input.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
                continue;
            }
            
            // Regular switch case statement to act as a menu within the passenger's application.
            switch (choice) {
                case 1:
                if (case1AndCase2IsDone == false) { // Checks if the user has already triggered case 3 or not, if they didn't they would be able to go through case 1. If they have, they just need to disembark.
                    System.out.print("\nEnter the departure destination: ");
                    fromDestination = input.next();
                    System.out.print("Enter the arrival destination: ");
                    toDestination = input.next();
                    System.out.println("\nDeparture destination set to: " + fromDestination);
                    System.out.println("Arrival destination set to: " + toDestination);
                } else {
                    System.out.println("\nThe plane has already arrived, therefore you cannot add any more passengers.");
                }
                    break;

                case 2:
                if (case1AndCase2IsDone == false){ // Same as the if statement in case 1, except now it will be for case 2 (adding passengers to the boarding process).
                    if (fromDestination != null && toDestination != null) { // Only allows the user to continue with case 2 if they have finished case 1, so they must go in order.
                        System.out.println("\nAdding a passenger for boarding.");
                        try { // Same comment as line 41-44.
                            System.out.print("\nEnter passenger name: ");
                            String firstName = input.next();
                            String lastName = input.nextLine();
                            System.out.print("Enter ticket number: ");
                            long ticketNumber = input.nextLong();
                            System.out.print("Enter passport number: ");
                            long passportNumber = input.nextLong();
                            Passenger boardingPassenger = new Passenger(firstName+lastName, ticketNumber, passportNumber); // Creating a new object of the class Passenger by passing all the user inputs from above.
                            passengerQueue.add(boardingPassenger); // Adding the newly created object above as an element within the linked list. This adds it to the back of the list.
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("\nInvalid input for passenger. Please enter valid information.");
                            input.nextLine(); // Consume the invalid input
                        }
                    } else {
                        System.out.println("\nPlease set departure and arrival destinations first.");
                    }
                } else {
                    System.out.println("\nThe plane has already arrived, therefore you cannot add any more passengers.");
                }
                    
                    break;

                case 3:
                    if (!passengerQueue.isEmpty()) { // Same concept of an if statement as above in case 2. Does not allow the user to continue unless they added passengers.
                        System.out.println("\nAll passengers have checked in.");
                        System.out.println("-----------------------");
                        System.out.println("\nThe plane has launched!");
                        System.out.println("\nFast forward time...");
                        System.out.println("\nThe plane has arrived!");
                        planeArrived = true;
                        case1AndCase2IsDone = true;
                    } else if (fromDestination == null && toDestination == null){ // If the application sees that the user has not done case 2, it will check if they did case 1. If they did then it will prompt to go to case 2. If they did not it will prompt to go back to case 1.
                        System.out.println("\nPlease set departure and arrival destinations first.");
                    } else {
                        System.out.println("\nPlease ensure all passengers have checked in.");
                    }
                    break;

                case 4:
                    if (planeArrived) { // Exactly the same thing as above if statements just now depending on whether the user finished case 3, and in the else ifs below, checks for which case they ended at.
                        System.out.println("\nStarting the disembarking process.\n");
                        while (!passengerQueue.isEmpty()) { //Keeps disembarking until the entire linked list becomes empty.
                            Passenger passenger = passengerQueue.poll(); // Makes a new object of the disembarked passenger to gain the Override toString method and be able to print it out in the line below this.
                            System.out.println("Disembarking passenger: " + passenger.toString());
                        }
                        System.out.println("\nWelcome to " + toDestination + "!\n");
                        System.out.println("Exiting the application.");
                        myFooter(5); // Call myFooter method to print out the footer created in lab 3.
                        System.exit(0); // Exiting the entire application as the user's journey is now completed and cannot do any other of the cases again, therefore also exiting out of the while (true) loop.
                    } else if (fromDestination == null && toDestination == null){
                        System.out.println("\nPlease set departure and arrival destinations first.");
                    } else if (passengerQueue.isEmpty()){
                        System.out.println("\nPlease ensure all passengers have checked in.");
                    } else {
                        System.out.println("\nPlease confirm boarding first.");
                    }
                    break;

                default: // Default case for any input from the user that is NOT 1, 2, 3, or 4.
                    System.out.println("\nInvalid choice. Please try again.");
                    break;
            }
        }
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
