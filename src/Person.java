public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int performanceContribution();

    @Override
    public String toString() {
        return name;
    }
}


