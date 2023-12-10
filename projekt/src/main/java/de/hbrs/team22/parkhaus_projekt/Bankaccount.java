package de.hbrs.team22.parkhaus_projekt;

import java.util.ArrayList;
import java.util.Collections;

public class Bankaccount{

    //Declaration
    private double account;
    private final ArrayList<String> transferLog;
    static String TRANSFERFORMAT = "yyyy - MM - dd";
    static String MONTHFORMAT = "yyyy - MM";


    /**
     * Constructor / Initialization
     */
    public Bankaccount(){
        account = 0;
        transferLog = new ArrayList<>();
    }

    /**
     * Method for transfering money
    // * @param betrag
     */
    public void transfer(double value,String recipient, String date){
        account -= value;
        addTransfer(value,"-",recipient , date);
    }

    /**
     * Method for transfering money to bank account
     //* @param betrag
    // * @param sender
     //* @param date
     */
    public void charge(double value, String sender, String date){
        if(value > 0) {
            account += value;
            addTransfer(value,"",sender, date);
        }

    }

    /**
     * Method for logging transfers
     //* @param betrag
     //* @param operator
     //* @param name
     //* @param date
     */
    private void addTransfer(double value,String operator,String name, String date) {
        if(operator.equals("-")) {
            transferLog.add(date +" - Es wurden "+Calculations.getValueInEuro(value)+" an "+name+" ueberwiesen. ");
        } else {
            transferLog.add(date +" - Ihrem Konto wurden "+Calculations.getValueInEuro(value)+" von "+name+" gutgeschrieben. ");
        }
    }

    /**
     * Getter of account amount
     * @return
     */
    public double getSaldo() {
        return account;
    }


    /**
     * Getter of transfer log
     * @return
     */
    public ArrayList<String> getTransferLog() {
        Collections.sort(transferLog);
        return transferLog;
    }
}
