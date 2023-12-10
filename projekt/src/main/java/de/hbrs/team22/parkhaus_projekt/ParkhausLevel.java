package de.hbrs.team22.parkhaus_projekt;

import de.hbrs.team22.parkhaus_projekt.Fahrzeuge.Car;

import javax.naming.NameNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class ParkhausLevel {
    private final String name;
    private final int capacity;
    private final double price;
    private final List<Car> cars;

    public ParkhausLevel(String name, int capacity, double price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.cars = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    public int getFreePlaces() {
        return capacity - cars.size();
    }

    public int getOccupiedPlaces() {
        return cars.size();
    }

    public void enter(Car car) {
        cars.add(car);
    }

    public Car getCarByNumber(int nr) throws NameNotFoundException {
        for (Car car : cars) {
            if (car.getNr() == nr) {
                return car;
            }
        }
        throw new NameNotFoundException("Car with number " + nr + " does not exist");
    }

    public void leave(Car car) {
        cars.remove(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
