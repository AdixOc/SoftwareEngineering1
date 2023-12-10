package tests;

import static org.junit.jupiter.api.Assertions.*;

import de.hbrs.team22.parkhaus_projekt.Bankaccount;
import de.hbrs.team22.parkhaus_projekt.Calculations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankaccountTest {

    Bankaccount account;

    @BeforeEach
    void setUp() throws Exception {
        account = new Bankaccount();
    }


    @Test
    void testStart() {
        assertEquals(0,account.getSaldo());
    }


    @Test
    void testTransfer() {
        account.charge(200,"","");
        account.transfer(300,"","");
        assertEquals(-100,account.getSaldo());
    }


    @Test
    void testLog() {
        account.charge(200,"","");
        account.transfer(300,"","");
        assertEquals(" - Es wurden "+ Calculations.getValueInEuro(300)+" an  berwiesen. ", account.getTransferLog().get(0));
        assertEquals(" - Ihrem Konto wurden "+Calculations.getValueInEuro(200)+" von  gutgeschrieben. ", account.getTransferLog().get(1));
    }

}
