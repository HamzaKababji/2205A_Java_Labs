package LA5Q;

public class Passenger { // Passenger class created to keep track of all of the elements of the linked list with all variables in a neat and optimized way.
    private String name;
    private long ticketNumber;
    private long passportNumber;

    public Passenger(String name, long ticketNumber, long passportNumber) { // Obvious overloaded constructor that is used as a setter to take in every input from the user in case 2 from the driver method.
        this.name = name;
        this.ticketNumber = ticketNumber;
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() { // Override toString method to print out the desired data from the linked list elements/objects.
        return "Name: " + name + ", Ticket Number: " + ticketNumber + ", Passport: " + passportNumber;
    }
}