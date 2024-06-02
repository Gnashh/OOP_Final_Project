// Abstract class representing a person in the restaurant
public abstract class Person {
    // Private member variable to store the name of the person
    private String name;

    // Constructor to initialize the name of the person
    public Person(String name) {
        this.name = name;
    }

    // Getter method to retrieve the name of the person
    public String getName() {
        return name;
    }

    // Abstract method to calculate the performance contribution of the person
    public abstract int performanceContribution();

    // Override toString() method to provide a string representation of the person
    @Override
    public String toString() {
        return name; // Return the name of the person
    }
}
