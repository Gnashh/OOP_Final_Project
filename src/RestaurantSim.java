import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantSim {
    // Constants for starting capital and base target revenue
    private static final int STARTING_CAPITAL = 750;
    private static final int BASE_TARGET_REVENUE = 750;

    // Scanner for user input and DecimalFormat for currency formatting
    private static final Scanner sc = new Scanner(System.in);
    private static final DecimalFormat currencyFormat = new DecimalFormat("$#,##0.00");

    public static void main(String[] args) {
        int currentMonth = 1; // Starting month
        int capital = STARTING_CAPITAL; // Initial capital
        double targetRevenue = BASE_TARGET_REVENUE; // Initial target revenue
        int employeeCount = 0; // Initial employee count

        // Lists to store chefs and waitresses
        ArrayList<Chef> chefs = new ArrayList<>();
        ArrayList<Waitress> waitresses = new ArrayList<>();
        Manager manager = null; // Manager initial variable

        // Initializing restaurant status attributes
        Hygiene hygiene = new Hygiene();
        ToolsCondition toolsCondition = new ToolsCondition();
        StockCondition stockCondition = new StockCondition();

        // Main simulation loop
        while (capital > 0) {
            System.out.println("\n** Month " + currentMonth + " **");
            System.out.println("Capital: " + currencyFormat.format(capital));
            System.out.println("Target Profit: " + currencyFormat.format(targetRevenue));
            System.out.println("Employee amount: " + employeeCount);
            System.out.println("1. Hire Employee");
            System.out.println("2. Fire Employee");
            System.out.println("3. Manage Staff");
            System.out.println("4. View Upgrades");
            System.out.println("5. View Restaurant Status");
            System.out.println("6. Restaurant Maintenance");
            System.out.println("7. End Month");
            System.out.println("\nPlease input your action:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Hire Employee
                    System.out.println("1. Hire Chef $250\n2. Hire Waitress $150\n3. Hire Manager $2000");
                    System.out.println("\nPlease input your action:");
                    int hiring = sc.nextInt();

                    switch (hiring) {
                        case 1: // Hire Chef
                            if (capital > 250) {
                                chefs.add(Utility.hireChef());
                                employeeCount++;
                                capital -= 250;
                            } else {
                                System.out.println("You don't have enough money to hire");
                            }
                            break;

                        case 2: // Hire Waitress
                            if (capital > 150) {
                                waitresses.add(Utility.hireWaitress());
                                employeeCount++;
                                capital -= 150;
                            } else {
                                System.out.println("You don't have enough money to hire");
                            }
                            break;

                        case 3: // Hire Manager
                            if (capital > 2000) {
                                manager = Utility.hireManager();
                                employeeCount++;
                                capital -= 2000;
                            } else {
                                System.out.println("You don't have enough money to hire");
                            }
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }
                    break;

                case 2: // Fire Employee
                    System.out.println("1. Fire a Chef \n2. Fire a Waitress \n3. Go Back");
                    int fireChoice = sc.nextInt();
                    if (fireChoice == 1 && !chefs.isEmpty()) {
                        Utility.fireChef(chefs);
                        employeeCount--;
                    } else if (fireChoice == 2 && !waitresses.isEmpty()) {
                        Utility.fireWaitress(waitresses);
                        employeeCount--;
                    } else if (fireChoice == 3) {
                        break;
                    } else {
                        System.out.println("Invalid choice or no employees to fire.");
                    }
                    break;

                case 3: // Manage Staff
                    Utility.manageStaff(chefs, waitresses, manager);
                    break;

                case 4: // View Upgrades
                    capital = Utility.upgradeEmployee(chefs, waitresses, manager, sc, capital);
                    break;

                case 5: // View Restaurant Status
                    Utility.viewRestaurantStatus(hygiene, toolsCondition, stockCondition);
                    break;

                case 6: // Restaurant Maintenance
                    Utility.maintainRestaurant(hygiene, toolsCondition, stockCondition);
                    capital -= 500;
                    break;

                case 7: // End Month
                    int revenue = getRevenue.calculateRevenue(chefs, waitresses, manager, hygiene, toolsCondition, stockCondition);
                    revenue += Utility.triggerRandomEvent(); // Trigger random event that affects revenue
                    capital += revenue; // Add revenue to capital
                    if (capital < 0) {
                        System.out.println("** Game Over!**");
                        System.out.println("You ran out of funds after " + (currentMonth - 1) + " months.");
                        return;
                    } else if (revenue < targetRevenue) {
                        System.out.println("** Game Over!**");
                        System.out.println("You did not meet the target revenue of " + currencyFormat.format(targetRevenue) + " for month " + currentMonth + ".");
                        return;
                    }
                    currentMonth++; // Move to the next month
                    Utility.reduceRestaurantAttributes(hygiene, toolsCondition, stockCondition); // Reduce attributes over time
                    targetRevenue = getRevenue.getTargetRevenue(targetRevenue); // Update target revenue for the next month
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
