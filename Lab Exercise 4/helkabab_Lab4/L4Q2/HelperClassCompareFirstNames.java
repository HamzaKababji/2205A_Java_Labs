package L4Q2;

import java.util.Comparator;

// A custom comparator class to compare students based on their first names.
public class HelperClassCompareFirstNames implements Comparator<Student> {

    // Compare method to compare two students based on their first names.
    public int compare(Student student1, Student student2) {

        // Get the first names of both students for comparison.
        String firstName1 = student1.getFirstName();
        String firstName2 = student2.getFirstName();

        // Compare the first names and return the result.
        return firstName1.compareTo(firstName2);
    }
}
