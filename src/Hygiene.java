import java.util.Random;

// Class to manage the hygiene status of the restaurant
public class Hygiene implements RestaurantStatus {
    private int value; // Current hygiene value
    private static final int MAX_VALUE = 100; // Maximum hygiene value
    private static final int THRESHOLD = 50; // Threshold for hygiene warning
    private static final Random random = new Random(); // Random number generator

    // Constructor initializes hygiene to maximum value
    public Hygiene() {
        this.value = MAX_VALUE;
    }

    @Override
    public void reduce() {
        // Reduces hygiene value by a random amount between 10 and 30
        value -= random.nextInt(21) + 10;
        if (value < 0) value = 0; // Ensure value does not go below 0
    }

    @Override
    public boolean isBelowThreshold() {
        // Checks if hygiene value is below the threshold
        return value < THRESHOLD;
    }

    @Override
    public void view() {
        // Prints current hygiene value
        System.out.println("Hygiene: " + value + "/100");
    }

    @Override
    public void increase() {
        // Increases hygiene value by 25
        value += 25;
    }
}