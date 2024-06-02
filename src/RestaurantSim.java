import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantSim {
    private static final int STARTING_CAPITAL = 750;
    private static final int BASE_TARGET_REVENUE = 750;
    private static final Scanner sc = new Scanner(System.in);
    private static final DecimalFormat currencyFormat = new DecimalFormat("$#,##0.00");

    public static void main(String[] args) {
        int currentMonth = 1;
        int capital = STARTING_CAPITAL;
        double targetRevenue = BASE_TARGET_REVENUE;
        int employeeCount = 0;

        ArrayList<Chef> chefs = new ArrayList<>();
        ArrayList<Waitress> waitresses = new ArrayList<>();
        Manager manager = null;

        Hygiene hygiene = new Hygiene();
        ToolsCondition toolsCondition = new ToolsCondition();
        StockCondition stockCondition = new StockCondition();

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
                case 1:
                    System.out.println("1. Hire Chef $250\n2. Hire Waitress $150\n3. Hire Manager $2000");
                    System.out.println("\nPlease input your action:");
                    int hiring = sc.nextInt();

                    switch (hiring) {
                        case 1:
                            if (capital > 250) {
                                chefs.add(Utility.hireChef());
                                employeeCount++;
                                capital -= 250;
                            }
                            else {
                                System.out.println("You dont have enough money to hire");
                            }
                            break;

                        case 2:
                            if (capital > 150){
                            waitresses.add(Utility.hireWaitress());
                            employeeCount++;
                            capital -= 150;
                            }
                            else {
                                System.out.println("You dont have enough money to hire");
                            }
                            break;

                        case 3:
                            if (capital > 2000){
                            manager = Utility.hireManager();
                            employeeCount++;
                            capital -= 2000;}
                            else {
                                System.out.println("You dont have enough money to hire");
                            }
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }
                    break;

                case 2:
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

                case 3:
                    Utility.manageStaff(chefs, waitresses, manager);
                    break;

                case 4:
                    capital = Utility.upgradeEmployee(chefs, waitresses, manager, sc, capital);
                    break;

                case 5:
                    Utility.viewRestaurantStatus(hygiene, toolsCondition, stockCondition);
                    break;

                case 6:
                    Utility.maintainRestaurant(hygiene, toolsCondition, stockCondition);
                    capital -= 500;
                    break;

                case 7:
                    int revenue = getRevenue.calculateRevenue(chefs, waitresses, manager, hygiene, toolsCondition, stockCondition);
                    revenue += Utility.triggerRandomEvent();
                    capital += revenue;
                    if (capital < 0) {
                        System.out.println("** Game Over!**");
                        System.out.println("You ran out of funds after " + (currentMonth - 1) + " months.");
                        return;
                    } else if (revenue < targetRevenue) {
                        System.out.println("** Game Over!**");
                        System.out.println("You did not meet the target revenue of " + currencyFormat.format(targetRevenue) + " for month " + currentMonth + ".");
                        return;
                    }
                    currentMonth++;
                    Utility.reduceRestaurantAttributes(hygiene, toolsCondition, stockCondition);
                    targetRevenue = getRevenue.getTargetRevenue(targetRevenue);
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
