import java.text.DecimalFormat;
import java.util.ArrayList;

public class getRevenue {
    private static final double TARGET_REVENUE_GROWTH_RATE = 1.3; // Growth rate for target revenue (30% increase each month)
    private static final int CHEF_SALARY = 100; // Salary for a chef
    private static final int WAITRESS_SALARY = 50; // Salary for a waitress
    private static final int MANAGER_SALARY = 500; // Salary for a manager
    private static final DecimalFormat currencyFormat = new DecimalFormat("$#,##0.00"); // Format for currency display

    // Method to calculate the target revenue for the next month
    public static double getTargetRevenue(double currentTargetRevenue) {
        return currentTargetRevenue * TARGET_REVENUE_GROWTH_RATE; // Increase by 30% each month
    }

    // Method to calculate the total revenue and net profit for the current month
    public static int calculateRevenue(ArrayList<Chef> chefs, ArrayList<Waitress> waitresses, Manager manager,
                                       Hygiene hygiene, ToolsCondition toolsCondition, StockCondition stockCondition) {
        int baseRevenue = 500; // Base revenue for the restaurant

        // Calculate bonuses based on the performance of chefs and waitresses
        int chefBonus = chefs.stream().mapToInt(Chef::performanceContribution).sum();
        int waitressBonus = waitresses.stream().mapToInt(Waitress::performanceContribution).sum();

        // Calculate penalty based on the status of hygiene, tools, and stock
        double penalty = 0;
        if (hygiene.isBelowThreshold()) penalty += 0.1;
        if (toolsCondition.isBelowThreshold()) penalty += 0.1;
        if (stockCondition.isBelowThreshold()) penalty += 0.1;

        // Calculate total revenue after considering bonuses and penalties
        double totalRevenue = (baseRevenue + chefBonus + waitressBonus)*(manager != null ? manager.getBonusMultiplier():1);
        totalRevenue *= (1 - penalty);

        // Display total revenue for the month
        System.out.println("Total revenue for the month: " + currencyFormat.format(totalRevenue));

        // Calculate total salaries for chefs, waitresses, and the manager
        int chefSalaries = chefs.size() * CHEF_SALARY;
        int waitressSalaries = waitresses.size() * WAITRESS_SALARY;
        int managerSalaries = (manager != null) ? MANAGER_SALARY : 0;
        int totalSalaries = chefSalaries + waitressSalaries + managerSalaries;

        // Calculate net profit after deducting total salaries from total revenue
        int netProfit = (int) (totalRevenue - totalSalaries);

        // Display total salaries and net profit for the month
        System.out.println("Total salaries for the month: " + currencyFormat.format(totalSalaries));
        System.out.println("Net profit for the month: " + currencyFormat.format(netProfit));

        // Return the net profit for the month
        return netProfit;
    }
}
