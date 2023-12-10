package de.hbrs.team22.parkhaus_projekt;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "level2Servlet", value = "/level2-servlet")
public class Level2Servlet extends ParkhausServlet {
    public Level2Servlet() {
        super();
    }

    @Override
    String NAME() {
        return "Level2";
    }

    @Override
    int MAXSSLOTS() { // maximum number of parking slots on level 2
        return 14;
    }

    @Override
    String config() {
        return "14,0,24,100,10"; // use new config
        // Config Format is "Max, open_from, open_to, delay, simulation_speed"
        // e.g. return this.MAX() + ",0,24,100,10";  // TODO replace by your own parameters
    }

    @Override
    double price() {
        return 3.0;
    }


}