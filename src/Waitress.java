public class Waitress extends Person {
    private int ability;

    public Waitress(String name, int ability) {
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
        return ability*25;

    }

    @Override
    public String toString() {
        return "Waitress " + getName() + " with ability: " + ability;
    }
}