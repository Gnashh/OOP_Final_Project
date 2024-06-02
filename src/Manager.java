public class Manager extends Person {
    private int experience; // Manager experience level
    private double bonusMultiplier; // Bonus multiplier based on experience

    // Constructor to initialize Manager with name and experience
    public Manager(String name, int exp) {
        super(name); // Call superclass constructor to set the name
        this.experience = exp; // Initialize experience
        // Calculate bonus multiplier based on experience
        this.bonusMultiplier = 1.0 + (experience * 0.05);
    }

    // Getter method for Manager's experience
    public int getExperience() {
        return experience;
    }

    // Method to increase Manager's experience
    public void increaseExp() {
        this.experience++;
        // Recalculate bonus multiplier when experience increases
        this.bonusMultiplier = 1.0 + (experience * 0.05);
    }

    public double getBonusMultiplier() {
        return bonusMultiplier;
    }

    // Method to calculate Manager's performance contribution
    @Override
    public int performanceContribution() {
        return 0;
    }

    // Override toString method to provide a string representation of Manager
    @Override
    public String toString() {
        // Return Manager's name, experience, and bonus multiplier
        return "Manager " + getName() + " with experience: " + experience + " and bonus multiplier: " + bonusMultiplier;
    }
}
