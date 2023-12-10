package tests;

import de.hbrs.team22.parkhaus_projekt.Car;
import de.hbrs.team22.parkhaus_projekt.Parkhaus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkhausLevelTest {
    Parkhaus parkhaus;

    @BeforeEach
    void setUp() {
        this.parkhaus = new Parkhaus();
        parkhaus.addLevel("level1", 10, 10.0);
    }

    @Test
    void testGetFreePlaces() {
        assertEquals(10, parkhaus.getLevelByName("level1").getFreePlaces());
        parkhaus.getLevelByName("level1").enter(new Car(new String[]{"car1"}));
        assertEquals(9, parkhaus.getLevelByName("level1").getFreePlaces());
    }

    @Test
    void getOccupiedPlaces() {
        assertEquals(0, parkhaus.getLevelByName("level1").getOccupiedPlaces());
        parkhaus.getLevelByName("level1").enter(new Car(new String[]{"car1"}));
        assertEquals(1, parkhaus.getLevelByName("level1").getOccupiedPlaces());
    }

    @Test
    void testAddCar() {
        assertEquals(0, parkhaus.getLevelByName("level1").getOccupiedPlaces());
        parkhaus.getLevelByName("level1").enter(new Car(new String[]{"car1"}));
        assertEquals(1, parkhaus.getLevelByName("level1").getOccupiedPlaces());
    }

    @Test
    void testRemoveCar() {
        Car car = new Car(new String[]{"car1"});
        assertEquals(0, parkhaus.getLevelByName("level1").getOccupiedPlaces());
        parkhaus.getLevelByName("level1").enter(car);
        assertEquals(1, parkhaus.getLevelByName("level1").getOccupiedPlaces());
        parkhaus.getLevelByName("level1").leave(car);
        assertEquals(0, parkhaus.getLevelByName("level1").getOccupiedPlaces());
    }
}
