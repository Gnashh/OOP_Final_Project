// Interface defining methods related to restaurant status
public interface RestaurantStatus {

    void reduce();// Method to simulate a reduction in the status value


    boolean isBelowThreshold();// Method to check if the status value is below a certain threshold


    void view();// Method to display the status value


    void increase(); // Method to simulate an increase in the status value
}
