package de.hbrs.team22.parkhaus_projekt;

import java.util.ArrayList;

public class Management {

    //Declaration
    private final ArrayList<Sponsor> sponsorsList;
    private final Bankaccount uK;

    /**
     * Constructor / Initialization
     *
     */
    public Management() {
        sponsorsList = new ArrayList<>();
        uK = new Bankaccount();
    }

    /**
     * Getter of bank account
     * @return
     */
    public Bankaccount getKonto() {
        return uK;
    }

    /**
     * Getter of investor list
     * @return
     */
    public ArrayList<Sponsor> getSponsorsList() {
        return sponsorsList;
    }




}
