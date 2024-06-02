import java.util.Random;

public class ToolsCondition implements RestaurantStatus {
    private int value;
    private static final int MAX_VALUE = 100;
    private static final int THRESHOLD = 50;
    private static final Random random = new Random();

    public ToolsCondition() {
        this.value = MAX_VALUE;
    }

    @Override
    public void reduce() {
        value -= random.nextInt(15) + 10;
        if (value < 0) value = 0;
    }

    @Override
    public boolean isBelowThreshold() {
        return value < THRESHOLD;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void view() {
        System.out.println("Tools Condition: " + value + "/100");
    }

    @Override
    public void increase() {
        value += 25;
    }
}
