package tests;

import static org.junit.jupiter.api.Assertions.*;

import de.hbrs.team22.parkhaus_projekt.Sponsor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SponsorTest {


    Sponsor sponsor;

    @BeforeEach
    void setUp() {
        sponsor = new Sponsor("REWE",1000);
    }

    @Test
    void test() {
        assertEquals("REWE", sponsor.getName());
        assertEquals(1000, sponsor.getDonation());
    }

}
