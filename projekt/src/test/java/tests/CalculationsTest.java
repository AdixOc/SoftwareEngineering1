package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import de.hbrs.team22.parkhaus_projekt.Calculations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculationsTest {

    ArrayList<Double> testPrices;
    ArrayList<Long> testDurations;
    ArrayList<Double> testEmptyListD;
    ArrayList<Long> testEmptyListL;

    ArrayList<Long> dates;
    ArrayList<Double> revenues;
    TreeMap<String,Double> monthlySum;

    double roundValueInEuro;

    @BeforeEach
    void setUp() throws Exception {

        testPrices = new ArrayList<>();
        testPrices.add(0.8);
        testPrices.add(1.0);

        testDurations = new ArrayList<>();
        testDurations.add(18L);
        testDurations.add(2L);

        roundValueInEuro = 12.236434535;

        dates = new ArrayList<>();
        revenues = new ArrayList<>();
        monthlySum = new TreeMap<>();

        dates.add(1609459200000l);
        dates.add(1609459200000l);
        dates.add(1612137600000l);
        dates.add(1614556800000l);

        revenues.add(2.0);
        revenues.add(2.0);
        revenues.add(3.0);
        revenues.add(4.0);

        monthlySum.put("2021 - 01", 4.0);
        monthlySum.put("2021 - 02", 3.0);
        monthlySum.put("2021 - 03", 4.0);
    }

    @Test
    void is_SUM_Double_correct() {
        assertEquals(1.8, Calculations.getDoubleSUM(testPrices),0.1);
    }

    @Test
    void is_AVG_Double_correct() {
        assertEquals(0.9,Calculations.getDoubleAVG(testPrices),0.1);
    }

    @Test
    void is_AVG_Long_correct() {
        assertEquals(10L,Calculations.getLongAVG(testDurations),0.1);
    }

    @Test
    void is_SUM_Long_correct() {
        assertEquals(20L,Calculations.getLongSUM(testDurations),0.1);
    }

    @Test
    void is_empty_lis_returning_zero_at_getLongSUM() {
        assertEquals(0,Calculations.getLongSUM(testEmptyListL),0.1);
    }

    @Test
    void is_empty_lis_returning_zero_at_getLongAVG() {
        assertEquals(0,Calculations.getLongAVG(testEmptyListL),0.1);
    }

    @Test
    void is_empty_lis_returning_zero_at_getDoubleAVG() {
        assertEquals(0,Calculations.getDoubleAVG(testEmptyListD),0.1);
    }

    @Test
    void is_empty_lis_returning_zero_at_getDoubleSUM() {
        assertEquals(0,Calculations.getDoubleSUM(testEmptyListD),0.1);
    }

    @Test
    void is_value_correct_rounded_and_euro() {
        assertEquals("12.24&#8364;",Calculations.getValueInEuro(roundValueInEuro));
    }

    @Test
    void is_Monthly_Sum_correct() {
        TreeMap<String,Double> tmp = Calculations.getMonthlySum(dates, revenues);
        boolean check = true;
        Iterator<String> it = tmp.keySet().iterator();
        while(it.hasNext()) {
            String tmpS = it.next();
            if(!(Double.compare(monthlySum.get(tmpS), tmp.get(tmpS)) == 0)) {
                check = false;
            }
        }
        assertTrue(check);

    }
}
