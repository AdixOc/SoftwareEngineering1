package de.hbrs.team22.parkhaus_projekt.service;

import de.hbrs.team22.parkhaus_projekt.Fahrzeuge.Car;
import de.hbrs.team22.parkhaus_projekt.Parkhaus;
import de.hbrs.team22.parkhaus_projekt.ParkhausLevel;
import de.hbrs.team22.parkhaus_projekt.ParkhausServlet;

import javax.naming.NameNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ParkhausLevelService {
    final ParkhausServlet parkhausServlet;
    final List<ParkhausLevel> levels;

    public ParkhausLevelService(ParkhausServlet parkhausServlet) {
        this.parkhausServlet = parkhausServlet;
        this.levels = new ArrayList<>();
    }

    public void createParkhausLevelIfNotExists(String name, int capacity, double price) {
        if (parkhausServlet.getContext().getAttribute("Parkhaus") == null) {
            parkhausServlet.getContext().setAttribute("Parkhaus", new Parkhaus());
        }
        if (!((Parkhaus) parkhausServlet.getContext().getAttribute("Parkhaus")).isLevelPresentByName(name)) {
            ParkhausLevel level = new ParkhausLevel(name, capacity, price);
            ((Parkhaus) parkhausServlet.getContext().getAttribute("Parkhaus")).addLevel(level);
            registerLevel(level);
        }
    }

    public boolean registerLevel(ParkhausLevel level) {
        if (levels.contains(level)) {
            return false;
        }
        // levels add always returns true which we want here
        return levels.add(level);
    }

    public void addCar(String levelname, Car car) {
        if (parkhausServlet.getContext().getAttribute("cars" + levelname) == null) {
            parkhausServlet.getContext().setAttribute("cars" + levelname, new ArrayList<Car>());
        }

        Parkhaus parkhaus = (Parkhaus) parkhausServlet.getContext().getAttribute("Parkhaus");
        ParkhausLevel level = parkhaus.getLevelByName(levelname);
        if (level == null) {
            throw new IllegalArgumentException("ParkhausLevel " + levelname + " does not exist");
        }

        if (level.getFreePlaces() == 0) {
            throw new IllegalStateException("ParkhausLevel " + levelname + " is full");
        }

        level.enter(car);
        save(parkhaus);
    }

    public Car removeCar(String levelname, Car carToRemove) {
        Parkhaus parkhaus = (Parkhaus) parkhausServlet.getContext().getAttribute("Parkhaus");
        ParkhausLevel level = parkhaus.getLevelByName(levelname);
        Car oldCar = null;
        // If car did not exist, einfach returnen, hab jetzt keine Lust mir hierfür ne Fehlerbehandlung auszudenken
        try {
            oldCar = level.getCarByNumber(carToRemove.getNr());
        } catch (NameNotFoundException e) {
            return carToRemove;
        }
        double price = 0.0d;

        price = carToRemove.getPrice();
        parkhausServlet.getContext().setAttribute("sum" + levelname, getSum(levelname) + price);
        var avg = getAvg(levelname);
        if (avg == 0.0f) {
            parkhausServlet.getContext().setAttribute("avg" + levelname, price);
        } else {
            parkhausServlet.getContext().setAttribute("avg" + levelname, (getAvg(levelname) + price) / 2);
        }


        if (carToRemove.getClient_category().equals("Business"))
            parkhausServlet.getContext().setAttribute("business" + levelname, getBusiness(levelname) + 1);

        level.leave(oldCar);
        save(parkhaus);
        return oldCar;
    }

    public List<ParkhausLevel> getLevels() {
        return levels;
    }

    public Double getSum(String levelname) {
        Double sum = (Double) parkhausServlet.getContext().getAttribute("sum" + levelname);
        if (sum == null) {
            return 0.0;
        }

        return sum;
    }

    public Double getAvg(String levelname) {
        Double avg = (Double) parkhausServlet.getContext().getAttribute("avg" + levelname);
        if (avg == null) {
            return 0.0;
        }

        return avg;
    }

    public Integer getBusiness(String levelname) {
        Integer anzahlBiz = (Integer) parkhausServlet.getContext().getAttribute("business" + levelname);
        if (anzahlBiz == null) {
            return 0;
        }

        return anzahlBiz;
    }

    void save(Parkhaus parkhaus) {
        parkhausServlet.getContext().setAttribute("Parkhaus", parkhaus);
    }
}
