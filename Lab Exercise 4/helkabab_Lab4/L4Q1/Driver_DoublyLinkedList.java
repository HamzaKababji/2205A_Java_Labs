package L4Q1;

public class Driver_DoublyLinkedList {
    public static void main(String[] args){
        myHeader(4, 1);

        // We're using a DoublyLinkedList to manage our MyStudent objects.
        DoublyLinkedList<MyStudent> hamzaList = new DoublyLinkedList<>();

        // We've got a bunch of MyStudent objects ready for testing.
        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry", 67.35);
        MyStudent s2 = new MyStudent("Luna", 87.5);
        MyStudent s3 = new MyStudent("Vincent", 60.5);
        MyStudent s4 = new MyStudent("Hermione", 89.2);

        // We're adding these students to our doubly linked list, which allows for dynamic changes.
        hamzaList.addLast(s0);
        hamzaList.addLast(s1);
        hamzaList.addLast(s2);
        hamzaList.addLast(s3);

        // Check this out: adding 4 students to the list with ease.
        System.out.println("Adding 4 students to the list. \nThe List Contents: ");
        System.out.println(hamzaList);

        // Now, we're finding the nodes for Luna and Vincent. Doubly linked lists are efficient at searching.
        DoublyLinkedList.Node<MyStudent> nodeLuna = hamzaList.findNode(s2);
        DoublyLinkedList.Node<MyStudent> nodeVincent = hamzaList.findNode(s3);

        // See how easily we can insert Hermione between Luna and Vincent.
        hamzaList.addBetween(s4, nodeLuna, nodeVincent);

        System.out.println("Adding Hermione to the list between Luna and Vincent...\n The List Contents:");
        System.out.println(hamzaList);

        myFooter(4, 1);
    }

        // Function to display the lab exercise header
        public static void myHeader(int labE_number, int q_number) {
            // Display information about the lab exercise.
            System.out.println("=======================================================");
            System.out.println("Lab Exercise: " + labE_number+"-Q"+ q_number);
            System.out.println("Prepared By: Hamza Elkababji");
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

