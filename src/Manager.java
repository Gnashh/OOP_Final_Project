public class Manager extends Person {

    private int experience;
    private double bonusMultiplier;

    public Manager(String name, int exp) {
        super(name);
        this.experience = exp;
        this.bonusMultiplier = 1.0 + (experience * 0.05);
    }

    public int getExperience() {
        return experience;
    }

    public void increaseExp(){
        this.experience++;
    }

    @Override
    public int performanceContribution() {
        return experience * 100;
    }

    public String toString() {
        return "Manager " + getName() + " with experience: " + experience + " and bonus multiplier: " + bonusMultiplier;
    }
}
