
package simulationpart2;

/**
 *
 * @author Karim
 */


//Static Class to Calculate Lead, Demand and Populate the Probability tables.
public final class Probability_Table {

    static int[] Demand = new int[]{0, 1, 2, 3, 4};
    static double[] Demand_Prob = new double[]{0.1, 0.25, 0.35, 0.21, 0.09};
    static double[] Demand_Cumiliative = new double[Demand_Prob.length];

    static int[] Lead = new int[]{1, 2, 3};
    static double[] Lead_Prob = new double[]{0.6, 0.3, 0.1};
    static double[] Lead_Cumiliative = new double[Lead_Prob.length];

    public static int CalculateDemand(int RandomVariable) {
        CalculateCumiliative();
        //Checks if RV is between 2 ranges.
        if (RandomVariable >= 0 && RandomVariable <= Demand_Cumiliative[0] * 100) {
            return Demand[0];
        }
        
        for (int i = 1; i < Demand_Prob.length; i++) {
            if (RandomVariable > Demand_Cumiliative[i - 1] * 100 && RandomVariable <= Demand_Cumiliative[i] * 100) {
                return Demand[i];
            }
        }

        return -1;
    }

    public static int CalculateLead(int RandomVariable) {
        CalculateCumiliative();
        //Checks if RV is between 2 Ranges.
        if (RandomVariable >= 0 && RandomVariable < Lead_Cumiliative[0] * 100) {
            return Lead[0];
        }

        for (int i = 1; i < Lead_Prob.length; i++) {
            if (RandomVariable > Lead_Cumiliative[i - 1] * 100 && RandomVariable < Lead_Cumiliative[i] * 100) {
                return Lead[i];
            }
        }

        return -1;
    }

    private static void CalculateCumiliative() {
        Demand_Cumiliative[0] = Demand_Prob[0];
        Lead_Cumiliative[0] = Lead_Prob[0];

        for (int i = 1; i < Demand_Prob.length; i++) {
            Demand_Cumiliative[i] = Demand_Prob[i] + Demand_Cumiliative[i - 1];
        }

        for (int i = 1; i < Lead_Prob.length; i++) {
            Lead_Cumiliative[i] = Lead_Prob[i] + Lead_Cumiliative[i - 1];
        }
    }

    public static int[] getDemand() {
        return Demand;
    }

    public static void setDemand(int[] Demand) {
        Probability_Table.Demand = Demand;
    }

    public static double[] getDemand_Prob() {
        return Demand_Prob;
    }

    public static void setDemand_Prob(double[] Demand_Prob) {
        Probability_Table.Demand_Prob = Demand_Prob;
    }

    public static double[] getDemand_Cumiliative() {
        return Demand_Cumiliative;
    }

    public static void setDemand_Cumiliative(double[] Demand_Cumiliative) {
        Probability_Table.Demand_Cumiliative = Demand_Cumiliative;
    }

    public static int[] getLead() {
        return Lead;
    }

    public static void setLead(int[] Lead) {
        Probability_Table.Lead = Lead;
    }

    public static double[] getLead_Prob() {
        return Lead_Prob;
    }

    public static void setLead_Prob(double[] Lead_Prob) {
        Probability_Table.Lead_Prob = Lead_Prob;
    }

    public static double[] getLead_Cumiliative() {
        return Lead_Cumiliative;
    }

    public static void setLead_Cumiliative(double[] Lead_Cumiliative) {
        Probability_Table.Lead_Cumiliative = Lead_Cumiliative;
    }

}
