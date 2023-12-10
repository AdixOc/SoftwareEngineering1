package de.hbrs.team22.parkhaus_projekt.service;

import de.hbrs.team22.parkhaus_projekt.Fahrzeuge.Car;
import de.hbrs.team22.parkhaus_projekt.Level1Servlet;
import de.hbrs.team22.parkhaus_projekt.Parkhaus;
import de.hbrs.team22.parkhaus_projekt.ParkhausLevel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletContext;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ParkhausLevelServiceTest {

    static Level1Servlet level1Servlet = mock(Level1Servlet.class);
    static ServletContext servletContext = mock(ServletContext.class);
    static ParkhausLevelService parkhausLevelService = new ParkhausLevelService(level1Servlet);

    @BeforeAll
    static void configureMock() {
        when(level1Servlet.getContext()).thenReturn(servletContext);

    }


    @Test
    void addCar() {
        when(servletContext.getAttribute("carsTestlevel1")).thenReturn(new ArrayList<Car>());
        when(servletContext.getAttribute("Parkhaus")).thenReturn(new Parkhaus());

        Parkhaus parkhaus = (Parkhaus) servletContext.getAttribute("Parkhaus");
        doNothing().when(servletContext).setAttribute("carsTestlevel1", parkhaus);

        parkhaus.addLevel("Testlevel1", 1, 1);
        parkhaus.addLevel(new ParkhausLevel("carsTestlevel1", 1, 1));
        parkhausLevelService.addCar("carsTestlevel1", new Car());

        assertEquals(1, parkhaus.getLevelByName("carsTestlevel1").getCars().size());

    }

}