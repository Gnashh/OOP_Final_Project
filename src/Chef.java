public class Chef extends Person {
    private int ability; // Ability level of the chef

    // Constructor to initialize the chef with a name and ability
    public Chef(String name, int ability) {
        super(name); // Call the constructor of the superclass (Person) to set the name
        this.ability = ability; // Set the ability level
    }

    // Getter method to retrieve the ability level of the chef
    public int getAbility() {
        return ability;
    }

    // Method to upgrade the ability level of the chef
    public void upgradeAbility() {
        this.ability++;
    }

    // Method to calculate the performance contribution of the chef
    @Override
    public int performanceContribution() {
        return ability*50; // Ability level multiplied by constant value

    }

    // Method to return a string representation of the chef object
    @Override
    public String toString() {
        return "Chef " + getName() + " with ability: " + ability;
    }
}