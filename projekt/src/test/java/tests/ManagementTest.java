package tests;

import de.hbrs.team22.parkhaus_projekt.Bankaccount;
import de.hbrs.team22.parkhaus_projekt.Management;
import de.hbrs.team22.parkhaus_projekt.Sponsor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ManagementTest {

    Management v;

    @BeforeEach
    void setUp() {
        v = new Management();
    }

    @Test
    void test_returned_sponsor_list() {
        assertTrue(v.getSponsorsList().isEmpty());

    }

    @Test
    void test_getSponsorList() {
        v.getSponsorsList().add(new Sponsor("Hans", 10));
        assertTrue(v.getSponsorsList().get(0).getClass().getSimpleName().equals("Sponsor"));
    }

    @Test
    void test_getKonto() {
        assertTrue(v.getKonto().getClass() == Bankaccount.class);
    }

}
