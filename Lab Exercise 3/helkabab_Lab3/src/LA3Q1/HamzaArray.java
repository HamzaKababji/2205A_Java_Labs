package LA3Q1;

public class HamzaArray {

    // The HamzaArray class represents a custom array-like data structure called "HamzaArray."

    private Pair[] testArr = new Pair[0];  // Initialize the array with a size of 0.

    // A method to get the current size (length) of the HamzaArray.
    public int getSize() {
        return testArr.length;
    }

    // A method to remove and return the element at the last index of the HamzaArray.
    public Pair removeFromLastIndex() {
        Pair last = testArr[getSize() - 1];  // Get the last element.
        Pair[] tempArray = new Pair[getSize() - 1];  // Create a new array with one less element.

        // Copy elements from the old array to the new one, excluding the last element.
        System.arraycopy(testArr, 0, tempArray, 0, tempArray.length);

        testArr = tempArray;  // Update the HamzaArray with the new array.
        tempArray = null;  // Release the reference to the temporary array.

        return last;  // Return the removed element.
    }

    // A method to remove and return the element at the first index of the HamzaArray.
    public Pair removeFromFirstIndex() {
        Pair first = testArr[0];  // Get the first element.
        Pair[] tempArray = new Pair[getSize() - 1];  // Create a new array with one less element.

        // Copy elements from the old array, starting from the second element.
        System.arraycopy(testArr, 1, tempArray, 0, tempArray.length);

        testArr = tempArray;  // Update the HamzaArray with the new array.
        tempArray = null;  // Release the reference to the temporary array.

        return first;  // Return the removed element.
    }

    // A method to convert the HamzaArray into a formatted string.
    public String toString() {
        String response = "";

        // Iterate through the elements in the HamzaArray and append their string representations.
        for (Pair element : testArr) {
            response += element.toString();
        }

        return String.format("[" + response + "]");  // Return the formatted string.
    }

    // A method to add an element at the last index of the HamzaArray.
    public void addAtLastIndex(Pair add) {
        Pair[] tempArray = new Pair[getSize() + 1];  // Create a new array with one more element.

        // Copy elements from the old array to the new one.
        System.arraycopy(testArr, 0, tempArray, 0, getSize());

        tempArray[tempArray.length - 1] = add;  // Add the new element at the last index.
        testArr = tempArray;  // Update the HamzaArray with the new array.
        tempArray = null;  // Release the reference to the temporary array.
    }
}
