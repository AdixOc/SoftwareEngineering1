import de.hbrs.team22.parkhaus_projekt.StatistikenGemeinsamkeiten;
import de.hbrs.team22.parkhaus_projekt.statistikKonkreteKlasse;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class StatistikenGemeinsamkeitenTest {
    double[] preisArray;
    double[] parkArray;
    @BeforeEach
    void setup() {
        preisArray = new double[] {4.0,6.5,10.5}; // Array mit den Preisen
        parkArray = new double[] {1.5,2.5,5.0}; // Array mit der Parkdauer (double Werte)
    }

    @AfterEach
    void teardown() { // teardown der beiden arrays in setup()
        preisArray = null;
        parkArray = null;
    }

    @org.junit.jupiter.api.Test
    void durchschnittMethode() {
        StatistikenGemeinsamkeiten s = new statistikKonkreteKlasse();
        s.statistikenBerechnen(preisArray,parkArray);
        assertEquals(7,s.durchschnittMethode(preisArray),"Der Durchschnitt der Preise wurde nicht richtig berechnet!");
        assertEquals(3,s.durchschnittMethode(parkArray), "Der Durchschnitt der Parkdauer wurde nicht richtig berechnet!");
    }

    @org.junit.jupiter.api.Test
    void summeMethode() {
        StatistikenGemeinsamkeiten s = new statistikKonkreteKlasse();
        s.statistikenBerechnen(preisArray,parkArray);
        assertEquals(21,s.summeMethode(preisArray),"Die Summe der gegebenen Preiswerten wurde nicht richtig berechnet!");
        assertEquals(9,s.summeMethode(parkArray),"Die Summe der gegebenen Parkdauerwerten wurde nicht richtig berechnet!");
    }
}