package L4Q2;

public class Student implements Comparable<Student> {
    public String firstName;
    public String lastName;
    public Double score;

    // Default constructor creates a student with a name and a perfect score.
    public Student() {
        this.firstName = "Hamza";
        this.lastName = "Elkababji";
        this.score = 100.0;
    }

    // Custom constructor to create a student with specified first name, last name, and score.
    public Student(String firstName, String lastName, Double score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    // Getter method for retrieving the student's score.
    public Double getScore() {
        return this.score;
    }

    // Setter method to update the student's score.
    public void setScore(double score) {
        this.score = score;
    }

    // Getter method for retrieving the student's first name.
    public String getFirstName() {
        return firstName;
    }

    // Setter method to update the student's first name.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter method for retrieving the student's last name.
    public String getLastName() {
        return lastName;
    }

    // Setter method to update the student's last name.
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Provides a human-readable representation of the student's information.
    public String toString() {
        return String.format("%s %s: %.2f", firstName, lastName, score);
    }

    // Implementing the Comparable interface to compare students based on their scores.
    public int compareTo(Student comparedScore) {
        int comparison = 0;
        if (this.score < comparedScore.score) {
            comparison = -1;
        } else if (this.score > comparedScore.score) {
            comparison = 1;
        } else {
            comparison = 0;
        }
        return comparison;
    }
}
