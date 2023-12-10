package de.hbrs.team22.parkhaus_projekt;

public class Sponsor {

    //Declaration
    private final String name;
    private final double donation;

    /**
     * Initialization
     * @param name
     * @param donation
     */
    public Sponsor(String name,double donation) {
        this.name = name;
        this.donation = donation;
    }

    /**
     * Getter of name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of donation
     * @return
     */
    public double getDonation() {
        return donation;
    }
}
