package L4Q1;

public class MyStudent {

    public String firstName;
    public Double score;

    // Our first constructor initializes a default student with the name "Hamza" and a perfect score.
    public MyStudent() {
        this.firstName = "Hamza";
        this.score = 100.0;
    }

    // The second constructor allows us to create a student with a custom name and score.
    public MyStudent(String studentName, Double studentScore) {
        this.firstName = studentName;
        this.score = studentScore;
    }

    // The toString method provides a human-friendly representation of the student's information.
    public String toString() {
        return String.format("%s: %.2f", firstName, score);
    }
}
