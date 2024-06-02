public interface RestaurantStatus {
    void reduce();
    boolean isBelowThreshold();
    int getValue();
    void view();
    void increase();
}