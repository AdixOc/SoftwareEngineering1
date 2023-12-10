package de.hbrs.team22.parkhaus_projekt;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import de.hbrs.team22.parkhaus_projekt.Factories.PrintWriterFactory;
import de.hbrs.team22.parkhaus_projekt.Fahrzeuge.Car;
import de.hbrs.team22.parkhaus_projekt.Fahrzeuge.CarIF;
import de.hbrs.team22.parkhaus_projekt.commands.*;
import de.hbrs.team22.parkhaus_projekt.service.ParkhausLevelService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * common superclass for all servlets
 * groups all auxiliary common methods used in all servlets
 */
public abstract class ParkhausServlet extends HttpServlet {

    final ParkhausLevelService parkhausLevelService;

    public ParkhausServlet() {
        super();
        parkhausLevelService = new ParkhausLevelService(this);
    }


    /* abstract methods, to be defined in subclasses */
    abstract String NAME(); // each ParkhausServlet should have a name, e.g. "Level1"

    abstract int MAXSSLOTS(); // maximum number of parking slots of a single parking level

    abstract String config(); // configuration of a single parking level

    abstract double price(); // price of parking slot

    /**
     * HTTP GET
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = PrintWriterFactory.create(response);
        String cmd = request.getParameter("cmd");
        System.out.println(cmd + " requested: " + request.getQueryString());
        switch (cmd) {
            case "config":
                // Overwrite Parkhaus config parameters
                // Max, open_from, open_to, delay, simulation_speed
                out.println(new ConfigCommand().execute());
                break;
            case "sum":
                // Sum of all parking slots
                out.println(new SumCommand(parkhausLevelService).execute());
                break;
            case "avg":
                out.println("avg = " + new AvgCommand(parkhausLevelService).execute());
                break;
            case "anzahlBusiness":
                out.println("count Biz = " + parkhausLevelService.getBusiness(NAME()));
                break;
            case "min":
                // ToDo: insert algorithm for calculating min here
                out.println("min = server side calculated min");
                break;
            case "max":
                // ToDo: insert algorithm for calculating max here
                out.println("max = server side calculated max");
                break;
            case "cars":
                // TODO: Send list of cars stored on the server to the client.
                // Cars are separated by comma.
                // Values of a single car are separated by slash.
                // Format: Nr, timer begin, duration, price, Ticket, color,
                // space, client category, vehicle type, license (PKW Kennzeichen)
                // For example:
                // TODO replace by real list of cars
                out.println(new CarsCommand(parkhausLevelService).execute());
                break;
            case "chart":
                // TODO send chart infos as JSON object to client
                out.println(new ChartDataCommand(parkhausLevelService).execute());
                break;
            default:
                System.out.println("Invalid Command: " + request.getQueryString());
        }

    }

    /**
     * HTTP POST
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        parkhausLevelService.createParkhausLevelIfNotExists(NAME(), MAXSSLOTS(), price());
        String body = null;
        try {
            body = getBody(request);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        response.setContentType("text/html");
        PrintWriter out = PrintWriterFactory.create(response);
        System.out.println(body);
        Gson gson = new Gson();
        String[] params = body.split(",");
        // Nimm die Parameter aus dem Request und verwende diese zum erstellen eines neuen DTOs.
        body = body.substring(params[0].length() + 1);
        Car newCar = null;
        try{
            newCar = gson.fromJson(body, Car.class);
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e.getMessage() + "\n" + body);
        }
        // Check welches DTO wir brauchen
        switch (params[0]) {
            case "enter":
                try {
                    parkhausLevelService.addCar(NAME(), newCar);
                } catch (IllegalStateException ex) {
                    out.println(ex.getMessage());
                    break;
                }
                out.println(locator(newCar));
                break;
            case "leave":
                var oldCar = parkhausLevelService.removeCar(NAME(), newCar);
                out.println(oldCar.getPrice());  // server calculated price
                System.out.println("leave," + oldCar + ", price = " + oldCar.getPrice());
                break;
            case "tomcat":
                out.println(getServletConfig().getServletContext().getServerInfo()
                        + getServletConfig().getServletContext().getMajorVersion()
                        + getServletConfig().getServletContext().getMinorVersion());
                break;
            default:
                System.out.println(body);
        }

    }
    // auxiliary methods used in HTTP request processing

    /**
     * @return the servlet context
     */
    public ServletContext getContext() {
        return getServletConfig().getServletContext();
    }

    /**
     * TODO: replace this by your own function
     *
     * @return the number of the free parking lot to which the next incoming car will be directed
     */
    int locator(CarIF car) {
        // numbers of parking lots start at 1, not zero
        // return 1;  // always use the first space
        return 1 + ((cars().size() - 1) % this.MAXSSLOTS());
    }

    /**
     * @return the list of all cars stored in the servlet context so far
     */
    @SuppressWarnings("unchecked")
    List<CarIF> cars() {
        if (getContext().getAttribute("cars" + NAME()) == null) {
            getContext().setAttribute("cars" + NAME(), new ArrayList<Car>());
        }
        return (List<CarIF>) getContext().getAttribute("cars" + NAME());
    }

    /**
     * @param request the HTTP POST request
     * @return the body of the request
     */
    String getBody(HttpServletRequest request) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return stringBuilder.toString();
    }

    //getContext().setAttribute(NAME())

    @Override
    public void destroy() {
        System.out.println("Servlet destroyed.");
    }

    public ParkhausLevelService getParkhausLevelService(){
        return parkhausLevelService;
    }
}