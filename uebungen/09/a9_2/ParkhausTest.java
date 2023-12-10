package tests;

import de.hbrs.team22.parkhaus_projekt.Parkhaus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkhausTest {

    @Test
    void testAddLevel(){
        Parkhaus p = new Parkhaus();
        p.addLevel("level1", 10, 10.0);
        assertEquals(1, p.getLevels().size());
        assertEquals("level1", p.getLevels().get(0).getName());
    }

    @Test
    void testRemoveLevel(){
        Parkhaus p = new Parkhaus();
        p.addLevel("level1", 10, 10.0);
        assertEquals(1, p.getLevels().size());
        assertEquals("level1", p.getLevels().get(0).getName());
        p.removeLevel(p.getLevels().get(0));
        assertEquals(0, p.getLevels().size());
    }

    @Test
    void testLevelPresentByName(){
        Parkhaus p = new Parkhaus();
        p.addLevel("level1", 10, 10.0);
        assertTrue(p.isLevelPresentByName("level1"));
        assertFalse(p.isLevelPresentByName("level2"));
    }

    @Test
    void testGetLevelByName(){
        Parkhaus p = new Parkhaus();
        p.addLevel("level1", 10, 10.0);
        assertEquals("level1", p.getLevelByName("level1").getName());
        assertNull(p.getLevelByName("level2"));
    }

}