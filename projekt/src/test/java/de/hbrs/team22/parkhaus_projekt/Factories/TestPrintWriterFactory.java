package de.hbrs.team22.parkhaus_projekt.Factories;

import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TestPrintWriterFactory {
    @Test
    void test() {
        var response = mock(HttpServletResponse.class);
        try{
            when(response.getWriter()).thenReturn(new PrintWriter(System.out));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        var out = PrintWriterFactory.create(response);
        assertTrue(out instanceof PrintWriter);
        assertNotNull(out);
    }
}
