import java.util.ArrayList;
import java.util.List;

public class VacationCalculator {

    public static void main(String[] args) {

        VacationCalculator vc = new VacationCalculator();

        // Calculate some vacation costs...
        float japanCost = vc.calculateVacationCost(Destination.Japan, 5);
        float mexicoCost = vc.calculateVacationCost(Destination.Mexico, 3);
        float europeCost = vc.calculateVacationCost(Destination.Europe, 7);

        // Print the cost...
        System.out.println(String.format("Total cost for trip to Japan: $%.2f%n", japanCost));
        System.out.println(String.format("Total cost for trip to Mexico: $%.2f%n", mexicoCost));
        System.out.println(String.format("Total cost for trip to Europe: $%.2f%n", europeCost));
    }

    /**
     * Calculates the total cost for vacationing at a given location for 
     * a specific number of nights.
     *
     * @param  dest the destination of the vacation
     * @return      the total cost of the vacation
     */
    public float calculateVacationCost(Destination dest, int totalNights)
    {
        List<Expense> itenerary = new ArrayList<Expense>();

        itenerary.add(new Cruise(dest));
        itenerary.add(new Dining(dest, totalNights));
        itenerary.add(new Lodging(dest, totalNights));
        float totalCost = tallyExpenses(itenerary);
        return totalCost;
    }

    /**
     * An internal method used by VacationCalculator to loop through
     * a List of items that implement the Expense interface and 
     * determine their cost 
     *
     * @param  expenses A list of items that implement the Expense interface
     * @return          the total cost calculated by the items
     */
    float tallyExpenses(List<Expense> expenses)
    {
        float totalCost = 0;

        for(Expense e : expenses)
            totalCost += e.getCost();

        return totalCost;
    }
}