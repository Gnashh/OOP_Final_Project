import java.util.Random;

// Class to manage the condition of tools in the restaurant
public class ToolsCondition implements RestaurantStatus {
    private int value; // Current tools condition value
    private static final int MAX_VALUE = 100; // Maximum tools condition value
    private static final int THRESHOLD = 50; // Threshold for tools condition warning
    private static final Random random = new Random(); // Random number generator

    // Constructor initializes tools condition to maximum value
    public ToolsCondition() {
        this.value = MAX_VALUE;
    }

    @Override
    public void reduce() {
        // Reduces tools condition value by a random amount between 10 and 24
        value -= random.nextInt(15) + 10;
        if (value < 0) value = 0; // Ensure value does not go below 0
    }

    @Override
    public boolean isBelowThreshold() {
        // Checks if tools condition value is below the threshold
        return value < THRESHOLD;
    }


    @Override
    public void view() {
        // Prints current tools condition value
        System.out.println("Tools Condition: " + value + "/100");
    }

    @Override
    public void increase() {
        // Increases tools condition value by 25
        value += 25;
    }
}