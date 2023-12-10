package de.hbrs.team22.parkhaus_projekt.Fahrzeuge;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class Fahrzeugtypen {
    static HashMap<String, Car> cars;
    static {
        cars = new HashMap<>();
        cars.put("PKW", new Car());
        cars.put("Pickup", new Car());
        cars.put("SUV", new Car());
        cars.put("Zweirad", new Car());
        cars.put("Trike", new Car());
        cars.put("Quad", new Car());
    }

    public static Car getCar(String name) {
        return cars.get(name);
    }

    public static List<String> getCarNames() {
        return new LinkedList<>(cars.keySet());
    }
}
