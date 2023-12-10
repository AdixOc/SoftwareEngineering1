package de.hbrs.team22.parkhaus_projekt;

public class TaxOffice {

    /**
     * Simple Tax Calculation
     * @param unternehmensGewinn
     * @return
     */
    public static double taxCalculation(double unternehmensGewinn) {
        if(unternehmensGewinn > 10000 && unternehmensGewinn < 1000000) {
            return Math.round((unternehmensGewinn * 0.19)*100.0)/100.0;
        } else if(unternehmensGewinn > 1_000_000) {
            return Math.round((unternehmensGewinn * 0.45)*100.0)/100.0;
        } else {
            return Math.round((unternehmensGewinn * 0.05)*100.0)/100.0;
        }
    }
}
