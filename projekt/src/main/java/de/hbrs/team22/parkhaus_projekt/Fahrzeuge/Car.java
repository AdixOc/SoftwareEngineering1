package de.hbrs.team22.parkhaus_projekt.Fahrzeuge;

public class Car implements CarIF {
    private final int nr;
    private final long timer;
    private final long duration;
    private final double price;
    private final String hash;
    private final String color;
    // Quasi wie viel das Gerät an Platz braucht (space units)
    private final int space;
    private final String client_category;
    private final String vehicle_type;
    private final String license;
    private final long begin;

    public Car(int nr, long timer, long duration, double price/*Preis in Cent*/, String hash, String color, int space, String client_category, String vehicle_type, String license, long begin) {
        this.nr = nr;
        this.timer = timer;
        this.duration = duration;
        this.price = price / 100.0d;
        this.hash = hash;
        this.color = color;
        this.space = space;
        this.client_category = client_category;
        this.vehicle_type = vehicle_type;
        this.license = license;
        this.begin = begin;
    }

    public Car() {
        this(0, 0, 0, 0.0, "", "", 0, "", "", "", 0);
    }

    public int getNr() {
        return nr;
    }

    public long getTimer() {
        return timer;
    }

    public long getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    public String getHash() {
        return hash;
    }

    public String getColor() {
        return color;
    }

    public int getSpace() {
        return space;
    }

    public String getClient_category() {
        return client_category;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public String getLicense() {
        return license;
    }

    public long getBegin() {
        return begin;
    }

    @Override
    public long getEnd() {
        return begin + duration;
    }

    @Override
    public String toString(){
        return "Car: " + getNr();
    }
}
