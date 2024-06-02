import java.text.DecimalFormat;
import java.util.ArrayList;

public class getRevenue{
    private static final double TARGET_REVENUE_GROWTH_RATE = 1.3; // 30% increase each month
    private static final int CHEF_SALARY = 100;
    private static final int WAITRESS_SALARY = 50;
    private static final int MANAGER_SALARY = 500;
    private static final DecimalFormat currencyFormat = new DecimalFormat("$#,##0.00");

public static double getTargetRevenue(double currentTargetRevenue) {
    return currentTargetRevenue * TARGET_REVENUE_GROWTH_RATE; // Increase by 30% each month
}

public static int calculateRevenue(ArrayList<Chef> chefs, ArrayList<Waitress> waitresses,Manager manager, Hygiene hygiene, ToolsCondition toolsCondition, StockCondition stockCondition) {
    int baseRevenue = 500; // Example base revenue
    int chefBonus = chefs.stream().mapToInt(Chef::performanceContribution).sum(); // Sum of bonuses based on Chef abilities
    int waitressBonus = waitresses.stream().mapToInt(Waitress::performanceContribution).sum(); // Sum of bonuses based on Waitress abilities

    double penalty = 0;
    if (hygiene.isBelowThreshold()) penalty += 0.1;
    if (toolsCondition.isBelowThreshold()) penalty += 0.1;
    if (stockCondition.isBelowThreshold()) penalty += 0.1;

    int totalRevenue = baseRevenue + chefBonus + waitressBonus;
    totalRevenue *= (1 - penalty);
    System.out.println("Total revenue for the month: " + currencyFormat.format(totalRevenue));

    int chefSalaries = chefs.size() * CHEF_SALARY;
    int waitressSalaries = waitresses.size() * WAITRESS_SALARY;
    int managerSalaries = (manager != null) ? MANAGER_SALARY : 0;
    int totalSalaries = chefSalaries + waitressSalaries + managerSalaries;

    int netProfit = totalRevenue - totalSalaries;
    System.out.println("Total salaries for the month: " + currencyFormat.format(totalSalaries));
    System.out.println("Net profit for the month: " + currencyFormat.format(netProfit));
    return netProfit;
}
}