package LE7Q1;

// Class representing an entry in a hash table
public class HamzaValueEntry {
    // Private variable to store the key value
    private Integer key;

    // Constructor: Initializes the key to -1 (default)
    public HamzaValueEntry() {
        this.key = -1;
    }

    // Constructor: Initializes the key to a specified value
    public HamzaValueEntry(Integer key) {
        this.key = key;
    }

    // Method to set the key value
    public void setKey(Integer key) {
        this.key = key;
    }

    // Method to retrieve the key value
    public Integer getKey() {
        return key;
    }
}
