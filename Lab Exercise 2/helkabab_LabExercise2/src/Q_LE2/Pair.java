package Q_LE2;

// Generic Pair class with two type parameters Y and N
public class Pair<Y, N> {
    private Y key;    // The first element of the pair
    private N value;  // The second element of the pair

    // Constructor to initialize a Pair with a key and a value
    public Pair(Y key, N value) {
        this.key = key;
        this.value = value;
    }

    // Setter method to update the key
    public void setKey(Y key) {
        this.key = key;
    }

    // Getter method to retrieve the key
    public Y getKey() {
        return key;
    }

    // Getter method to retrieve the value
    public N getValue() {
        return value;
    }
}
