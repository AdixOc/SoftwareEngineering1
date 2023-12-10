import de.hbrs.team22.parkhaus_projekt.Parkhaus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkhausTest {

    String l1; // Instead of using the literal "level1" 9 times

    @BeforeEach
    void setUp() {
        l1 = "level1";
    }


    @Test
    void testAddLevel(){
        Parkhaus p = new Parkhaus();
        p.addLevel(l1, 10, 10.0);
        assertEquals(1, p.getLevels().size());
        assertEquals(l1, p.getLevels().get(0).getName());
    }

    @Test
    void testRemoveLevel(){
        Parkhaus p = new Parkhaus();
        p.addLevel(l1, 10, 10.0);
        assertEquals(1, p.getLevels().size());
        assertEquals(l1, p.getLevels().get(0).getName());
        p.removeLevel(p.getLevels().get(0));
        assertEquals(0, p.getLevels().size());
    }

    @Test
    void testLevelPresentByName(){
        Parkhaus p = new Parkhaus();
        p.addLevel(l1, 10, 10.0);
        assertTrue(p.isLevelPresentByName(l1));
    }

    @Test
    void testGetLevelByName(){
        Parkhaus p = new Parkhaus();
        p.addLevel(l1, 10, 10.0);
        assertEquals(l1, p.getLevelByName(l1).getName());
    }

}