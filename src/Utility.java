import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Utility {
    // Random number generator for various operations
    private static final Random random = new Random();
    // Scanner for user input
    private static final Scanner sc = new Scanner(System.in);

    // Method to hire a Chef
    public static Chef hireChef() {
        System.out.print("Enter the name of the Chef: ");
        String name = sc.next();
        int ability = random.nextInt(10) + 1; // Generate a random ability between 1 and 10
        Chef newChef = new Chef(name, ability);
        System.out.println("Hired a Chef named " + name + " with ability: " + ability);
        return newChef; // Return the newly hired Chef
    }

    // Method to hire a Waitress
    public static Waitress hireWaitress() {
        System.out.print("Enter the name of the Waitress: ");
        String name = sc.next();
        int ability = random.nextInt(10) + 1; // Generate a random ability between 1 and 10
        Waitress newWaitress = new Waitress(name, ability);
        System.out.println("Hired a Waitress named " + name + " with ability: " + ability);
        return newWaitress; // Return the newly hired Waitress
    }

    public static Manager hireManager(){
        System.out.println("Enter the name of the Manager: ");
        String name = sc.next();
        int exp = random.nextInt(10)+1;
        Manager newManager = new Manager(name, exp);
        System.out.println("Manager " + name + " with experience: " + exp);
        return newManager;
    }

    // Method to display and manage the current staff
    public static void manageStaff(ArrayList<Chef> chefs, ArrayList<Waitress> waitresses,Manager manager) {
        if (!chefs.isEmpty()) {
            System.out.println("Chefs:");
            for (Chef chef : chefs) {
                System.out.println("  - " + chef);
            }
        } else {
            System.out.println("No Chefs hired yet.");
        }

        if (!waitresses.isEmpty()) {
            System.out.println("Waitresses:");
            for (Waitress waitress : waitresses) {
                System.out.println("  - " + waitress);
            }
        } else {
            System.out.println("No Waitresses hired yet.");
        }
        if (manager != null) {
            System.out.println("Manager:");
            System.out.println("  - " + manager);
        } else {
            System.out.println("No Manager hired yet.");
        }
    }

    // Method to fire a Chef
    public static void fireChef(ArrayList<Chef> chefs) {
        System.out.println("Select a Chef to fire (enter 0 to cancel):");
        for (int i = 0; i < chefs.size(); i++) {
            System.out.println((i + 1) + ". " + chefs.get(i));
        }
        int choice = sc.nextInt();
        if (choice == 0) {
            System.out.println("Fire action canceled.");
            return; // Exit the method if the user chooses to cancel
        } else if (choice > 0 && choice <= chefs.size()) {
            System.out.println("Fired " + chefs.get(choice - 1));
            chefs.remove(choice - 1); // Remove the selected Chef from the list
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Method to fire a Waitress
    public static void fireWaitress(ArrayList<Waitress> waitresses) {
        System.out.println("Select a Waitress to fire (enter 0 to cancel):");
        for (int i = 0; i < waitresses.size(); i++) {
            System.out.println((i + 1) + ". " + waitresses.get(i));
        }
        int choice = sc.nextInt();
        if (choice == 0) {
            System.out.println("Fire action canceled.");
            return; // Exit the method if the user chooses to cancel
        } else if (choice > 0 && choice <= waitresses.size()) {
            System.out.println("Fired " + waitresses.get(choice - 1));
            waitresses.remove(choice - 1); // Remove the selected Waitress from the list
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Method to upgrade an employee's ability
    public static int upgradeEmployee(ArrayList<Chef> chefs, ArrayList<Waitress> waitresses, Manager manager, Scanner sc, int capital) {
        System.out.println("1. Upgrade Chef ($200 per level)");
        System.out.println("2. Upgrade Waitress ($100 per level)");
        System.out.println("3. Upgrade Manager ($500 per level)");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                if (!chefs.isEmpty() && capital >= 200) {
                    System.out.println("Select a Chef to upgrade:");
                    for (int i = 0; i < chefs.size(); i++) {
                        System.out.println((i + 1) + ". " + chefs.get(i));
                    }
                    int chefChoice = sc.nextInt();
                    if (chefChoice > 0 && chefChoice <= chefs.size()) {
                        Chef selectedChef = chefs.get(chefChoice - 1);
                        selectedChef.upgradeAbility(); // Upgrade the selected Chef's ability
                        System.out.println("Upgraded " + selectedChef.getName() + " to ability " + selectedChef.getAbility());
                        capital -= 200;
                    } else {
                        System.out.println("Invalid choice.");
                    }
                } else {
                    System.out.println("No Chefs available to upgrade or not enough capital.");
                }
                break;

            case 2:
                if (!waitresses.isEmpty() && capital >= 100) {
                    System.out.println("Select a Waitress to upgrade:");
                    for (int i = 0; i < waitresses.size(); i++) {
                        System.out.println((i + 1) + ". " + waitresses.get(i));
                    }
                    int waitressChoice = sc.nextInt();
                    if (waitressChoice > 0 && waitressChoice <= waitresses.size()) {
                        Waitress selectedWaitress = waitresses.get(waitressChoice - 1);
                        selectedWaitress.upgradeAbility(); // Upgrade the selected Waitress's ability
                        System.out.println("Upgraded " + selectedWaitress.getName() + " to ability " + selectedWaitress.getAbility());
                        capital -= 100;
                    } else {
                        System.out.println("Invalid choice.");
                    }
                } else {
                    System.out.println("No Waitresses available to upgrade or not enough capital.");
                }
                break;

            case 3:
                if (manager != null && capital >= 500) {
                    capital -= 500;
                    manager.increaseExp(); // Upgrade the selected Waitress's ability
                    System.out.println("Upgraded " + manager.getName() + " to ability " + manager.getExperience());
                } else {
                    System.out.println("No manager available to upgrade or not enough capital.");
                }
                break;

            default:
                System.out.println("Invalid option.");
        }
        return capital;
    }

    // Method to trigger a random event
    public static int triggerRandomEvent() {
        int chance = random.nextInt(100); // Generate a random number between 0 and 99
        if (chance < 60) { // 30% chance for a random event
            int eventIndex = random.nextInt(8); // Randomly select an event
            switch (eventIndex) {
                case 0:
                    System.out.println("A renowned food critic visited your restaurant and gave a rave review! Expect a surge in customers.");
                    return 500; // Positive event, increase revenue
                case 1:
                    System.out.println("A local festival is drawing more people to the area. Your restaurant is busier than usual!");
                    return 300; // Positive event, increase revenue
                case 2:
                    System.out.println("Your chef's special dish won a culinary award! The restaurant's fame is spreading.");
                    return 400; // Positive event, increase revenue
                case 3:
                    System.out.println("A corporate group booked the entire restaurant for an event. You made a significant profit!");
                    return 600; // Positive event, increase revenue
                case 4:
                    System.out.println("A health inspector found some minor issues. You received a fine, and some customers are wary.");
                    return -300; // Negative event, decrease revenue
                case 5:
                    System.out.println("An ingredient shortage has increased your costs. Revenue is lower this month.");
                    return -200; // Negative event, decrease revenue
                case 6:
                    System.out.println("One of your key employees is ill and unable to work. Operations are not as smooth as usual.");
                    return -250; // Negative event, decrease revenue
                case 7:
                    System.out.println("A crucial piece of kitchen equipment broke down. Repairs were costly, and efficiency is reduced.");
                    return -400; // Negative event, decrease revenue
                default:
                    return 0; // No event
            }
        }
        return 0; // No event occurs
    }
    public static void viewRestaurantStatus(Hygiene hygiene, ToolsCondition toolsCondition, StockCondition stockCondition) {
        System.out.println("Restaurant Status:");
        hygiene.view();
        toolsCondition.view();
        stockCondition.view();
    }
    public static void reduceRestaurantAttributes(Hygiene hygiene, ToolsCondition toolsCondition, StockCondition stockCondition) {
        hygiene.reduce();
        toolsCondition.reduce();
        stockCondition.reduce();
    }

    public static void maintainRestaurant(Hygiene hygiene, ToolsCondition toolsCondition, StockCondition stockCondition){
        System.out.println("Please choose attributes you want to update.");
        System.out.println("1. Clean Restaurant");
        System.out.println("2. Maintain tools");
        System.out.println("3. Update Stock");
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                hygiene.increase();
                break;
            case 2:
                toolsCondition.increase();
                break;
            case 3:
                stockCondition.increase();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
