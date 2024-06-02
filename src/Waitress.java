public class Waitress extends Person {
    private int ability; // Ability level of the waitress

    // Constructor to initialize the waitress with a name and ability
    public Waitress(String name, int ability) {
        super(name); // Call the constructor of the superclass (Person) to set the name
        this.ability = ability; // Set the ability level
    }

    // Getter method to retrieve the ability level of the waitress
    public int getAbility() {
        return ability;
    }

    // Method to upgrade the ability level of the waitress
    public void upgradeAbility() {
        this.ability++;
    }

    // Method to calculate the performance contribution of the waitress
    @Override
    public int performanceContribution() {
        return ability * 25; // Ability level multiplied by a constant value
    }

    // Method to return a string representation of the waitress object
    @Override
    public String toString() {
        return "Waitress " + getName() + " with ability: " + ability; // Display waitress name and ability
    }
}
