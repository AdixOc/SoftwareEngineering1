package de.hbrs.team22.parkhaus_projekt.commands;

import de.hbrs.team22.parkhaus_projekt.ParkhausLevel;
import de.hbrs.team22.parkhaus_projekt.service.ParkhausLevelService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AvgCommandTest {

    static ParkhausLevelService mockPLService = mock(ParkhausLevelService.class);

    @BeforeAll
    static void mockMethods(){
        var parkhauslevel = new ParkhausLevel("test", 1, 1);
        ArrayList<ParkhausLevel> levels = new ArrayList<ParkhausLevel>(){{
            add(parkhauslevel);
        }};
        when(mockPLService.getLevels()).thenReturn(levels);
    }
    @Test
    void execute() {
        var soos = new AvgCommand(mockPLService).execute();
        assertEquals("1.0", soos);
    }
}