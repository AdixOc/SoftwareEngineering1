package tests;

import static org.junit.jupiter.api.Assertions.*;

import de.hbrs.team22.parkhaus_projekt.TaxOffice;
import org.junit.jupiter.api.Test;

class TaxOfficeTest {


    void test(double profit, double taxPercent) {
        assertEquals(profit*taxPercent, TaxOffice.taxCalculation(profit));
    }


    @Test
    void test_10() {
        test(10,0.05);
    }

    @Test
    void test_10_001() {
        test(10001, 0.19);
    }

    @Test
    void test_1_000_001() {
        test(1000001, 0.45);
    }

}
