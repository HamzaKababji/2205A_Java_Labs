package L4Q1;
import java.util.ArrayList;

public class DoublyLinkedList<E> {
    //---------------- nested Node class ----------------

    /**
     * Node of a doubly linked list, which stores a reference to its
     * element and to both the previous and next node in the list.
     */
    public static class Node<E> {

        /**
         * The element stored at this node.
         */
        private E element;

        // References to previous and next nodes in the list
        private Node<E> prev; // reference to the previous node in the list
        private Node<E> next; // reference to the subsequent node in the list

        /**
         * Creates a node with the given element, previous, and next nodes.
         *
         * @param element the element to be stored
         * @param prev reference to a node that should precede the new node
         * @param next reference to a node that should follow the new node
         */
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        // Public accessor methods

        /**
         * Returns the element stored at the node.
         *
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the preceding node in the list.
         *
         * @return the preceding node
         */
        public Node<E> getPrev() {
            return prev;
        }

        /**
         * Returns the following node in the list.
         *
         * @return the following node
         */
        public Node<E> getNext() {
            return next;
        }

        // Update methods

        /**
         * Sets the node's previous reference to point to Node p.
         *
         * @param p the node that should precede this one
         */
        public void setPrev(Node<E> p) {
            prev = p;
        }

        /**
         * Sets the node's next reference to point to Node n.
         *
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    //----------- end of nested Node class -----------

    // Instance variables of the DoublyLinkedList
    private Node<E> header; // header sentinel
    private Node<E> trailer; // trailer sentinel
    private int size = 0; // number of elements in the list

    /**
     * Constructs a new empty list with header and trailer sentinel nodes.
     */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null); // create header
        trailer = new Node<>(null, header, null); // trailer is preceded by header
        header.setNext(trailer); // header is followed by trailer
    }

    // Public accessor methods

    /**
     * Returns the number of elements in the linked list.
     *
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
    }

    // Public update methods

    /**
     * Adds an element to the linked list in between the given nodes.
     * The given predecessor and successor should be neighboring each
     * other prior to the call.
     *
     * @param e the element to be inserted
     * @param predecessor node just before the location where the new element is inserted
     * @param successor node just after the location where the new element is inserted
     */
    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * Searches for a node containing a specific element.
     *
     * @param e the element to search for
     * @return the node containing the element e (or null if not found)
     */
    public Node<E> findNode(E e) {
        Node<E> current = header.getNext();
        
        while (current != trailer) {
            if (current.getElement() == e) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Produces a string representation of the contents of the list.
     *
     * @return a string representing the elements in the list
     */
    public String toString() {
        ArrayList<E> allElements = new ArrayList<>();

        Node<E> currentElement = header.getNext();

        while (currentElement != trailer) {
            allElements.add(currentElement.getElement());
            currentElement = currentElement.getNext();
        }
        return allElements.toString();
    }
}
