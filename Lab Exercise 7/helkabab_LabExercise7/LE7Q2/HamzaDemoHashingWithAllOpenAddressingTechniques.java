package LE7Q2;

import java.util.Arrays;

import LE7Q1.HamzaDemoHashingWithLinearProbing;
import LE7Q1.HamzaValueEntry;

public class HamzaDemoHashingWithAllOpenAddressingTechniques {

    // Method for adding a value with double hashing
    public static void addValueWithDoubleHashing(Integer valueToAdd) {
        Integer temp;
        // Handling negative values by making them positive
        for (temp = valueToAdd; temp < 0; temp = temp + HamzaDemoHashingWithLinearProbing.tableCapacity) {
        }

        int originalNumber = temp % HamzaDemoHashingWithLinearProbing.tableCapacity;
        int shift = thePrimeNumberForSecondHashFunction() - valueToAdd % thePrimeNumberForSecondHashFunction();

        // Collision resolution using double hashing
        for (int shiftIncrement = 0;
             HamzaDemoHashingWithLinearProbing.hashTable[originalNumber].getKey() != -1 &&
                     HamzaDemoHashingWithLinearProbing.hashTable[originalNumber].getKey() != -111;
             originalNumber = (temp % HamzaDemoHashingWithLinearProbing.tableCapacity + shiftIncrement * shift) % HamzaDemoHashingWithLinearProbing.tableCapacity) {

            shiftIncrement++;
        }
        HamzaDemoHashingWithLinearProbing.hashTable[originalNumber].setKey(valueToAdd);
    }

    // Method for adding a value with quadratic probing
    public static void addValueQuadraticProbe(Integer valueToAdd) {
        Integer tempValue;
        // Handling negative values by making them positive
        for (tempValue = valueToAdd; tempValue < 0; tempValue = tempValue + HamzaDemoHashingWithLinearProbing.tableCapacity) {
        }

        int tableIndex = 0;

        int quadAdd;
        // Collision resolution using quadratic probing
        for (quadAdd = 0; HamzaDemoHashingWithLinearProbing.hashTable[tableIndex].getKey() != -1 &&
                HamzaDemoHashingWithLinearProbing.hashTable[tableIndex].getKey() != -111 && quadAdd < HamzaDemoHashingWithLinearProbing.tableCapacity; ++quadAdd) {
            tableIndex = (tempValue % HamzaDemoHashingWithLinearProbing.tableCapacity + (int) Math.pow(quadAdd, 2.0)) % HamzaDemoHashingWithLinearProbing.tableCapacity;
        }

        if (quadAdd >= HamzaDemoHashingWithLinearProbing.tableCapacity) {
            System.out.printf("Probing failed! Use a load factor of 0.5 or less. Goodbye!\n");
        } else {
            HamzaDemoHashingWithLinearProbing.hashTable[tableIndex].setKey(valueToAdd);
        }

    }

    // Method for printing an array
    public static void printArray(Integer[] display) {
        System.out.print(Arrays.toString(display));
    }

    // Method to empty the hash table
    public static void emptyHashTable() {

        for (int i = 0; i < HamzaDemoHashingWithLinearProbing.hashTable.length; i++) {
            HamzaValueEntry item = HamzaDemoHashingWithLinearProbing.hashTable[i];
            item.setKey(-1);
        }
    }

    // Method to determine the prime number for the second hash function
    public static int thePrimeNumberForSecondHashFunction() {
        int number2 = HamzaDemoHashingWithLinearProbing.tableCapacity - 1;

        for (int i = 2; i <= (int) Math.ceil(Math.sqrt(number2)); i++) {
            if (number2 % i == 0) {
                number2--;
                i = 1;
            }
        }
        return number2;
    }

    // Main method
    public static void main(String[] args) {
        HamzaDemoHashingWithLinearProbing.myHeader(7, 2);

        // User input for data items and load factor
        System.out.print("Let's demonstrate our understanding on all the open addressing techniques...\nHow many data items: ");
        int numItems = HamzaDemoHashingWithLinearProbing.input.nextInt();

        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        HamzaDemoHashingWithLinearProbing.lf = HamzaDemoHashingWithLinearProbing.input.nextDouble();

        HamzaDemoHashingWithLinearProbing.tableCapacity = HamzaDemoHashingWithLinearProbing.checkPrime((int) Math.ceil((double) numItems / HamzaDemoHashingWithLinearProbing.lf));

        HamzaDemoHashingWithLinearProbing.hashTable = new HamzaValueEntry[HamzaDemoHashingWithLinearProbing.tableCapacity];

        for (int i = 0; i < HamzaDemoHashingWithLinearProbing.tableCapacity; i++) {
            HamzaDemoHashingWithLinearProbing.hashTable[i] = new HamzaValueEntry();
        }

        // Data values to be inserted into the hash table
        Integer[] values = new Integer[]{-11, 22, -33, -44, 55};

        System.out.print("The minimum required table capacity would be: " + HamzaDemoHashingWithLinearProbing.tableCapacity + "\nThe given dataset is: ");
        printArray(values);
        System.out.print("\nLet's enter each data item from the above to the hash table:\n\nAdding data - linear probing resolves collision\n");

        Integer element;
        for (int i = 0; i < values.length; i++) {
            element = values[i];
            HamzaDemoHashingWithLinearProbing.addValueLinearProbe(element);
        }

        HamzaDemoHashingWithLinearProbing.printHashTable();

        emptyHashTable();

        System.out.printf("\nAdding data - quadratic probing resolves collision\n");

        for (int i = 0; i < values.length; i++) {
            element = values[i];
            addValueQuadraticProbe(element);
        }

        HamzaDemoHashingWithLinearProbing.printHashTable();

        emptyHashTable();

        System.out.print("\nAdding data - double-hashing resolves collision\nThe q value for double hashing is: " + thePrimeNumberForSecondHashFunction() + "\n");

        for (int i = 0; i < values.length; i++) {
            element = values[i];
            addValueWithDoubleHashing(element);
        }

        HamzaDemoHashingWithLinearProbing.printHashTable();

        HamzaDemoHashingWithLinearProbing.myFooter(7, 2);
    }
}
