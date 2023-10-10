package LA3Q1;

// Generic Pair class with two type parameters Y and N
public class Pair<Y, N> {
    private Y key;    // The first element of the pair
    private N value;  // The second element of the pair

    // Constructor to initialize a Pair with a key and a value
    public Pair(Y key, N value) {
        this.key = key;
        this.value = value;
    }

    // Empty constructor
    public Pair() {
    }

    // Override the toString default method for formatting
    public String toString(){ 
        return(String.format("[YR: %s, NM: %s]", key, value));
    }
}
