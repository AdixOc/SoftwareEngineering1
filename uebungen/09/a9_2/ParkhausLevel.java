package de.hbrs.team22.parkhaus_projekt;

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

    public void leave(Car car) {
        cars.remove(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
