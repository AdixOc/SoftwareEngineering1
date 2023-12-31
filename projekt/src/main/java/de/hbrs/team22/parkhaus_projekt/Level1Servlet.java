package de.hbrs.team22.parkhaus_projekt;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "level1Servlet", value = "/level1-servlet")
public class Level1Servlet extends ParkhausServlet {
    public Level1Servlet() {
        super();
    }
    @Override
    String NAME() {
        return "Level1";
    }

    @Override
    int MAXSSLOTS() { // maximum number of parking slots on level 1
        return 11;
    }

    @Override
    String config() {
        return ""; // use default config
        // Config Format is "Max, open_from, open_to, delay, simulation_speed"
        // e.g. return this.MAX() + ",5,23,100,10";  // TODO replace by your own parameters
    }

    @Override
    double price() {
        return 2.50;
    }


}