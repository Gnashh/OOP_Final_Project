public class Chef extends Person {
    private int ability;

    public Chef(String name, int ability) {
        super(name);
        this.ability = ability;
    }

    public int getAbility() {
        return ability;
    }

    public void upgradeAbility() {
        this.ability++;
    }

    @Override
    public int performanceContribution() {
        return ability*50;

    }

    @Override
    public String toString() {
        return "Chef " + getName() + " with ability: " + ability;
    }
}