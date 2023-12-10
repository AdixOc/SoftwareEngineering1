package de.hbrs.team22.parkhaus_projekt.commands;

import de.hbrs.team22.parkhaus_projekt.Fahrzeuge.Car;
import de.hbrs.team22.parkhaus_projekt.ParkhausLevel;
import de.hbrs.team22.parkhaus_projekt.service.ParkhausLevelService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarsCommandTest {

    static ParkhausLevelService parkhausLevelService = mock(ParkhausLevelService.class);

    @BeforeAll
    static void setUp() {
        var parkhauslevel = new ParkhausLevel("test", 1, 1);
        parkhauslevel.enter(new Car());
        ArrayList<ParkhausLevel> levels = new ArrayList<ParkhausLevel>(){{
            add(parkhauslevel);
        }};
        when(parkhausLevelService.getLevels()).thenReturn(levels);
    }

    @Test
    void execute() {
        var soos = new CarsCommand(parkhausLevelService).execute();
        assertEquals("test: 1\n" +
                "Car: 0\n" +
                "\n", soos);
    }
}