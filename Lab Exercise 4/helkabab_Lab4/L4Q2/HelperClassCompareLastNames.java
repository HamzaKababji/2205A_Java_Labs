package L4Q2;

import java.util.Comparator;

// A custom comparator class to compare students based on their last names.
public class HelperClassCompareLastNames implements Comparator<Student> {

    // Compare method to compare two students based on their last names.
    public int compare(Student student1, Student student2) {

        // Get the last names of both students for comparison.
        String lastName1 = student1.getLastName();
        String lastName2 = student2.getLastName();

        // Compare the last names and return the result.
        return lastName1.compareTo(lastName2);
    }
}
