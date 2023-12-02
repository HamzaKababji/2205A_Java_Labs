package LE7Q1;

import java.util.Arrays;
import java.util.Scanner;

public class HamzaDemoHashingWithLinearProbing {
    public static Scanner input = new Scanner(System.in);

    // Variables to store data
    public static int items;
    public static double lf;
    public static int tableCapacity;

    // Arrays for hash table
    public static HamzaValueEntry[] hashTable;
    public static HamzaValueEntry[] workingHashTable;

    // Method to add a value to hash table using linear probing
    public static void addValueLinearProbe(Integer valueToAdd) {
        Integer temp;

        // Finding the proper position for the value to be added
        for (temp = valueToAdd; temp < 0; temp = temp + tableCapacity) {
        }

        int index = temp % tableCapacity;
        int available = tableCapacity;

        // Resolving collision using linear probing
        while (hashTable[index].getKey() != -1) {
            ++index;
            index %= tableCapacity;

            if (hashTable[index].getKey() == -111 && available == tableCapacity) {
                available = index;
            }
        }

        // Adding the value to the hash table
        if (available != tableCapacity) {
            hashTable[available].setKey(valueToAdd);
        } else {
            hashTable[index].setKey(valueToAdd);
        }
    }
    
    public static int checkPrime(int newSize) {
        int sqrtSize = (int) Math.floor(Math.sqrt(newSize));

        // Increment newSize until a prime number is found
        for (int i = 2; i <= sqrtSize; ++i) {
            if (newSize % i == 0) {
                ++newSize;
                sqrtSize = (int) Math.floor(Math.sqrt(newSize));
                i = 1;
            }
        }

        // Update tableCapacity and return newSize
        tableCapacity = newSize;
        return newSize;
    }

    // Method to remove a value from hash table using linear probing
    public static void removeValueLinearProbe(Integer valueToRemove) {
        Integer temp;

        // Finding the position of the value to remove
        for (temp = valueToRemove; temp < 0; temp = temp + tableCapacity) {
        }

        int index = temp % tableCapacity;
        boolean isFound = false;

        // Linear probing to find and remove the value
        while (hashTable[index].getKey() != -1 && (!isFound)) {
            if (hashTable[index].getKey().equals(valueToRemove)) {
                isFound = true;
            } else {
                ++index;
                index %= tableCapacity;
            }
        }

        // Removing the value if found
        if (isFound) {
            hashTable[index].setKey(-111);
            System.out.printf("%d is Found and Removed!", valueToRemove);
        } else {
            System.out.printf("%d is not found!", valueToRemove);
        }
    }

    // Method to display the hash table
    public static void printHashTable() {
        String[] printTable = new String[tableCapacity];

        // Creating the string representation of the hash table
        for (int i = 0; i < tableCapacity; i++) {
            if (hashTable[i].getKey() == -1) {
                printTable[i] = "null";
            } else if (hashTable[i].getKey() == -111) {
                printTable[i] = "available";
            } else {
                printTable[i] = Integer.toString(hashTable[i].getKey());
            }
        }
        System.out.print("The Current Hash-Table " + Arrays.toString(printTable) + "\n");
    }

    // Method for rehashing the hash table with linear probing
    public static void reHashingWithLinearProbing() {
        workingHashTable = new HamzaValueEntry[hashTable.length];

        // Copying the existing hash table
        for (int i = 0; i < hashTable.length; i++) {
            workingHashTable[i] = new HamzaValueEntry(hashTable[i].getKey());
        }

        // Creating a new hash table
        hashTable = new HamzaValueEntry[tableCapacity];

        for (int i = 0; i < tableCapacity; i++) {
            hashTable[i] = new HamzaValueEntry();
        }

        // Rehashing values from the previous hash table
        for (int i = 0; i < workingHashTable.length; i++) {
            HamzaValueEntry rehashing = workingHashTable[i];
            if (rehashing.getKey() != -1 && rehashing.getKey() != -111) {
                addValueLinearProbe(rehashing.getKey());
            }
        }
    }

    // Method to display the lab exercise header
    public static void myHeader(int labNum, int questionNumber) {
        System.out.println("=======================================================");
        System.out.println("Lab Exercise: " + labNum + " , " + questionNumber);
        System.out.println("Prepared By: Hamza Elkababji");
        System.out.println("Student Number: 251276422");
        System.out.println("Goal of this Exercise: Demonstrate our understanding of Stack and Queue data structures");
        System.out.println("=======================================================");
        System.out.println("");
    }

    // Method to display the lab exercise footer
    public static void myFooter(int labNum, int questionNumber) {
        System.out.println("");
        System.out.println("=======================================================");
        System.out.println("Completion of Lab Exercise " + labNum + " , " + questionNumber + " is successful!");
        System.out.println("Signing off - Hamza");
        System.out.println("=======================================================");
    }

    public static void main(String[] args) {
        myHeader(7, 1);

        // Obtaining input for items and load factor
        System.out.print("Let's decide on the initial table capacity based on the load factor and dataset size\nHow many data items: ");
        items = input.nextInt();

        System.out.print("What is the load factor? (Recommended: <= 0.5): ");
        lf = input.nextDouble();

        // Calculating table capacity based on load factor
        tableCapacity = checkPrime((int) Math.ceil((double) items / lf));

        System.out.print("The minimum required table capacity would be: " + tableCapacity);

        hashTable = new HamzaValueEntry[tableCapacity];

        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new HamzaValueEntry();
        }

        System.out.println();
        for (int i = 0; i < items; i++) {
            System.out.printf("Enter item %d: ", (i + 1));
            addValueLinearProbe(input.nextInt());
        }

        printHashTable();
        System.out.println("\nLet's remove two values from the table and then add one......\n");

        System.out.print("Enter a value you want to remove: ");

        removeValueLinearProbe(input.nextInt());

        System.out.print(" ");
        printHashTable();

        System.out.print("Enter a value you want to remove: ");
        removeValueLinearProbe(input.nextInt());
        
        System.out.print(" ");
        printHashTable();

        System.out.print("Enter a value you want to add: ");

        addValueLinearProbe(input.nextInt());
        printHashTable();

        System.out.println("\nRehashing the table...");
        System.out.println("The rehashed table capacity is: " + checkPrime(tableCapacity * 2));

        reHashingWithLinearProbing();
        printHashTable();

        myFooter(7, 1);
    }
}
