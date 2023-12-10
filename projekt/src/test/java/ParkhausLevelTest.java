import com.google.gson.Gson;
import de.hbrs.team22.parkhaus_projekt.Fahrzeuge.Car;
import de.hbrs.team22.parkhaus_projekt.Parkhaus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkhausLevelTest {
    Parkhaus parkhaus;
    Gson gson = new Gson();

    String testCar = "{\n" +
            "  \"nr\": 10,\n" +
            "  \"timer\": 1656430022808,\n" +
            "  \"duration\": 0,\n" +
            "  \"price\": 0,\n" +
            "  \"hash\": \"fc2c04c23e1fd4c7e35e7a6e26386ebc\",\n" +
            "  \"color\": \"#982b5c\",\n" +
            "  \"space\": 1,\n" +
            "  \"client_category\": \"Frau\",\n" +
            "  \"vehicle_type\": \"PKW\",\n" +
            "  \"license\": \"SU-E 15\",\n" +
            "  \"begin\": 1656430022808\n" +
            "}";

    @BeforeEach
    void setUp() {
        this.parkhaus = new Parkhaus();
        parkhaus.addLevel("level1", 10, 10.0);
    }

    @Test
    void testGetFreePlaces() {
        assertEquals(10, parkhaus.getLevelByName("level1").getFreePlaces());
        parkhaus.getLevelByName("level1").enter(gson.fromJson(testCar, Car.class));
        assertEquals(9, parkhaus.getLevelByName("level1").getFreePlaces());
    }

    @Test
    void getOccupiedPlaces() {
        assertEquals(0, parkhaus.getLevelByName("level1").getOccupiedPlaces());
        parkhaus.getLevelByName("level1").enter(gson.fromJson(testCar, Car.class));
        assertEquals(1, parkhaus.getLevelByName("level1").getOccupiedPlaces());
    }

    @Test
    void testAddCar() {
        assertEquals(0, parkhaus.getLevelByName("level1").getOccupiedPlaces());
        parkhaus.getLevelByName("level1").enter(gson.fromJson(testCar, Car.class));
        assertEquals(1, parkhaus.getLevelByName("level1").getOccupiedPlaces());
    }

    @Test
    void testRemoveCar() {
        Car car = gson.fromJson(testCar, Car.class);
        assertEquals(0, parkhaus.getLevelByName("level1").getOccupiedPlaces());
        parkhaus.getLevelByName("level1").enter(car);
        assertEquals(1, parkhaus.getLevelByName("level1").getOccupiedPlaces());
        parkhaus.getLevelByName("level1").leave(car);
        assertEquals(0, parkhaus.getLevelByName("level1").getOccupiedPlaces());
    }
}
