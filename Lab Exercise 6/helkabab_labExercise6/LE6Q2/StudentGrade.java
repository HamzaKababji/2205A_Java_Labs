package LE6Q2;

// Class representing student grades, implementing Comparable interface for sorting
public class StudentGrade implements Comparable<StudentGrade> {

    // Instance variables
    private String firstName;
    private String lastName;
    private int grade;

    // Default constructor
    public StudentGrade() {}

    // Parameterized constructor to initialize the object with specific values
    public StudentGrade(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    // Getter method for retrieving the first name
    public String getFirstName() {
        return firstName;
    }

    // Getter method for retrieving the last name
    public String getLastName() {
        return lastName;
    }

    // Getter method for retrieving the grade
    public int getGrade() {
        return grade;
    }

    // Compare method for sorting based on grades
    public int compareTo(StudentGrade other) {
        int comparison = 0;

        // Compare grades of two StudentGrade objects
        if (this.getGrade() < other.getGrade()) {
            comparison = -1;
        } else if (this.getGrade() > other.getGrade()) {
            comparison = 1;
        } else {
            comparison = 0;
        }

        return comparison;
    }

    // String representation of the object
    public String toString() {
        // Format the output with specified width for each attribute
        return String.format("%-15s %-15s : %4d", getFirstName(), getLastName(), getGrade());
    }
}
