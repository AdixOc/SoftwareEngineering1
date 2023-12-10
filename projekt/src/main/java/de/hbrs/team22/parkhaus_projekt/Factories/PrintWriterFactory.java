package de.hbrs.team22.parkhaus_projekt.Factories;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterFactory {
    public static PrintWriter create(HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (out == null) {
            System.out.println("PrintWriter is null this should not happen!");
            System.exit(1);
        }

        return out;
    }
}
